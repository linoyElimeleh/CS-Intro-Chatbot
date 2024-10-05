import streamlit as st
from views.chat import main_chat_interface
from views.login import login_interface
import logging

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

logger.info("Starting Streamlit app")

if __name__ == "__main__":
    if "logged_in" not in st.session_state:
        st.session_state["logged_in"] = False

    if st.session_state["logged_in"]:
        main_chat_interface()
    else:
        login_interface()
