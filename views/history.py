import json
import streamlit as st
from firebase_admin import firestore
import datetime

db = firestore.client()

def initialize_chat_history(loaded_history):
    if "chat_history" not in st.session_state or not st.session_state.chat_history:
        st.session_state.chat_history = loaded_history if loaded_history else [
            {"title": "New Chat", "messages": []}]
    elif loaded_history:
        st.session_state.chat_history = loaded_history

    if "current_chat" not in st.session_state or st.session_state.current_chat >= len(st.session_state.chat_history):
        st.session_state.current_chat = 0

    if not st.session_state.chat_history:
        st.session_state.chat_history.append(
            {"title": "New Chat", "messages": []})

def save_chat_history(user_email, chat_history):
    """
    Saves the chat history to Firestore under the user's document.
    """
    chat_history_json = json.dumps(chat_history)
    timestamp = datetime.datetime.utcnow()

    # Save to Firestore
    user_doc_ref = db.collection("user_chat_histories").document(user_email)
    user_doc_ref.set({
        "email": user_email,
        "history": chat_history_json,
        "last_updated": timestamp
    })

    # Also update in session state
    st.session_state[f'chat_history_{user_email}'] = chat_history_json

def load_chat_history(user_email):
    """
    Loads the chat history from Firestore for a given user.
    """
    # Try to load from session state first
    chat_history_json = st.session_state.get(f'chat_history_{user_email}')
    if chat_history_json:
        return json.loads(chat_history_json)

    # If not in session state, load from Firestore
    user_doc_ref = db.collection("user_chat_histories").document(user_email)
    doc = user_doc_ref.get()
    if doc.exists:
        chat_history_json = doc.to_dict().get("history")
        st.session_state[f'chat_history_{user_email}'] = chat_history_json  # Cache in session state
        return json.loads(chat_history_json)

    # If no history found, return an empty list
    return []

def clear_chat_history(user_email):
    """
    Clears the chat history from Firestore and session state for a given user.
    """
    # Remove from Firestore
    user_doc_ref = db.collection("user_chat_histories").document(user_email)
    user_doc_ref.delete()

    # Clear from session state
    if f'chat_history_{user_email}' in st.session_state:
        del st.session_state[f'chat_history_{user_email}']
    
    st.session_state.chat_history = [{"title": "New Chat", "messages": []}]
