import streamlit as st
from backend.firebase import get_firebase_client
from views.header import render_header
import logging
from firebase_admin import auth
import datetime
from dotenv import load_dotenv

from views.history import initialize_chat_history, load_chat_history, save_chat_history
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

load_dotenv(override=True)

db = get_firebase_client()


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
    st.session_state.clear()
    
    try:
        user = auth.get_user_by_email(email)
        st.session_state.user_id = user.uid
        st.session_state.user_email = email
        st.session_state.logged_in = True

        loaded_history = load_chat_history(email)
        initialize_chat_history(loaded_history)

        if len(st.session_state.chat_history) ==0 or "current_chat" not in st.session_state:
            add_new_chat(email)

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
