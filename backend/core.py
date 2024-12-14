from dotenv import load_dotenv
from typing import Dict, List
from langchain.chains import ConversationalRetrievalChain
from langchain_openai import ChatOpenAI, OpenAIEmbeddings
from langchain_pinecone import PineconeVectorStore
from langchain.prompts import PromptTemplate
import os

load_dotenv()


def run_llm(query: str, chat_history: List[Dict[str, str]], user_email: str):
    embeddings = OpenAIEmbeddings(model="text-embedding-ada-002")
    vectorstore = PineconeVectorStore.from_existing_index(
        index_name=os.getenv("PINECONE_INDEX_NAME"), embedding=embeddings
    )

    custom_prompt = PromptTemplate(
        input_variables=["context", "question", "chat_history"],
        template="""You are an AI assistant for the "Introduction to Computer Science in Java langauge" course. 
Use the provided course materials (DB context) to answer the question clearly and concisely. 

### Guidelines:
1. Search specifically for the lecture number, week, or topic mentioned in the question within the provided DB context or metadata for example for question like "what did we learned in week 1?" You will give a summery / topics from the files the name contains "week 1".
2. If the question involves code, provide examples formatted with triple backticks (```).
3. If the question is unclear, infer related questions based on the context and answer accordingly.
4. If no relevant match is found in the context, respond: "I can't find specific information about that in the course materials."

### Important:
Focus on extracting **specific details** relevant to the question from the provided DB context or file metadata.

### Provided Context:
{context}

### Chat History:
{chat_history}

### Human's Question:
{question}

### Your Answer:
"""
    )

    qa = ConversationalRetrievalChain.from_llm(
        llm=ChatOpenAI(temperature=0.7, model_name="gpt-4"),
        retriever=vectorstore.as_retriever(search_kwargs={"k": 3}),
        return_source_documents=True,
        combine_docs_chain_kwargs={"prompt": custom_prompt}
    )

    # Format chat history
    paired_history = format_chat_history(chat_history)

    result = qa({"question": query, "chat_history": paired_history})
   
    if "I can't find specific information about that in the course materials" in result["answer"]:
        chatgpt_response = get_chatgpt_response(query, chat_history)
        result["answer"] = f"""I couldn't find answers to your question in the course materials. Here's a general explanation from ChatGPT:

{chatgpt_response}

If you need further assistance, please ask a different question."""
        result["source_documents"] = []
        
    return {
        "result": result["answer"],
        "source_documents": result["source_documents"],
        "chat_history": chat_history + [{"role": "human", "content": query}, {"role": "ai", "content": result["answer"]}],
    }


def format_chat_history(chat_history):
    paired_history = []
    for i in range(0, len(chat_history), 2):
        if i + 1 < len(chat_history):
            paired_history.append((chat_history[i]['content'], chat_history[i+1]['content']))
        else:
            paired_history.append((chat_history[i]['content'], ''))
    return paired_history


from langchain.prompts import PromptTemplate

def get_chatgpt_response(query: str, chat_history) -> str:
    custom_prompt = PromptTemplate(
        input_variables=["query","chat_history"],
        template="""
        You are an assistant for an "Introduction to Computer Science" course. 
        Focus on Java-related content and provide clear, concise answers with examples if possible.

        ### Chat History:
        {chat_history}

        ### Human's Question:
        {query}

        ### Your Answer:
        Answer:
        """
    )

    llm = ChatOpenAI(
        model_name="gpt-4",
        temperature=0.7,
        max_tokens=500
    )

    response = llm.generate([custom_prompt.format(query=query, chat_history=chat_history)])
    return response.generations[0][0].text


if __name__ == "__main__":
    res = run_llm(query="What is a LangChain Chain?",
                  chat_history=[], user_email="")
    print(res["result"])
