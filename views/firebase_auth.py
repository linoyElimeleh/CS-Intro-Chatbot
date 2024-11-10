import os
import json
import requests
import logging
from firebase_admin import auth, firestore, credentials, initialize_app, get_app
import datetime
import jwt
import streamlit as st

logger = logging.getLogger(__name__)


class FirebaseAuth:
    def __init__(self):
        # Initialize Firebase Admin SDK and Firestore
        try:
            get_app()
        except ValueError:
            with open(os.getenv("FIREBASE_CONFIG")) as f:
                firebase_config = json.load(f)
            firebase_config["private_key"] = os.getenv(
                "FIREBASE_PRIVATE_KEY").replace("\\n", "\n")
            firebase_config["client_email"] = os.getenv(
                "FIREBASE_CLIENT_EMAIL")
            firebase_config["client_id"] = os.getenv("FIREBASE_CLIENT_ID")
            firebase_config["private_key_id"] = os.getenv(
                "FIREBASE_PRIVATE_KEY_ID")

            cred = credentials.Certificate(firebase_config)
            initialize_app(cred)

        self.db = firestore.client()
        # API key for Firebase REST API
        self.api_key = os.getenv("FIREBASE_WEB_API_KEY")

    def generate_custom_token(self, user_id):
        try:
            custom_token = auth.create_custom_token(user_id)
            return custom_token.decode("utf-8")  # Decode to string
        except Exception as e:
            logger.error(f"Error generating custom token: {e}")
            return None

    def exchange_custom_token_for_id_token(self, custom_token):
        url = f"https://identitytoolkit.googleapis.com/v1/accounts:signInWithCustomToken?key={
            self.api_key}"
        payload = {
            "token": custom_token,
            "returnSecureToken": True
        }
        response = requests.post(url, json=payload)
        if response.status_code == 200:
            id_token = response.json().get("idToken")
            return id_token
        else:
            logger.error(f"Failed to exchange custom token for ID token: {
                         response.json()}")
            return None

    def authenticate_user(self, email):
        """Authenticate user and save ID token to Firestore."""
        try:
            user = auth.get_user_by_email(email)
            custom_token = self.generate_custom_token(user.uid)

            if custom_token:
                id_token = self.exchange_custom_token_for_id_token(
                    custom_token)
                if id_token:
                    # Save the ID token to Firestore
                    self.db.collection("user_tokens").document(
                        user.uid).set({"user_id": user.uid,
                                       "email": email,
                                       "timestamp": datetime.datetime.now()})
                    logger.info(f"User {email} authenticated successfully.")
                    return True
                else:
                    logger.error("Failed to obtain ID token.")
                    return False
            return False
        except auth.UserNotFoundError:
            logger.warning(f"Authentication failed: Email {email} not found.")
            return False
        except Exception as e:
            logger.error(f"Authentication error: {e}")
            return False

    def verify_token(self, token):
        """Verify an ID token."""
        try:
            decoded_token = auth.verify_id_token(token)
            return decoded_token

        except jwt.ExpiredSignatureError:
            logger.warning("Token expired.")
            return None

        except Exception as e:
            logger.error(f"Error verifying token: {e}")
            return None

    def get_user_email():
        return st.session_state.get('user_email')
