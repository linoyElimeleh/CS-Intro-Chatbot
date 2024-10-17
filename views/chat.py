from backend.core import run_llm
import streamlit as st
from views.header import render_header
from utils import logout_user, is_user_logged_in, get_user_email, save_chat_history, load_chat_history, clear_chat_history
import logging

logger = logging.getLogger(__name__)

def chat_interface():
    logger.info("Chat Interface")

    load_css()
    render_header()

    if not is_user_logged_in():
        logger.info("User is not logged in")
        st.rerun()

    user_email = get_user_email()
    logger.info("User is logged in")

    loaded_history = load_chat_history(user_email)
    # st.sidebar.write("Debug: Loaded chat history", loaded_history)

     # Initialize or update chat_history_list in session state
    if "chat_history" not in st.session_state or not st.session_state.chat_history:
        st.session_state.chat_history = loaded_history if loaded_history else [{"title": "New Chat", "messages": []}]
    elif loaded_history:  # Update session state if loaded history is different
        st.session_state.chat_history = loaded_history

    # Ensure current_chat is within valid range
    if "current_chat" not in st.session_state or st.session_state.current_chat >= len(st.session_state.chat_history):
        st.session_state.current_chat = 0

    # Ensure there's always at least one chat
    if not st.session_state.chat_history:
        st.session_state.chat_history.append({"title": "New Chat", "messages": []})

    # Sidebar with chat history
    with st.sidebar:

         # User information and logout (moved to the bottom of the sidebar)
        st.markdown("<hr>", unsafe_allow_html=True)  # Add a horizontal line for separation
        st.subheader("User Information")
        st.write(f"Logged in as: {user_email}")
        if st.button("Logout"):
            logout_user()
            st.rerun()

        
        st.title("Chat History")

        # Display chat history titles
        for i, chat in enumerate(loaded_history):
            if st.button(f"Chat {i+1}: {chat['title'][:30]}...", key=f"chat_button_{i}"):
                st.session_state.current_chat = i

        if st.button("New Chat", key="new_chat_button"):
            new_chat = {"title": "New Chat", "messages": []}
            st.session_state.chat_history.append(new_chat)
            st.session_state.current_chat = len(st.session_state.chat_history) - 1
            save_chat_history(user_email, st.session_state.chat_history)
        

    # Main chat area
    st.title("What can I help with?")

    # # Ensure current_chat is set
    # if "current_chat" not in st.session_state or st.session_state.current_chat >= len(st.session_state.chat_history):
    #     st.session_state.current_chat = 0

    # current_chat = st.session_state.chat_history[st.session_state.current_chat]

    if 0 <= st.session_state.current_chat < len(st.session_state.chat_history):
        current_chat = st.session_state.chat_history[st.session_state.current_chat]
    else:
        current_chat = {"title": "New Chat", "messages": []}
        st.session_state.chat_history_list.append(current_chat)
        st.session_state.current_chat = len(st.session_state.chat_history_list) - 1


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

        # Save updated chat history to cookie
        save_chat_history(user_email, st.session_state.chat_history)
        st.sidebar.write("Debug: Chat history saved", st.session_state.chat_history)
        # # Force a rerun to update the chat display
        # st.rerun()


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)


# Make sure to export the chat_interface function
__all__ = ['chat_interface']
