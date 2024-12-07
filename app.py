import streamlit as st
from ingestion import clear_pinecone_vector_store, ingest_docs
from views.header import render_title_and_logo
from views.login import is_user_logged_in, login_interface
from views.main_chat import chat_interface
import logging
from dotenv import load_dotenv
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)
load_dotenv(override=True)


def main():

    logger.info("Starting Streamlit app")
    logger.info("--------------------------------")

    render_title_and_logo()

    # if "chat_history" not in st.session_state:
    #     st.session_state.chat_history = []

    # if "ingestion_done" not in st.session_state:
    #     logger.info("Running document ingestion")
    #     ingest_docs()
    #     st.session_state.ingestion_done = True

    # if "logged_in" not in st.session_state:
    #     st.session_state.logged_in = False

    if is_user_logged_in():
        chat_interface()
    else:
        login_interface()


if __name__ == "__main__":
    main()
