import streamlit as st
from views.chat import main_chat_interface
from views.login import login_interface

if __name__ == "__main__":
    if "logged_in" not in st.session_state:
        st.session_state["logged_in"] = False

    if st.session_state["logged_in"]:
        main_chat_interface()
    else:
        login_interface()
