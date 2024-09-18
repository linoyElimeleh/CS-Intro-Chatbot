import certifi
import os

os.environ["SSL_CERT_FILE"] = certifi.where()

from dotenv import load_dotenv

load_dotenv()
from langchain_community.document_loaders import UnstructuredPowerPointLoader
from langchain.text_splitter import RecursiveCharacterTextSplitter

# from langchain_community.document_loaders import ReadTheDocsLoader
from langchain_openai import OpenAIEmbeddings
from langchain_pinecone import PineconeVectorStore

embeddings = OpenAIEmbeddings(model="text-embedding-3-small")


# Trnslate the data into pinecone
# todo update it to read from goggle drive
def ingest_docs():
    base_path = "intro-to-cs-public/lectures"
    documents = []

    # Iterate through all .pptx files in the folder
    for root, dirs, files in os.walk(base_path):
        for file in files:
            if file.endswith(".pptx"):
                file_path = os.path.join(root, file)
                loader = UnstructuredPowerPointLoader(file_path)
                try:
                    raw_documents = loader.load()
                    print(f"Loaded {len(raw_documents)} documents from {file_path}")
                    documents.extend(raw_documents)
                except Exception as e:
                    print(f"Error loading {file_path}: {str(e)}")

    print(f"Total loaded documents: {len(documents)}")

    text_splitter = RecursiveCharacterTextSplitter(chunk_size=600, chunk_overlap=50)
    split_documents = text_splitter.split_documents(documents)

    print(f"Going to add {len(split_documents)} to Pinecone")
    PineconeVectorStore.from_documents(
        split_documents, embeddings, index_name="cs-intro-chatbot"
    )
    print("****Loading to vectorstore done ***")


if __name__ == "__main__":
    ingest_docs()
