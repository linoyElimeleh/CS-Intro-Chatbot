import json
import os
import streamlit as st
from views.header import render_header
import logging
from firebase_admin import auth, credentials, initialize_app, get_app, firestore
import datetime
from dotenv import load_dotenv
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

load_dotenv(override=True)

try:
    # Check if the default app is already initialized
    get_app()
except ValueError:
    # If not, initialize it
    with open(os.getenv("FIREBASE_CONFIG")) as f:
        firebase_config = json.load(f)
    firebase_config["private_key"] = os.getenv(
        "FIREBASE_PRIVATE_KEY").replace("\\n", "\n")
    firebase_config["client_email"] = os.getenv("FIREBASE_CLIENT_EMAIL")
    firebase_config["client_id"] = os.getenv("FIREBASE_CLIENT_ID")
    firebase_config["private_key_id"] = os.getenv("FIREBASE_PRIVATE_KEY_ID")

    cred = credentials.Certificate(firebase_config)
    logger.info(f"Using credentials: {cred}")
    initialize_app(cred)

db = firestore.client()


def is_user_logged_in():
    """Check if the user is logged in and verify token if needed."""
    return st.session_state.get("logged_in", False) and st.session_state.get("user_email") is not None


def log_sign_in_event(user_id, email):
    db.collection('sign_in_logs').add({
        'user_id': user_id,
        'email': email,
        'timestamp': datetime.datetime.utcnow()
    })


def authenticate_user(email):
    try:
        user = auth.get_user_by_email(email)
        st.session_state.user_id = user.uid
        st.session_state.user_email = email
        st.session_state.logged_in = True
        logger.info(f"User {email} authenticated successfully.")
        log_sign_in_event(user.uid, email)
        # analytics.log_event(
        #     "user_sign_in",
        #     {"email": email}
        # )

    except auth.UserNotFoundError:
        st.error("Email doesn't exist.")
        logger.warning(f"Authentication failed: Email {email} not found.")
    except Exception as e:
        st.error(f"Authentication failed: {e}")
        logger.error(f"Authentication error: {e}")


def logout_user():
    st.session_state.user_id = None
    st.session_state.logged_in = False
    st.success("You have been logged out.")
    login_interface()


def login_interface():
    logger.info("Login Interface Initialized")

    load_css()
    render_header()

    st.markdown('<div class="content login-container">',
                unsafe_allow_html=True)

    # st.title("Login")
    email = st.text_input("University Email (yourName@post.runi.ac.il)")
    # password = st.text_input("Password", type="password")

    if st.button("Login", key="login_button"):
        authenticate_user(email)

        if is_user_logged_in():
            st.rerun()

    st.markdown('</div>', unsafe_allow_html=True)

    st.markdown("<hr>", unsafe_allow_html=True)
    st.markdown("""
        <div style='text-align: center; margin-top: 20px;'>
            <p style='font-size: 14px; color: gray;'>Do you have problems logging in? <a href='mailto:lino1998y@gmail.com'>Contact us</a></p>
        </div>
    """, unsafe_allow_html=True)

    # Debugging: Uncomment to see session state
    # st.write("Debug: Session state", st.session_state)


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)


def get_user_email():
    return st.session_state.get('user_email')
