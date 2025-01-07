#!/bin/zsh
# # # # #
#
current_dir=$(pwd)
#
# Install dependencies if package.json is present in the current directory
dependencies_path="${current_dir}/package.json"
if [ -f "${dependencies_path}"]; then
    echo "Install dependencies..."
    npm install -y
else
    echo "Warning: No package.json found in the current directory."
fi
#
# Run the application if app.js is present in the current directory
application_path="${current_dir}/app.js"
if [ -f "${application_path}" ]; then
    echo "Starting node.js application from app.js..."
    node "${application_path}"
else
    echo "No app.js found in the current directory."
fi
#
# # # # #
