from typing import Set, List, Tuple
from backend.core import run_llm
import streamlit as st
from streamlit_chat import message
from views.header import render_header
import re
from pygments import highlight
from pygments.lexers import JavaLexer
from pygments.formatters import HtmlFormatter
import os
import extra_streamlit_components as stx
from utils import logout_user, is_user_logged_in, get_user_email
import logging

logger = logging.getLogger(__name__)

def chat_interface():
    load_css()
    render_header()

    logger.info("Chat Interface")
    if not is_user_logged_in():
        logger.info("User is not logged in")
        st.rerun()

    user_email = get_user_email()
    logger.info("User is logged in")


    # Initialize chat history if it doesn't exist
    if "chat_history" not in st.session_state:
        st.session_state.chat_history = []

    # Ensure there's always at least one chat
    if not st.session_state.chat_history:
        st.session_state.chat_history.append({"title": "New Chat", "messages": []})

    # Sidebar with chat history
    with st.sidebar:
        st.title("Chat History")
        st.write(f"Logged in as: {user_email}")
        if st.button("Logout", key="logout_button_sidebar"):
            logout_user()
            st.rerun()
        
        # Display chat history titles
        for i, chat in enumerate(st.session_state.chat_history):
            if st.button(f"Chat {i+1}: {chat['title'][:30]}...", key=f"chat_button_{i}"):
                st.session_state.current_chat = i
        
        # New chat button
        if st.button("New Chat", key="new_chat_button_sidebar"):
            st.session_state.current_chat = len(st.session_state.chat_history)
            st.session_state.chat_history.append({"title": "New Chat", "messages": []})

    # Main chat area
    st.title("What can I help with?")

    # Ensure current_chat is set
    if "current_chat" not in st.session_state:
        st.session_state.current_chat = 0

    current_chat = st.session_state.chat_history[st.session_state.current_chat]

    # Display current chat messages
    for message in current_chat["messages"]:
        with st.chat_message(message["role"]):
            st.write(message["content"])

    # Chat input
    if prompt := st.chat_input("What is your question?"):
        # Update chat title if it's the first message
        if not current_chat["messages"]:
            current_chat["title"] = prompt[:30] + "..."

        # Add user message to chat history
        current_chat["messages"].append({"role": "human", "content": prompt})
        st.chat_message("human").write(prompt)

        # Show spinner while waiting for AI response
        with st.spinner("Thinking..."):
            # Get AI response
            response = run_llm(prompt, current_chat["messages"], user_email)
        
        # Add AI response to chat history
        current_chat["messages"].append({"role": "ai", "content": response["result"]})
        ai_message = st.chat_message("ai")
        ai_message.write(response["result"])

        # Display sources if available
        if response.get("source_documents"):
            st.write("Debug: Sources found")
            with ai_message.expander("Sources"):
                for i, source in enumerate(response["source_documents"], 1):
                    st.markdown(f"**Source {i}:**")
                    st.write(f"Content: {source.page_content}")
                    st.write(f"Metadata: {source.metadata}")
                    st.write("---")
        else:
            st.write("Debug: No sources found")

        # # Force a rerun to update the chat display
        # st.rerun()


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)


# Make sure to export the chat_interface function
__all__ = ['chat_interface']
