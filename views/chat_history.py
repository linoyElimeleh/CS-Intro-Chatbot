import streamlit as st

def initialize_chat_history(loaded_history):
    if "chat_history" not in st.session_state or not st.session_state.chat_history:
        st.session_state.chat_history = loaded_history if loaded_history else [{"title": "New Chat", "messages": []}]
    elif loaded_history:
        st.session_state.chat_history = loaded_history

    if "current_chat" not in st.session_state or st.session_state.current_chat >= len(st.session_state.chat_history):
        st.session_state.current_chat = 0

    if not st.session_state.chat_history:
        st.session_state.chat_history.append({"title": "New Chat", "messages": []})
    