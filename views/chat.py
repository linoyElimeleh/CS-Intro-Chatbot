from typing import Set
from backend.core import run_llm
import streamlit as st
from streamlit_chat import message
from views.header import render_header
import re
from pygments import highlight
from pygments.lexers import JavaLexer
from pygments.formatters import HtmlFormatter


def main_chat_interface():
    st.set_page_config(layout="wide")

    load_css()
    render_header()

    # Content area
    st.markdown('<div class="content">', unsafe_allow_html=True)

    # Sidebar with user information
    with st.sidebar:
        st.header("User Information")
        st.write(f"Email: {st.session_state['user_email']}")
        if st.button("Logout"):
            st.session_state["logged_in"] = False
            st.session_state["user_email"] = None
            st.rerun()

    # st.header("CS Introduction To Computer Science Course- ChatBot")

    prompt = st.chat_input(
        placeholder="Enter your question here..",
        key=None,
        max_chars=None,
        disabled=False,
        on_submit=None,
        args=None,
        kwargs=None,
    )

    if (
        "chat_answers_history" not in st.session_state
        and "user_prompt_history" not in st.session_state
        and "chat_history" not in st.session_state
    ):
        st.session_state["chat_answers_history"] = []
        st.session_state["user_prompt_history"] = []
        st.session_state["chat_history"] = []

    def create_sources_string(source_urls: Set[str]) -> str:
        if not source_urls:
            return ""
        sources_list = list(source_urls)
        sources_list.sort()
        sources_string = "sources:\n"
        for i, source in enumerate(sources_list):
            sources_string += f"{i + 1}. {source}\n"
        return sources_string

    if prompt:
        with st.spinner("Generating response.."):
            generated_response = run_llm(
                query=prompt,
                chat_history=st.session_state["chat_history"],
                user_email=st.session_state["user_email"],
            )
            sources = set(
                [
                    doc.metadata["source"]
                    for doc in generated_response["source_documents"]
                ]
            )

            formatted_response = (
                f"{generated_response['result']} \n\n {create_sources_string(sources)}"
            )

            st.session_state["user_prompt_history"].append(prompt)
            st.session_state["chat_answers_history"].append(formatted_response)
            st.session_state["chat_history"].append(("human", prompt))
            st.session_state["chat_history"].append(
                ("ai", generated_response["result"])
            )

    if st.session_state["chat_answers_history"]:
        for generated_response, user_query in zip(
            st.session_state["chat_answers_history"],
            st.session_state["user_prompt_history"],
        ):
            message(user_query, is_user=True)
            message(format_message(generated_response), allow_html=True)


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)


def format_message(content):
    # Function to replace code blocks with syntax highlighted HTML
    def replace_code_block(match):
        code = match.group(1)
        highlighted = highlight(code, JavaLexer(), HtmlFormatter(style="friendly"))
        return f'<pre style="background-color: #f0f0f0; padding: 10px; border-radius: 5px;">{highlighted}</pre>'

    # Replace ```java ... ``` blocks with highlighted HTML
    formatted = re.sub(r"```java(.*?)```", replace_code_block, content, flags=re.DOTALL)
    return formatted