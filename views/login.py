import streamlit as st
from views.header import render_header
import logging
from utils import login_user, get_cookie_manager, is_user_logged_in
from datetime import datetime, timedelta


# Dummy user database (replace with a real database in production)
USERS = {
    "user1@example.com",
    "user2@example.com",
}

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

def login_interface():
    logger.info("Login Interface")

    load_css()
    render_header()

    if is_user_logged_in():
        st.rerun()

    st.markdown('<div class="content login-container">', unsafe_allow_html=True)

    st.title("Login")
    email = st.text_input("Email")
    if st.button("Login", key="login_button"):
        if check_email(email):  
            login_user(email)
            st.rerun()
        else:
            st.error("Invalid email address")
    
    st.markdown('</div>', unsafe_allow_html=True)

    # st.write("Debug: Session state", st.session_state)


def check_email(email):
    return email in USERS


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)
