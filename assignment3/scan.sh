#!/bin/ash
# simple script that scans a project with each tool
bandit -r /code | tee /out/bandit.txt
trufflehog filesystem /code | tee /out/trufflehog.txt