#!/bin/bash
#
# CURL HTTP REQUEST MESSAGES FOR API DEMO AND TESTING
#

source ./display_menu.sh

while true; do

    display_category_choice_menu
    if [ "$category_choice" = "x" ]; then
        echo "Exiting ..."
        break
    fi

    case $category_choice in
        1)
            while true; do

                display_authentication_choice_menu
                if [ "$auth_choice" = "x" ]; then
                    break
                fi

                case $auth_choice in
                    1)
                        headers_file=$(mktemp)
                        echo -e "\n"
                        echo "= = = = = = = = = ="
                        echo "Register User API"
                        echo -e "\n"
                        read -rp "Username: " username
                        read -rp "Email: " email
                        read -rp "Password: " password
                        echo -e "\n"
                        response=$(curl --silent --location --write-out "%{http_code}" \
                            --output response_body.txt \
                            --header 'Content-Type: application/json' \
                            --dump-header "$headers_file" \
                            --data-raw "{
                                    \"name\": \"$username\",
                                    \"email\": \"$email\",
                                    \"password\": \"$password\"
                                    }" \
                            "http://localhost:5000/api/v1/auth/register")
                        echo -e "\n"
                        echo "Response body:"
                        cat response_body.txt
                        echo -e "\n"
                        echo "HTTP Status Code: $response"
                        echo -e "\n"
                        echo "Cookies:"
                        grep -i '^set-cookie:' "$headers_file"
                        echo -e "\n"
                        rm "$headers_file" response_body.txt
                        read -rp "Press enter to continue ..."
                        ;;
                    2)
                        echo -e "\n"
                        echo "= = = = = = = = = ="
                        echo "Login User API"
                        echo -e "\n"
                        curl --location --request POST 'http://localhost:5000/api/v1/auth/login'
                        echo -e "\n"
                        read -rp "Press enter to continue ..."
                        ;;
                    3)
                        echo -e "\n"
                        echo "= = = = = = = = = ="
                        echo "Logout User API"
                        echo -e "\n"
                        curl --location 'http://localhost:5000/api/v1/auth/logout'
                        echo -e "\n"
                        read -rp "Press enter to continue ..."
                        ;;
                    *)
                        echo -e "\n"
                        echo "= = = = = = = = = ="
                        echo "Invalid choice"
                        echo -e "\n"
                        read -rp "Press enter to continue ..."
                        ;;
                esac
            done
            ;;
        2)
            echo -e "\nNot implemented yet."
            ;;
        *)
            echo -e "\nInvalid category choice"
            ;;
    esac
done
