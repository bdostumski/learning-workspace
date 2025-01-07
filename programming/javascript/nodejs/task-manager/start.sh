#!/bin/zsh
#
#
current_dir=$(pwd)

app_path="${current_dir}/app.js"

if [ -f "./app.js" ]; then
    echo "Starting node.js application from app.js..."
    node "${app_path}"
else
    echo "No app.js found in the current directory."
fi
