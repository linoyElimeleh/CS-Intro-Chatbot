from backend.core import run_llm
import streamlit as st
from views.header import render_header
from utils import is_user_logged_in, get_user_email, save_chat_history
import logging
import json

from views.sidebar import sidebar_view

logger = logging.getLogger(__name__)

def chat_interface():
    logger.info("Chat Interface")
    load_css()
    render_header()

    check_user_login()
    user_email = get_user_email()

    sidebar_view(user_email)
    display_main_chat_area()

    handle_user_input(user_email)

def check_user_login():
    if not is_user_logged_in():
        logger.info("User is not logged in")
        st.rerun()
        return False
    logger.info("User is logged in")
    return True

def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)
   
def display_main_chat_area():
    st.title("What can I help with?")
    current_chat = get_current_chat()
    logging.info("Current chat details: %s", json.dumps(current_chat, indent=4))  # More detailed log

    for message in current_chat["messages"]:
        with st.chat_message(message["role"]):
            st.write(message["content"])

            # If the message is from AI, we check for sources
            if message["role"] == "ai":
                sources = message.get("sources")
                if sources:
                    # Using an expander to collapse the sources by default
                    with st.expander("Sources (click to expand)", expanded=False):
                        for i, source in enumerate(sources, 1):
                            st.write(f"**Source {i}:**")
                            st.markdown(f"- **Content:** {source['page_content']}")
                            st.markdown(f"- **Source Location:** {source['metadata']['source']}")
                else:
                    st.write("No sources available.")


def get_current_chat():
    if 0 <= st.session_state.current_chat < len(st.session_state.chat_history):
        return st.session_state.chat_history[st.session_state.current_chat]
    else:
        new_chat = {"title": "New Chat", "messages": []}
        st.session_state.chat_history.append(new_chat)
        st.session_state.current_chat = len(st.session_state.chat_history) - 1
        return new_chat

def handle_user_input(user_email):
    current_chat = get_current_chat()
    if prompt := st.chat_input("Ask me anything about Computer Science, AI, or programming..."):
        update_chat_title(current_chat, prompt)
        add_message_to_chat(current_chat, "human", prompt)
        
        response = get_ai_response(prompt, current_chat["messages"], user_email)

        # Convert source documents to serializable format
        serializable_sources = [
            {
                "page_content": doc.page_content,
                "metadata": doc.metadata
            } for doc in response.get("source_documents", [])
        ]
        
        # Update response with serializable sources
        response["sources"] = serializable_sources

        display_ai_response(response)
        
        # Save AI response with serializable sources
        ai_message = {
            "role": "ai",
            "content": response["result"],
            "sources": response["sources"]
        }

        current_chat["messages"].append(ai_message)
    
        # add_message_to_chat(current_chat, "ai", prompt)
        
    save_chat_history(user_email, st.session_state.chat_history)

def update_chat_title(chat, prompt):
    if not chat["messages"]:
        chat["title"] = prompt[:30] + "..."

def add_message_to_chat(chat, role, content):
    chat["messages"].append({"role": role, "content": content})
    st.chat_message(role).write(content)

def get_ai_response(prompt, messages, user_email):
    with st.spinner("Thinking..."):
        return run_llm(prompt, messages, user_email)

def display_ai_response(response):
    ai_message = st.chat_message("ai")
    ai_message.write(response["result"])
    
    display_sources(response, ai_message)

def display_sources(response, ai_message):
    sources = response.get("sources")
    if sources:
        with ai_message.expander("Sources (click to expand)", expanded=False):  # Collapsed by default
            st.write("### Sources:")
            for i, source in enumerate(sources, 1):
                st.write(f"**Source {i}**")
                st.markdown(f"- **Content:** {source['page_content']}")
                st.markdown(f"- **Source Location:** {source['metadata']['source']}")
                st.markdown("---")  # Add a separator between different sources for clarity
    else:
        with ai_message.expander("Sources (click to expand)", expanded=False):
            st.write("No sources found for this response.")


__all__ = ['chat_interface']
