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
        st.subheader("User Information")
        st.write(f"Logged in as: {user_email}")
        if st.button("Logout"):
            logout_user()
            st.rerun()

        st.markdown("<hr>", unsafe_allow_html=True)
        st.title("Chat History")

        for i, chat in enumerate(loaded_history):
            if st.button(f"Chat {i+1}: {chat['title'][:30]}...", key=f"chat_button_{i}"):
                st.session_state.current_chat = i

        if st.button("Create New Chat", key="new_chat_button"):
            new_chat = {"title": "Create New Chat", "messages": []}
            st.session_state.chat_history.append(new_chat)
            st.session_state.current_chat = len(
                st.session_state.chat_history) - 1
            save_chat_history(user_email, st.session_state.chat_history)

        st.markdown("<hr>", unsafe_allow_html=True)
        st.sidebar.markdown("""
**© 2024 All rights reserved To Linoy Gabay.**

To report issues, please contact: [Linoy Gabay](mailto:lino1998y@gmail.com)
""")


__all__ = ['chat_interface']
