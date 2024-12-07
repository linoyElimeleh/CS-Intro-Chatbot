import streamlit as st
from views.history import load_chat_history, save_chat_history
from views.login import add_new_chat, logout_user
import logging

from views.history import initialize_chat_history

logger = logging.getLogger(__name__)


# def sidebar_view(user_email):


#     with st.sidebar:
#         st.subheader("User Information")
#         st.write(f"Logged in as: {user_email}")
#         if st.button("Logout"):
#             logout_user()
#             st.rerun()

#         st.markdown("<hr>", unsafe_allow_html=True)
#         st.title("Chat History")

#         for i, chat in enumerate(loaded_history):
#             if st.button(f"Chat {i+1}: {chat['title'][:30]}...", key=f"chat_button_{i}"):
#                 st.session_state.current_chat = i

#         if st.button("Create New Chat", key="new_chat_button"):
#             new_chat = {"title": "Create New Chat", "messages": []}
#             st.session_state.chat_history.append(new_chat)
#             st.session_state.current_chat = len(
#                 st.session_state.chat_history) - 1
#             save_chat_history(user_email, st.session_state.chat_history)

#         st.markdown("<hr>", unsafe_allow_html=True)
#         st.sidebar.markdown("""
# **© 2024 All rights reserved To Linoy Gabay.**

# Did you find a bug? [Report Issues](mailto:lino1998y@gmail.com)
# """)

def sidebar_view(user_email):
    logger.info("SideBar Interface")

    with st.sidebar:
        st.subheader("User Information")
        st.write(f"Logged in as: {user_email}")
        if st.button("Logout"):
            logout_user()
            st.rerun()

    # st.sidebar.markdown("---")
    # if st.sidebar.button("New Chat"):
    #     add_new_chat(user_email)

    st.sidebar.markdown("---")
    

    if st.sidebar.button("**Create New Chat**", icon="➕"):
        add_new_chat(user_email)
        
    st.sidebar.title("Chat History")
    if "chat_history" in st.session_state:
        for i, chat in enumerate(st.session_state.chat_history):
            if st.sidebar.button(chat["title"], key=f"chat_{i}"):
                st.session_state.current_chat = i

    st.sidebar.markdown("---")
    st.sidebar.markdown("""
**© 2024 All rights reserved To Linoy Gabay.**

Did you find a bug? [Report Issues](mailto:lino1998y@gmail.com)
""")

__all__ = ['chat_interface']
