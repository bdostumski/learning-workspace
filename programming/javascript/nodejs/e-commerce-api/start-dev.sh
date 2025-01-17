#!/bin/bash
# # # # #
#
current_dir=$(pwd)
#
# Run the application if app.js is present in the current directory
application_path="${current_dir}/app.js"
if [ -f "${application_path}" ]; then
    echo "Starting node.js application from app.js..."
    nodemon "${application_path}"
else
    echo "No app.js found in the current directory."
fi
#
# # # # #
