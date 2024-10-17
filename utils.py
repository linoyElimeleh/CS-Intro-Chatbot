import streamlit as st
import extra_streamlit_components as stx
from datetime import datetime, timedelta
import json

import logging

logger = logging.getLogger(__name__)

# Create a single instance of CookieManager
cookie_manager = stx.CookieManager()

def get_cookie_manager():
    return cookie_manager

def is_user_logged_in():
    user_email = cookie_manager.get(cookie='user_email')
    logger.info(f"User {user_email} has already signed in")
    return user_email is not None

def login_user(email):
    cookie_manager.set('user_email', email, expires_at=datetime.now() + timedelta(days=30))

def logout_user():
    cookie_manager.delete('user_email')

def get_user_email():
    return cookie_manager.get(cookie='user_email')

def save_chat_history(user_email, chat_history):
    chat_history_json = json.dumps(chat_history)
    cookie_manager.set(f'chat_history_{user_email}', chat_history_json, expires_at=datetime.now() + timedelta(days=30))

def load_chat_history(user_email):
    chat_history_json = cookie_manager.get(f'chat_history_{user_email}')
    if chat_history_json:
        return json.loads(chat_history_json)
    return []

def clear_chat_history(user_email):
    cookie_manager.delete(f'chat_history_{user_email}')
