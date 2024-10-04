import certifi
import os

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

embeddings = OpenAIEmbeddings(model="text-embedding-3-small")


# Trnslate the data into pinecone
# todo update it to read from goggle drive
def ingest_docs():
    base_path = "intro-to-cs-public/lectures"
    documents = []

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
        documents, embeddings, index_name="cs-intro-chatbot"
    )
    print("****Loading to vectorstore done ***")


if __name__ == "__main__":
    ingest_docs()
