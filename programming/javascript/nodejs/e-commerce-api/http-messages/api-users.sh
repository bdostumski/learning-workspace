#!/bin/bash
#
# Users Request Messages
#

. ../.env
MAIN_PATH="$API_VERSION/users"

handle_response() {
    local response="$1"
    local headers_file="$2"
    local body_file="$3"

    printf "\n\n"
    printf "= = = = = = = = = ="
    printf "\n"
    printf 'HTTP Status Code: %s' "$response"
    printf "\n\n"
    printf "Response body:"
    printf "\n"

    if command -v jq &>/dev/null; then
        jq . "$body_file"
    else
        cat "$body_file"
    fi

    printf "\n\n"
    printf "Cookies:"
    printf "\n"
    grep -i '^set-cookie:' "$headers_file"
    printf "\n"
    rm "$headers_file" "$body_file"
    printf "\nPress enter to continue ..."
    read -r continue
    export response
}

get_all_users() {
    headers_file=$(mktemp)

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nGet All Users"
    printf "\n"

    response=$(
        curl \
            --silent \
            --request GET \
            --location "$APP_URL:$APP_PORT/$MAIN_PATH" \
            --write-out "{http_code}" --output response_body.json \
            --header 'Content-Type: application/json' \
            --header 'Accept: application/json' \
            --dump-header "$headers_file"
    )

    handle_response "$response" "$headers_file" response_body.json
}

get_show_current_user() {
    headers_file=$(mktemp)

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nGet Current User"
    printf "\n"

    response=$(
        curl \
            --silent \
            --request GET \
            --location "$APP_URL:$APP_PORT/$MAIN_PATH/showMe" \
            --write-out "{http_code}" --output response_body.json \
            --header 'Content-Type: application/json' \
            --header 'Accept: application/json' \
            --dump-header "$headers_file"
    )

    handle_response "$response" "$headers_file" response_body.json
}

get_single_user() {
    headers_file=$(mktemp)

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nGet Single User"
    printf "\n"
    printf "Enter user id: "
    read -r user_id
    printf "\n"

    response=$(
        curl \
            --silent \
            --request GET \
            --location "$APP_URL:$APP_PORT/$MAIN_PATH/$user_id" \
            --write-out "{http_code}" --output response_body.json \
            --header 'Content-Type: application/json' \
            --header 'Accept: application/json' \
            --dump-header "$headers_file"
    )

    handle_response "$response" "$headers_file" response_body.json
}

patch_update_user() {
    headers_file=$(mktemp)

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nUpdate User"
    printf "\n"

    response=$(
        curl \
            --silent \
            --request PATCH \
            --location "$APP_URL:$APP_PORT/$MAIN_PATH/updateUser" \
            --write-out "{http_code}" --output response_body.json \
            --header 'Content-Type: application/json' \
            --header 'Accept: application/json' \
            --dump-header "$headers_file" \
            --data-raw '{
                       "name": "New Name",
                       "email": "test@test.dd"
            }'
    )

    handle_response "$response" "$headers_file" response_body.json
}

patch_update_user_password() {
    headers_file=$(mktemp)

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nUpdate User Password"
    printf "\n"

    response=$(
        curl \
            --silent \
            --request PATCH \
            --location "$APP_URL:$APP_PORT/$MAIN_PATH/updateUserPassword" \
            --write-out "{http_code}" --output response_body.json \
            --header 'Content-Type: application/json' \
            --header 'Accept: application/json' \
            --dump-header "$headers_file" \
            --data-raw '{
                       "password": "newpassword"
            }'
    )

    handle_response "$response" "$headers_file" response_body.json
}
