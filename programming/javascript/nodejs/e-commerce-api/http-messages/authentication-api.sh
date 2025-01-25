#!/bin/bash
#
# Authentication Request Messages
#

. ../.env
MAIN_PATH="$API_VERSION/auth"

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
    cat "$body_file"
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

post_register_user() {
    headers_file=$(mktemp)

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nRegister User API"
    printf "\n"
    printf "Username: "
    read -r username
    printf "Email: "
    read -r email
    printf "Password: "
    read -r password
    printf "\n"

    response=$(
        curl \
            --silent \
            --request POST \
            --location "$APP_URL:$APP_PORT/$MAIN_PATH/register" \
            --write-out "%{http_code}" --output response_body.txt \
            --header 'Content-Type: application/json' \
            --header 'Accept: application/json' \
            --dump-header "$headers_file" \
            --data-raw "{
                       \"name\": \"$username\",
                       \"email\": \"$email\",
                       \"password\": \"$password\"
            }"

    )

    handle_response "$response" "$headers_file" response_body.txt
}

post_login_user() {
    headers_file=$(mktemp)

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nLogin User API"
    printf "\n"
    printf "Email: "
    read -r email
    printf "Password: "
    read -r password
    printf "Token: "
    read -r cookie_token
    printf "\n"

    response=$(
        curl \
            --silent \
            --request POST \
            --location "$APP_URL:$APP_PORT/$MAIN_PATH/login" \
            --write-out "%{http_code}" --output response_body.txt \
            --header 'Content-Type: application/json' \
            --header 'Accept: application/json' \
            --header "Cookie: token=\"$cookie_token\"" \
            --dump-header "$headers_file" \
            --data-raw "{
                       \"email\": \"$email\",
                       \"password\": \"$password\"
            }"
    )

    handle_response "$response" "$headers_file" response_body.txt
}

post_logout_user() {
    headers_file=$(mktemp)

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nLogout User API"
    printf "\n"

    response=$(
        curl \
            --silent \
            --request POST \
            --location "$APP_URL:$APP_PORT/$MAIN_PATH/logout" \
            --write-out "%{http_code}" --output response_body.txt \
            --header 'Content-Type: application/json' \
            --header 'Accept: application/json' \
            --dump-header "$headers_file"
    )

    handle_response "$response" "$headers_file" response_body.txt
}
