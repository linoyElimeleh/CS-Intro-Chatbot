import json
import streamlit as st
import datetime

from backend.firebase import get_firebase_client

db = get_firebase_client()


# def initialize_chat_history(loaded_history):
#     if "chat_history" not in st.session_state or not st.session_state.chat_history:
#         st.session_state.chat_history = loaded_history if loaded_history else []

#     add_new_chat(st.session_state.user_email)

def initialize_chat_history(loaded_history):
    if "chat_history" not in st.session_state or not st.session_state.chat_history:
        st.session_state.chat_history = loaded_history if loaded_history else []

    # לא ליצור צ'אט חדש כאן - רק לאתחל את הרשימה הקיימת
    if "current_chat" not in st.session_state and st.session_state.chat_history:
        st.session_state.current_chat = len(st.session_state.chat_history) - 1

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
    st.session_state.chat_history = chat_history


# def load_chat_history(user_email):
#     """
#     Loads the chat history from Firestore for a given user.
#     """
#     # Try to load from session state first
#     chat_history_json = st.session_state.get(f'chat_history_{user_email}')
#     if chat_history_json:
#         return json.loads(chat_history_json)

#     # If not in session state, load from Firestore
#     user_doc_ref = db.collection("user_chat_histories").document(user_email)
#     doc = user_doc_ref.get()
#     if doc.exists:
#         chat_history_json = doc.to_dict().get("history")
#         # Cache in session state
#         st.session_state[f'chat_history_{user_email}'] = chat_history_json
#         try:
#             # Ensure this returns a list of dicts
#             return json.loads(chat_history_json)
#         except json.JSONDecodeError:
#             # If there is an error in decoding, return an empty list as a fallback
#             return [{"title": "New Chat", "messages": []}]

#     # If no history found, return an empty list
#     return [{"title": "New Chat", "messages": []}]

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
        # Cache in session state
        st.session_state[f'chat_history_{user_email}'] = chat_history_json
        try:
            return json.loads(chat_history_json)  # Ensure this returns a list of dicts
        except json.JSONDecodeError:
            return [{"title": "New Chat", "messages": []}]

    return [{"title": "New Chat", "messages": []}]

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
