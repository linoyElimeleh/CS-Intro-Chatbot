import logging
import json
import streamlit as st

logger = logging.getLogger(__name__)


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
