import streamlit as st
from views.header import render_header

# Dummy user database (replace with a real database in production)
USERS = {
    "user1@example.com",
    "user2@example.com",
}


def login_interface():

    load_css()
    render_header()

    st.markdown('<div class="content">', unsafe_allow_html=True)

    st.title("Login")
    email = st.text_input("Email")
    if st.button("Login"):
        if check_email(email):
            st.session_state["user_email"] = email
            st.session_state["logged_in"] = True
            st.rerun()
        else:
            st.error("Invalid email address")


def check_email(email):
    return email in USERS


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)
