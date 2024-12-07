import logging
import streamlit as st
from backend.core import run_llm
from views.feedback import display_feedback_panel
from views.header import render_header
from views.login import get_user_email
from views.sidebar import sidebar_view
from views.history import initialize_chat_history, load_chat_history, save_chat_history
from firebase_admin import firestore
import datetime

db = firestore.client()
logger = logging.getLogger(__name__)
logger.setLevel(logging.INFO)


def chat_interface():
    logger.info("Chat Interface Initialized")

    load_css()
    render_header()

    user_email = get_user_email()

    sidebar_view(user_email)
    display_main_chat_area(user_email)

    handle_user_input(user_email)


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)


def display_main_chat_area(user_email):
    current_chat = get_current_chat(user_email)

    for message in current_chat["messages"]:
        with st.chat_message(message["role"]):
            st.write(message["content"])

            if message["role"] == "ai":
                sources = message.get("sources")
                if sources:
                    display_sources(message)
                else:
                    st.write("No sources available.")


def get_current_chat(user_email):
    if "current_chat" in st.session_state and 0 <= st.session_state.current_chat < len(st.session_state.chat_history):
        return st.session_state.chat_history[st.session_state.current_chat]
    else:
        add_new_chat(user_email)
        return st.session_state.chat_history[st.session_state.current_chat]


def handle_user_input(user_email):
    current_chat = get_current_chat(user_email)

    if prompt := st.chat_input("Ask me anything about Introduction To Computer Science Course..."):
        save_user_question(user_email, prompt)

        update_chat_title(current_chat, prompt)
        current_chat["messages"].append({"role": "human", "content": prompt})
        st.chat_message("human").write(prompt)

        response = get_ai_response(
            prompt, current_chat["messages"], user_email)

        serializable_sources = [
            {
                "page_content": doc.page_content,
                "metadata": doc.metadata
            } for doc in response.get("source_documents", [])
        ]
        response["sources"] = serializable_sources

        display_ai_response(response, user_email, prompt)

        ai_message = {
            "role": "ai",
            "content": response["result"],
            "sources": response["sources"]
        }
        current_chat["messages"].append(ai_message)

    save_chat_history(user_email, st.session_state.chat_history)


def update_chat_title(chat, prompt):
    if not chat["messages"]:
        chat["title"] = prompt[:30] + "..."


def get_ai_response(prompt, messages, user_email):
    with st.spinner("Thinking..."):
        return run_llm(prompt, messages, user_email)


def display_ai_response(response, user_email, prompt):
    result = response["result"]
    ai_message = st.chat_message("ai")

    if "```" in result:
        # Split the response by code sections
        parts = result.split("```")
        for i, part in enumerate(parts):
            if i % 2 == 0:
                # Display normal text
                ai_message.write(part.strip())
            else:
                # Display code with syntax highlighting
                ai_message.code(part.strip(), language="java")
    else:
        # Display the entire response as text if no code blocks are detected
        ai_message.write(result)

    # Display sources if available
    if response.get("sources"):
        display_sources(response)

    display_feedback_panel(prompt, result, user_email)


def display_sources(response):
    with st.expander("Sources (click to expand)", expanded=False):
        for i, source in enumerate(response["sources"], 1):
            st.markdown(f"**Source {i}:**")
            # Display the entire source content as code if it doesn't contain specific formatting
            if "```" in source['page_content']:
                # Split the source content by code sections
                source_parts = source['page_content'].split("```")
                for j, part in enumerate(source_parts):
                    if j % 2 == 0:
                        # Display normal text
                        st.write(part.strip())
                    else:
                        # Display code with syntax highlighting
                        st.code(part.strip(), language="java")
            else:
                # Display the entire source content as code if no code blocks are detected
                st.code(source['page_content'], language="java")

            st.markdown(
                f"- **Source Location:** {source['metadata']['source']}")


def save_user_question(user_email, question):
    """
    Saves the user's question to Firestore.
    """
    timestamp = datetime.datetime.utcnow()
    db.collection("user_questions").add({
        "user_email": user_email,
        "question": question,
        "timestamp": timestamp
    })
    logger.info(f"User question saved: {question}")


def add_new_chat(user_email):
    """Create a new chat and set it as the current chat."""
    new_chat = {"title": "New Chat", "messages": []}

    # Ensure chat history exists
    if "chat_history" not in st.session_state:
        st.session_state.chat_history = []

    # Add the new chat and set it as current
    st.session_state.chat_history.append(new_chat)
    st.session_state.current_chat = len(st.session_state.chat_history) - 1

    # Save the updated chat history to Firestore
    save_chat_history(user_email, st.session_state.chat_history)


__all__ = ['chat_interface']
