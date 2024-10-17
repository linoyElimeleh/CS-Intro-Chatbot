import streamlit as st
from views.login import login_interface
from views.chat import chat_interface
from utils import is_user_logged_in, get_cookie_manager
import logging

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)


def main():

    logger.info("Starting Streamlit app")
    # cookie_manager = get_cookie_manager()
    
    if "chat_history" not in st.session_state:
        st.session_state.chat_history = []

    if is_user_logged_in():
        logger.info("User is logged in")
        chat_interface()
    else:
        logger.info("User is not logged in")
        login_interface()

if __name__ == "__main__":
    main()
