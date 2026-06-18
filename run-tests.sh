#!/bin/bash

REPO="k0sm0xyz/android-tests"
WORKFLOW_ID="android-test.yml"

GITHUB_TOKEN=$(gh auth token)

if [ -z "$GITHUB_TOKEN" ]; then
    echo "❌ Токен не найден. Запусти 'gh auth login'"
    exit 1
fi

echo "🔑 Запускаем тесты..."

curl -L -X POST \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer $GITHUB_TOKEN" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/$REPO/actions/workflows/$WORKFLOW_ID/dispatches \
  -d '{"ref":"main"}'

echo ""
echo "✅ Тесты запущены!"
echo "📊 Смотреть: https://github.com/$REPO/actions"
