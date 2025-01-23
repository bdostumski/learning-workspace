#!/bin/bash
#
# Authentication Request Messages
#

. ../.env
MAIN_PATH="$API_VERSION/auth"

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
    response=$(curl \
        --silent \
        --location \
        --write-out "%{http_code}" --output response_body.txt \
        --header 'Content-Type: application/json' \
        --dump-header "$headers_file" \
        --data-raw "{
            \"name\": \"$username\",
            \"email\": \"$email\",
            \"password\": \"$password\"
            }" \
        "$APP_URL:$APP_PORT/$MAIN_PATH/register")
    printf "\n\n"
    printf "= = = = = = = = = ="
    printf "\n"
    printf 'HTTP Status Code: %s', "$response"
    printf "\n\n"
    printf "Response body:"
    printf "\n"
    cat response_body.txt
    printf "\n\n"
    printf "Cookies:"
    printf "\n"
    grep -i '^set-cookie:' "$headers_file"
    printf "\n"
    rm "$headers_file" response_body.txt
    printf "\nPress enter to continue ..."
    read -r continue
    export response
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
    response=$(curl \
        --silent \
        --location \
        --write-out "%{http_code}" --output response_body.txt \
        --header 'Content-Type: application/json' \
        --header "Cookie: token=\"$cookie_token\"" \
        --dump-header "$headers_file" \
        --data-raw "{
            \"email\": \"$email\",
            \"password\": \"$password\"
            }" \
        "$APP_URL:$APP_PORT/$MAIN_PATH/login")
    printf "\n\n"
    printf "= = = = = = = = = ="
    printf "\n"
    printf 'HTTP Status Code: %s', "$response"
    printf "\n\n"
    printf "Response body:"
    printf "\n"
    cat response_body.txt
    printf "\n\n"
    printf "Cookies:"
    printf "\n"
    grep -i '^set-cookie:' "$headers_file"
    printf "\n"
    rm "$headers_file" response_body.txt
    printf "\nPress enter to continue ..."
    read -r continue
    export response
}

post_logout_user() {
    headers_file=$(mktemp)
    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nLogout User API"
    printf "\n"
    response=$(curl \
        --silent \
        --location \
        --write-out "%{http_code}" --output response_body.txt \
        --header 'Content-Type: application/json' \
        --dump-header "$headers_file" \
        "$APP_URL:$APP_PORT/$MAIN_PATH/logout")
    printf "\n\n"
    printf "= = = = = = = = = ="
    printf "\n"
    printf 'HTTP Status Code: %s', "$response"
    printf "\n\n"
    printf "Response body:"
    printf "\n"
    cat response_body.txt
    printf "\n\n"
    rm "$headers_file" response_body.txt
    printf "\nPress enter to continue ..."
    read -r continue
    export response
}

# next curl example
# logout just send request
