import logging
import streamlit as st
from backend.core import run_llm
from views.header import render_header
from views.login import get_user_email
from views.sidebar import sidebar_view
from views.history import save_chat_history

logger = logging.getLogger(__name__)


def chat_interface():
    logger.info("Chat Interface Initialized")

    load_css()
    render_header()

    user_email = get_user_email()

    sidebar_view(user_email)
    display_main_chat_area()

    handle_user_input(user_email)


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)


def display_main_chat_area():
    current_chat = get_current_chat()

    for message in current_chat["messages"]:
        with st.chat_message(message["role"]):
            st.write(message["content"])

            if message["role"] == "ai":
                sources = message.get("sources")
                if sources:
                    display_sources(message)
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

    if prompt := st.chat_input("Ask me anything about Introduction To Computer Science Course..."):
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

        display_ai_response(response)

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


def display_ai_response(response):

    ai_message = st.chat_message("ai")

    if "```" in response["result"]:
        # Split the response by code sections
        parts = response["result"].split("```")
        for i, part in enumerate(parts):
            if i % 2 == 0:
                # Display normal text
                ai_message.write(part.strip())
            else:
                # Display code with syntax highlighting
                ai_message.code(part.strip(), language="java")
    else:
        # Display the entire response as text if no code blocks are detected
        ai_message.write(response["result"])

    # Display sources if available
    if response.get("sources"):
        display_sources(response)


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


__all__ = ['chat_interface']
