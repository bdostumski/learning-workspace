#!/bin/zsh
# # # # #
#
current_dir=$(pwd)
#
# Run the application database
docker_file_path="${current_dir}/docker/docker-compose.yml"
if [ -f "${docker_file_path}" ]; then
    echo "Starting application database..."
    cd "${current_dir}" && docker compose --env-file .env -f "${docker_file_path}" up -d
else
    echo "No file found in the current directory."
fi
#
# # # #
