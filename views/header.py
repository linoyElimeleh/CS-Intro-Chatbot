import streamlit as st

from views.logo import render_Reichman_logo


def load_css():
    with open("styles.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)


def render_header():
    reichman_logo_base64 = render_Reichman_logo()

    load_css()
    st.markdown(
        f"""
        <div class="fixed-header">
            <div class="header-content">
                <img src="data:image/png;base64,{reichman_logo_base64}" class="header-image">
                <h1 class="header-title">RUNaI - Introduction To Computer Science Course ChatBot</h1>
            </div>
        </div>
        """,
        unsafe_allow_html=True,
    )


def render_title_and_logo():
    st.set_page_config(
        page_title="RUNaI - Introduction To Computer Science Course ChatBot",
        page_icon="images/ReichmanLogo.png")
