#!/bin/zsh
#
#
current_dir=$(pwd)

app_path="${current_dir}/app.js"

if [ -f "${app_path}" ]; then
    echo "Starting node.js application from app.js..."
    nodemon "${app_path}"
else
    echo "No app.js found in the current directory."
fi
