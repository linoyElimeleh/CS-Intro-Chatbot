import streamlit as st
import hashlib
from views.header import render_header

# Dummy user database (replace with a real database in production)
USERS = {
    "user1@example.com": "password1",
    "user2@example.com": "password2",
}


def login_interface():
    load_css()
    render_header()

    st.title("Login")
    email = st.text_input("Email")
    password = st.text_input("Password", type="password")
    if st.button("Login"):
        if check_password(email, password):
            st.session_state["user_email"] = email
            st.session_state["logged_in"] = True
            st.rerun()
        else:
            st.error("Incorrect email or password")


def check_password(email, password):
    if email in USERS and USERS[email] == password:
        return True
    return False


def hash_password(password):
    return hashlib.sha256(password.encode()).hexdigest()


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)
