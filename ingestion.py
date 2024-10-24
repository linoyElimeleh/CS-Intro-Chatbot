import logging
import certifi
import os
from pinecone import Pinecone, ServerlessSpec
import pinecone
from pinecone.exceptions import NotFoundException


os.environ["SSL_CERT_FILE"] = certifi.where()

from dotenv import load_dotenv

load_dotenv()
from langchain_community.document_loaders import (
    UnstructuredPowerPointLoader,
    TextLoader,
)
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain.schema import Document
from pptx import Presentation

# from langchain_community.document_loaders import ReadTheDocsLoader
from langchain_openai import OpenAIEmbeddings
from langchain_pinecone import PineconeVectorStore

logger = logging.getLogger(__name__)
embeddings = OpenAIEmbeddings(model="text-embedding-3-small")


# Trnslate the data into pinecone
# todo update it to read from goggle drive
def ingest_docs():
    try:
        clear_pinecone_vector_store()
        # Rest of your ingestion code...
    except Exception as e:
        logger.error(f"Error during document ingestion: {str(e)}")
        # Optionally, you might want to re-raise the exception or handle it differently

    base_path = "intro-to-cs-public/lectures"
    documents = []

    logger.info(f"Start ingesting docs from {base_path}")

    # Iterate through all .pptx files in the folder
    for root, dirs, files in os.walk(base_path):
        for file in files:
            if file.endswith((".pptx", ".java")):
                file_path = os.path.join(root, file)
                try:
                    if file.endswith(".pptx"):
                        prs = Presentation(file_path)
                        for i, slide in enumerate(prs.slides):
                            slide_content = ""
                            for shape in slide.shapes:
                                if hasattr(shape, 'text'):
                                    slide_content += shape.text + "\n"
                            if slide_content.strip():
                                documents.append(Document(
                                    page_content=slide_content.strip(),
                                    metadata={"source": f"{file_path}:Slide{i+1}"}
                                ))
                    else:  # .java file
                        loader = TextLoader(file_path)
                        content = loader.load()[0].page_content
                        # Split Java files by double newlines (usually separates methods/classes)
                        java_splitter = RecursiveCharacterTextSplitter(
                            separators=["\n\n"],
                            chunk_size=1000,
                            chunk_overlap=0
                        )
                        java_docs = java_splitter.create_documents([content])
                        for i, doc in enumerate(java_docs):
                            doc.metadata["source"] = f"{file_path}:Section{i+1}"
                        documents.extend(java_docs)
                    print(f"Processed {file_path}")
                except Exception as e:
                    print(f"Error processing {file_path}: {str(e)}")

    print(f"Total processed documents: {len(documents)}")

    # Ensure each document has a unique source attribute
    for i, doc in enumerate(documents):
        if not hasattr(doc, 'metadata') or 'source' not in doc.metadata:
            doc.metadata['source'] = f"document_{i}"

    print(f"Going to add {len(documents)} to Pinecone")
    PineconeVectorStore.from_documents(
        documents, embeddings, index_name=os.getenv("PINECONE_INDEX_NAME")
    )
    print("****Loading to vectorstore done ***")


def clear_pinecone_vector_store():
    try:
        # Initialize Pinecone with API key and environment
        pc = Pinecone(
            api_key=os.getenv("PINECONE_API_KEY")
        )
        # Initialize the index with the name and no need for explicit host
        index_name = os.getenv("PINECONE_INDEX_NAME")
        
        index = pc.Index(index_name)

        # Delete all vectors in the index
        index.delete(delete_all=True)
        logger.info("Pinecone vector store cleared successfully.")
    
    except pinecone.exceptions.NotFoundException:
        logger.warning("Pinecone index not found. It may have already been deleted or not yet created.")
    
    except Exception as e:
        logger.error(f"Error clearing Pinecone vector store: {str(e)}")


if __name__ == "__main__":
    ingest_docs()
