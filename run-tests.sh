#!/bin/bash

REPO="ioptna/android-tests"
WORKFLOW_ID="android-test.yml"

# Автоматически берём токен из текущей сессии GitHub CLI
GITHUB_TOKEN=$(gh auth token)

if [ -z "$GITHUB_TOKEN" ]; then
    echo "❌ Не удалось получить токен. Запусти 'gh auth login' сначала."
    exit 1
fi

echo "🔑 Токен получен, запускаем тесты..."

curl -L -X POST \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer $GITHUB_TOKEN" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/$REPO/actions/workflows/$WORKFLOW_ID/dispatches \
  -d '{"ref":"main"}'

echo ""
echo "✅ Тесты запущены! Смотри результат:"
echo "   https://github.com/$REPO/actions"
