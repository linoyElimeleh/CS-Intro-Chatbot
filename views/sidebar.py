import streamlit as st
from utils import load_chat_history, logout_user, save_chat_history
import logging

from views.chat_history import initialize_chat_history

logger = logging.getLogger(__name__)

def sidebar_view(user_email):
    logger.info("SideBar Interface")

    loaded_history = load_chat_history(user_email)
    initialize_chat_history(loaded_history)

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


        # Add a horizontal line for separation
        st.markdown("<hr>", unsafe_allow_html=True)  
        st.sidebar.markdown("""
**© 2024 Linoy Gabay. All rights reserved.**

For inquiries or to report issues, please contact: [Linoy Gabay](mailto:lino1998y@gmail.com)
""")


# Make sure to export the chat_interface function
__all__ = ['chat_interface']

