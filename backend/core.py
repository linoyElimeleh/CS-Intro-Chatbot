from dotenv import load_dotenv
from typing import Dict, List
from langchain.chains import ConversationalRetrievalChain
from langchain_openai import ChatOpenAI, OpenAIEmbeddings
from langchain_pinecone import PineconeVectorStore
from langchain.prompts import PromptTemplate
import os

load_dotenv()


def run_llm(query: str, chat_history: List[Dict[str, str]], user_email: str):
    embeddings = OpenAIEmbeddings(model="text-embedding-3-small")
    vectorstore = PineconeVectorStore.from_existing_index(
        index_name=os.getenv("PINECONE_INDEX_NAME"), embedding=embeddings
    )

    # Define the custom prompt
    custom_prompt = PromptTemplate(
        input_variables=["context", "question", "chat_history"],
        template="""You are an AI assistant for the "Introduction to Computer Science" course. 
        Use the following context from the course materials to answer the question. 
        If the answer is not in the context, say "I can't find specific information about that in the course materials."

        Context: {context}
        Chat History: {chat_history}
        Human: {question}
        AI Assistant: """
    )

    qa = ConversationalRetrievalChain.from_llm(
        llm=ChatOpenAI(temperature=0, model_name="gpt-3.5-turbo"),
        retriever=vectorstore.as_retriever(search_kwargs={"k": 3}),
        return_source_documents=True,
        combine_docs_chain_kwargs={"prompt": custom_prompt}
    )

    # Format chat history
    paired_history = format_chat_history(chat_history)

    result = qa({"question": query, "chat_history": paired_history})

    if "I can't find specific information about that in the course materials" in result["answer"]:
        chatgpt_response = get_chatgpt_response(query)
        result["answer"] = f"I couldn't find answers to your question in our course materials. However, here's a general answer from ChatGPT:\n\n{chatgpt_response}"
        result["source_documents"] = []
    
    return {
        "result": result["answer"],
        "source_documents": result["source_documents"],
        "chat_history": chat_history + [{"role": "human", "content": query}, {"role": "ai", "content": result["answer"]}],
    }

def format_chat_history(chat_history):
    formatted_history = [(msg['content'], '') for msg in chat_history if msg['role'] == 'human']
    formatted_history += [(', ' + msg['content']) for msg in chat_history if msg['role'] == 'ai']
    
    paired_history = []
    for i in range(0, len(formatted_history), 2):
        if i+1 < len(formatted_history):
            paired_history.append((formatted_history[i][0], formatted_history[i+1][0]))
        else:
            paired_history.append((formatted_history[i][0], ''))
    return paired_history

def get_chatgpt_response(query: str) -> str:
    # Initialize the LangChain ChatOpenAI instance with the model name and parameters
    llm = ChatOpenAI(
        model_name="gpt-3.5-turbo",  # Specify the chat model
        temperature=0.7,  # Adjust temperature for randomness
        max_tokens=150  # Limit the response length if needed
    )

    # Create the response using the LangChain interface
    response = llm.generate([query])

    # Return the assistant's reply
    return response.generations[0][0].text


if __name__ == "__main__":
    res = run_llm(query="What is a LangChain Chain?", chat_history=[], user_email="")
    print(res["result"])
