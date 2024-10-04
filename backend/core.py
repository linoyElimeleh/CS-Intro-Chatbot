from dotenv import load_dotenv
from langchain.chains.history_aware_retriever import create_history_aware_retriever
from langchain.chains.retrieval import create_retrieval_chain
from langchain.chains import ConversationalRetrievalChain
from langchain_openai import ChatOpenAI
from langchain_pinecone import PineconeVectorStore
import openai

load_dotenv()

from typing import Any, Dict, List

from langchain import hub
from langchain.chains.combine_documents import create_stuff_documents_chain
from langchain_pinecone import PineconeVectorStore

from langchain_openai import ChatOpenAI, OpenAIEmbeddings

from consts import INDEX_NAME


def run_llm(query: str, chat_history: List[Dict[str, Any]] = [], user_email: str = ""):
    embeddings = OpenAIEmbeddings(model="text-embedding-3-small")
    vectorstore = PineconeVectorStore.from_existing_index(
        index_name="cs-intro-chatbot", embedding=embeddings
    )

    qa = ConversationalRetrievalChain.from_llm(
        llm=ChatOpenAI(temperature=0, model_name="gpt-3.5-turbo"),
        retriever=vectorstore.as_retriever(),
        return_source_documents=True,
    )

    result = qa({"question": query, "chat_history": chat_history})

    # Check if the result is empty or doesn't contain relevant information
    if not result["source_documents"] or result["answer"].strip().lower().startswith("i don't have information"):
        # If no relevant information from the course, use ChatGPT
        chatgpt_response = get_chatgpt_response(query)
        result["answer"] = f"We haven't studied that in the course until now. Here is a result from ChatGPT: \n\n{chatgpt_response}"
        result["source_documents"] = []  # Clear source documents as they're not from the course

    return {
        "result": result["answer"],
        "source_documents": result["source_documents"],
        "chat_history": chat_history,
    }

def get_chatgpt_response(query: str) -> str:
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content": "You are a helpful assistant."},
            {"role": "user", "content": query}
        ]
    )
    return response.choices[0].message['content']


if __name__ == "__main__":
    res = run_llm(query="What is a LangChain Chain?")
    print(res["result"])
