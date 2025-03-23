# !/usr/bin/env sh

set -e
npm run build
cd dist
#git init
#git remote add origin git@github.com:Momoyouta/momoyouta.github.io.git
git add .
git commit -m 'update'

git push -f origin master:gh-pages

cd -
