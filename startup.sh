#!/bin/bash
gunicorn --bind=0.0.0.0 --timeout 600 --worker-class=gevent --workers=1 --threads=4 app:app