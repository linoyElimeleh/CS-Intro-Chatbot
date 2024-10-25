import streamlit as st
from ingestion import clear_pinecone_vector_store, ingest_docs
from views.header import render_title_and_logo
from views.login import login_interface
from views.main_chat import chat_interface
from utils import is_user_logged_in
import logging

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)


def main():

    logger.info("Starting Streamlit app")
    
    render_title_and_logo()
    
    if "chat_history" not in st.session_state:
        st.session_state.chat_history = []

    if is_user_logged_in():
        logger.info("User is logged in")
        chat_interface()
    else:
        logger.info("User is not logged in")
        # if "ingestion_done" not in st.session_state:
        #     logger.info("Running document ingestion")
        #     ingest_docs()
        #     st.session_state.ingestion_done = True
        login_interface()

if __name__ == "__main__":
    main()
