import logging
import streamlit as st
from firebase_admin import firestore
import datetime

db = firestore.client()
logger = logging.getLogger(__name__)
logger.setLevel(logging.INFO)


def like_callback():
    user_email = st.session_state.user_email
    question = st.session_state.question
    answer = st.session_state.answer
    logger.info(f"Liked answer. Answer: {st.session_state.answer}")

    save_feedback(user_email, question, answer, "like")
    st.success("Thank you for your feedback!")


def dislike_callback():
    logger.info(f"Disliked answer. Answer: {st.session_state.answer}")
    user_email = st.session_state.user_email
    question = st.session_state.question
    answer = st.session_state.answer

    save_feedback(user_email, question, answer, "dislike")
    st.warning("Sorry to hear that! We'll improve.")


def display_feedback_panel(question, answer, user_email):
    # Store the answer in session state so it's accessible in the callbacks
    st.session_state.user_email = user_email
    st.session_state.question = question
    st.session_state.answer = answer

    # Add Like/Dislike buttons
    st.markdown("#### Did the answer help you?")
    logger.info(f"displaying feedback panel for question: {
                question} and answer: {answer}")

    col1, col2 = st.columns(2)
    with col1:
        st.button("👍 Good Answer", on_click=like_callback)
    with col2:
        st.button("👎 Bad Answer", on_click=dislike_callback)


def save_feedback(user_email, question, answer, feedback):
    """
    Saves the user's feedback to Firestore.
    """
    timestamp = datetime.datetime.utcnow()
    db.collection("user_feedback").add({
        "user_email": user_email,
        "question": question,
        "answer": answer,
        "feedback": feedback,
        "timestamp": timestamp
    })
    logger.info(f"User feedback saved: {feedback} for answer: {question}")


__all__ = ['chat_interface']
