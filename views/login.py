import streamlit as st
from views.header import render_header
import logging
from utils import login_user, is_user_logged_in
import os
import pandas as pd

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
    full_path = os.path.join(os.path.dirname(os.path.dirname(__file__)), 'source', 'Studentslist.csv')
    logger.info(f"Attempting to access file at: {full_path}")

    if not os.path.exists(full_path):
        logger.error(f"Student list file not found: {full_path}")
        return False
    
    try:
        # Read the CSV file
        df = pd.read_csv(full_path)
        
        # Check if 'email' column exists
        if 'email' not in df.columns:
            logger.error("Email column not found in the CSV file")
            return False
        
        # Check if the email is in the list
        return email in df['email'].values
    except Exception as e:
        logger.error(f"Error reading CSV file: {e}")
        return False


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)
