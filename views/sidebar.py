from backend.core import run_llm
import streamlit as st
from views.header import render_header
from utils import logout_user, is_user_logged_in, get_user_email, save_chat_history, load_chat_history, clear_chat_history
import logging

logger = logging.getLogger(__name__)

def sidebar_view(user_email, loaded_history):
    logger.info("SideBar Interface")

    with st.sidebar:

         # User information and logout (moved to the bottom of the sidebar)
        st.subheader("User Information")
        st.write(f"Logged in as: {user_email}")
        if st.button("Logout"):
            logout_user()
            st.rerun()

        # Add a horizontal line for separation
        st.markdown("<hr>", unsafe_allow_html=True)  

        # Chat History
        st.title("Chat History")

        # Display chat history titles
        for i, chat in enumerate(loaded_history):
            if st.button(f"Chat {i+1}: {chat['title'][:30]}...", key=f"chat_button_{i}"):
                st.session_state.current_chat = i

        if st.button("Create New Chat", key="new_chat_button"):
            new_chat = {"title": "Create New Chat", "messages": []}
            st.session_state.chat_history.append(new_chat)
            st.session_state.current_chat = len(st.session_state.chat_history) - 1
            save_chat_history(user_email, st.session_state.chat_history)

# Make sure to export the chat_interface function
__all__ = ['chat_interface']
