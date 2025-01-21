#!/bin/bash
#
# Authentication Request Messages
#
post_register_user() {

    headers_file=$(mktemp)
    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nRegister User API"
    printf "\n"
    printf "Username: "
    read -r  username
    printf "Email: "
    read -r email
    printf "Password: "
    read -r password
    printf "\n"
    response=$(curl --silent --location --write-out "%{http_code}" --output response_body.txt \
        --header 'Content-Type: application/json' \
        --dump-header "$headers_file" \
        --data-raw "{
            \"name\": \"$username\",
            \"email\": \"$email\",
            \"password\": \"$password\"
            }" \
        "http://localhost:5000/api/v1/auth/register")
    printf "\n"
    printf "Response body:"
    cat response_body.txt
    printf "\n"
    printf 'HTTP Status Code: %s', "$response"
    printf "\n"
    printf "Cookies:"
    grep -i '^set-cookie:' "$headers_file"
    printf "\n"
    rm "$headers_file" response_body.txt
    printf "\nPress enter to continue ..."
    read -r continue
    export response
}
