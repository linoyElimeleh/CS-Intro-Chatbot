import json
from dotenv import load_dotenv
from firebase_admin import auth, credentials, initialize_app, get_app, firestore
import os
import logging
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)
load_dotenv(override=True)

def get_firebase_client():
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
        firebase_config["private_key_id"] = os.getenv(
            "FIREBASE_PRIVATE_KEY_ID")

        cred = credentials.Certificate(firebase_config)
        logger.info(f"Using credentials: {cred}")
        initialize_app(cred)

    return firestore.client()

