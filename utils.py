import streamlit as st
import extra_streamlit_components as stx
from datetime import datetime, timedelta

# Create a single instance of CookieManager
cookie_manager = stx.CookieManager()

def get_cookie_manager():
    return cookie_manager

def is_user_logged_in():
    user_email = cookie_manager.get(cookie='user_email')
    return user_email is not None

def login_user(email):
    cookie_manager.set('user_email', email, expires_at=datetime.now() + timedelta(days=30))

def logout_user():
    cookie_manager.delete('user_email')

def get_user_email():
    return cookie_manager.get(cookie='user_email')
