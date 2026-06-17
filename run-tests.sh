#!/bin/bash

REPO="ioptna/android-tests"
WORKFLOW_ID="android-test.yml"
GITHUB_TOKEN="ghp_твой_токен_вставь_сюда"

curl -L -X POST \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer $GITHUB_TOKEN" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/$REPO/actions/workflows/$WORKFLOW_ID/dispatches \
  -d '{"ref":"main"}'
