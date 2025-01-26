#!/bin/bash
#
# Authentication Request Messages
#
# Methods:
# post_register_user | Register a new user
# post_login_user    | Login a user
# post_logout_user   | Logout a user
#
# Load environment variables
. ../.env
PATH_AUTH="$APP_URL:$APP_PORT/$API_VERSION/auth"

handle_auth_response() {
    # Declare variables
    local response
    local headers_file
    local body_file
    local curl_error_file
    local http_code
    local full_url
    local debug

    # Assign values to variables
    response="$1"
    headers_file="$2"
    body_file="$3"
    curl_error_file="$4"
    http_code="$5"
    full_url="$6"
    debug=true

    if [ "$debug" = true ]; then
        printf "\nCurl error:\n"
        cat "$curl_error_file"
    fi

    printf "\n\n"
    printf "= = = = = = = = = ="
    printf "\n"
    printf "Full URL: %s" "$full_url"
    printf "\n\n"
    printf 'HTTP Status Code: %s' "$response"
    printf "\n\n"

    if command -v jq &>/dev/null; then
        # Print the response body
        if [ -s "$body_file" ]; then
            printf "Response Body:\n"
            jq . "$body_file"
            rm "$body_file"
        fi
    else
        # Print the raw response body
        if [ -s "$body_file" ]; then
            printf "Raw Response Body:\n"
            cat "$body_file"
            rm "$body_file"
        fi
    fi

    # Extract token from headers file if it's not empty
    if [ -s "$headers_file" ]; then
        token=$(grep -i '^set-cookie:' "$headers_file" | awk -F'[=;]' '{print $2}')
        if [ -n "$token" ]; then
            printf "\n\nCookies:\n"
            grep -i '^set-cookie:' "$headers_file" | jq -R -s -c 'split("\n") | map(select(length > 0))'
            GLOBAL_TOKEN="$token"
            printf "\nExtracted Token: %s\n\n" "$GLOBAL_TOKEN"
            rm "$headers_file"
        else
            echo "Token not found in headers."
        fi
    else
        echo "No headers found in headers_file."
    fi

    rm "$curl_error_file"

    printf "\nPress enter to continue ..."
    read -r
    export GLOBAL_TOKEN
}

post_register_user() {
    # Declare variables
    local headers_file
    local body_file
    local curl_error_file
    local response
    local http_code
    local full_url

    # Assign values to variables
    headers_file=$(mktemp)
    body_file=$(mktemp)
    curl_error_file=$(mktemp)
    full_url="$PATH_AUTH/register"
    http_code=""

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nRegister User API"
    printf "\n\n"
    printf "Username: "
    read -r username
    printf "Email: "
    read -r email
    printf "Password: "
    read -r password
    printf "\n"

    response=$(curl \
        --verbose \
        --request POST \
        --location "$full_url" \
        --write-out "%{http_code}" \
        --output "$body_file" \
        --header 'Content-Type: application/json' \
        --header 'Accept: application/json' \
        --dump-header "$headers_file" \
        --data-raw "{
                   \"name\": \"$username\",
                   \"email\": \"$email\",
                   \"password\": \"$password\"
        }" \
        2>"$curl_error_file")

    handle_auth_response "$response" "$headers_file" "$body_file" \
        "$curl_error_file" "$http_code" "$full_url"
}

post_login_user() {
    # Declare variables
    local headers_file
    local body_file
    local curl_error_file
    local response
    local http_code
    local full_url

    # Assign values to variables
    headers_file=$(mktemp)
    body_file=$(mktemp)
    curl_error_file=$(mktemp)
    full_url="$PATH_AUTH/login"
    http_code=""

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nLogin User API"
    printf "\n\n"
    printf "Email: "
    read -r email
    printf "Password: "
    read -r password
    printf "\n"

    if [ -s "$cookie_token" ]; then
        cookie_token=$GLOBAL_TOKEN
    fi

    response=$(curl \
        --verbose \
        --request POST \
        --location "$full_url" \
        --write-out "%{http_code}" \
        --output "$body_file" \
        --header 'Content-Type: application/json' \
        --header 'Accept: application/json' \
        --dump-header "$headers_file" \
        --data-raw "{
                   \"email\": \"$email\",
                   \"password\": \"$password\"
        }" \
        2>"$curl_error_file")

    handle_auth_response "$response" "$headers_file" "$body_file" \
        "$curl_error_file" "$http_code" "$full_url"
}

post_logout_user() {
    # Declare variables
    local headers_file
    local body_file
    local curl_error_file
    local response
    local http_code
    local full_url

    # Assign values to variables
    headers_file=$(mktemp)
    body_file=$(mktemp)
    curl_error_file=$(mktemp)
    full_url="$PATH_AUTH/logout"
    http_code=""

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nLogout User API"
    printf "\n\n"

    response=$(curl \
        --verbose \
        --request POST \
        --location "$full_url" \
        --write-out "%{http_code}" \
        --header 'Content-Type: application/json' \
        --header 'Accept: application/json' \
        --dump-header "$headers_file" \
        2>"$curl_error_file")

    handle_auth_response "$response" "$headers_file" "$body_file" \
        "$curl_error_file" "$http_code" "$full_url"
}
