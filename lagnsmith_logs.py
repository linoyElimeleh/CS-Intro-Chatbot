import langsmith
from dotenv import load_dotenv
import logging
load_dotenv(override=True)

client = langsmith.Client()

# Project here is the test / experiment name 
df = client.get_test_results(project_name="default")
logging.info(f"df: {df}")

df.to_csv("results.csv")