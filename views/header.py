import os
import streamlit as st
import base64


def img_to_base64(img_path):
    with open(img_path, "rb") as img_file:
        return base64.b64encode(img_file.read()).decode("utf-8")


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)


def render_header():
    image_path = os.path.join(os.path.dirname(
        __file__), '..', 'images', 'ReichmanLogo.png')
    # img_path = "../images/ReichmanLogo.png"
    img_base64 = img_to_base64(image_path)

    # Call the load_css function at the beginning of your app
    load_css()

    st.markdown(
        f"""
        <div class="fixed-header">
            <div class="header-content">
                <img src="data:image/png;base64,{img_base64}" class="header-image">
                <h1 class="header-title">RunAI - Introduction To Computer Science Course ChatBot</h1>
            </div>
        </div>
        """,
        unsafe_allow_html=True,
    )


def render_title_and_logo():
    st.set_page_config(
        page_title="RunAI - Introduction To Computer Science Course ChatBot",
        page_icon="images/ReichmanLogo.png")
