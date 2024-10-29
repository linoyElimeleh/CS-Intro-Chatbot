import logging
import json
import streamlit as st

logger = logging.getLogger(__name__)

def is_user_logged_in():
    user_email = st.session_state.get('user_email')
    logger.info(f"User {user_email} has already signed in" if user_email else "No user signed in")
    return user_email is not None

def login_user(email):
    st.session_state['user_email'] = email

def logout_user():
    if 'user_email' in st.session_state:
        del st.session_state['user_email']

def get_user_email():
    return st.session_state.get('user_email')

def save_chat_history(user_email, chat_history):
    chat_history_json = json.dumps(chat_history)
    st.session_state[f'chat_history_{user_email}'] = chat_history_json

def load_chat_history(user_email):
    chat_history_json = st.session_state.get(f'chat_history_{user_email}')
    if chat_history_json:
        return json.loads(chat_history_json)
    return []

def clear_chat_history(user_email):
    if f'chat_history_{user_email}' in st.session_state:
        del st.session_state[f'chat_history_{user_email}']
