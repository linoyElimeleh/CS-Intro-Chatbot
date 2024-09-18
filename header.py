import streamlit as st
import base64


def img_to_base64(img_path):
    with open(img_path, "rb") as img_file:
        return base64.b64encode(img_file.read()).decode("utf-8")


def render_header():
    img_path = "/Users/lelimeleh/Documents/thesis/Project/CS-Intro-Chatbot/images/ReichmanLogo.png"
    img_base64 = img_to_base64(img_path)

    st.markdown(
        f"""
        <div class="fixed-header">
            <div class="header-content">
                <img src="data:image/png;base64,{img_base64}" style="height: 60px; margin-right: 20px;">
                <h1 style="font-size: 1.5rem; font-weight: bold; color: #333;">Introduction To Computer Science Course ChatBot</h1>
            </div>
        </div>
        """,
        unsafe_allow_html=True,
    )

    # Add some space after the header
    st.markdown('<div style="margin-top: 80px;"></div>', unsafe_allow_html=True)
