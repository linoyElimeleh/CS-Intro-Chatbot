# Import necessary libraries
import logging
import json
import streamlit as st
from backend.core import run_llm
from views.header import render_header
from views.sidebar import sidebar_view
from utils import is_user_logged_in, get_user_email, save_chat_history

# Set up the logger
logger = logging.getLogger(__name__)

# Main function for the chat interface


def chat_interface():
    logger.info("Chat Interface Initialized")

    # Load custom CSS for the UI
    load_css()

    # Render the page header
    render_header()

    # Check if the user is logged in
    if not check_user_login():
        return

    # Retrieve user email
    user_email = get_user_email()

    # Render the sidebar view
    sidebar_view(user_email)

    # Display the main chat area
    display_main_chat_area()

    # Handle user input
    handle_user_input(user_email)

# Check if the user is logged in, redirect if not


def check_user_login():
    if not is_user_logged_in():
        logger.info("User is not logged in")
        st.rerun()  # Rerun Streamlit app if user is not logged in
        return False
    logger.info("User is logged in")
    return True

# Load custom CSS from a file


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)

# Display the main chat interface, including previous chat messages


def display_main_chat_area():
    # st.title("What can I help with?")
    current_chat = get_current_chat()

    # Log current chat details for debugging
    logger.info("Current chat details: %s", json.dumps(current_chat, indent=4))

    # Iterate through all messages in the current chat and display them
    for message in current_chat["messages"]:
        with st.chat_message(message["role"]):
            # Display the user's or AI's message content
            st.write(message["content"])

            # If the message is from AI, check and display sources if available
            if message["role"] == "ai":
                sources = message.get("sources")
                if sources:
                    display_sources(message)
                else:
                    st.write("No sources available.")

# Retrieve the current chat from the session state


def get_current_chat():
    if 0 <= st.session_state.current_chat < len(st.session_state.chat_history):
        return st.session_state.chat_history[st.session_state.current_chat]
    else:
        new_chat = {"title": "New Chat", "messages": []}
        st.session_state.chat_history.append(new_chat)
        st.session_state.current_chat = len(st.session_state.chat_history) - 1
        return new_chat

# Handle user input and pass it to the AI model for response


def handle_user_input(user_email):
    current_chat = get_current_chat()

    # Prompt user for input
    if prompt := st.chat_input("Ask me anything about Introduction To Computer Science Course..."):
        # Update chat title with the user prompt
        update_chat_title(current_chat, prompt)
        # Add user message to chat
        add_message_to_chat(current_chat, "human", prompt)

        # Get AI response
        response = get_ai_response(
            prompt, current_chat["messages"], user_email)

        # Serialize source documents for logging and display
        serializable_sources = [
            {
                "page_content": doc.page_content,
                "metadata": doc.metadata
            } for doc in response.get("source_documents", [])
        ]
        response["sources"] = serializable_sources

        # Display AI response and sources
        display_ai_response(response)

        # Save AI message to the chat history
        ai_message = {
            "role": "ai",
            "content": response["result"],
            "sources": response["sources"]
        }
        current_chat["messages"].append(ai_message)

    # Save the updated chat history
    save_chat_history(user_email, st.session_state.chat_history)

# Update the chat title with the user's first message


def update_chat_title(chat, prompt):
    if not chat["messages"]:
        chat["title"] = prompt[:30] + "..."

# Add a message to the chat from either the user or AI


def add_message_to_chat(chat, role, content):
    chat["messages"].append({"role": role, "content": content})
    st.chat_message(role).write(content)

# Get the AI response by calling the LLM with user input and chat history


def get_ai_response(prompt, messages, user_email):
    with st.spinner("Thinking..."):  # Show a spinner while AI processes the input
        return run_llm(prompt, messages, user_email)

# Display the AI response in the chat


def display_ai_response(response):
    ai_message = st.chat_message("ai")

    # Check if the response includes code examples
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

# Function to display sources


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


# Expose the chat interface function
__all__ = ['chat_interface']
