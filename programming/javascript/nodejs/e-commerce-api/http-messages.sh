#!/bin/bash
#
# CURL HTTP REQUEST MESSAGES FOR API DEMO AND TESTING
#

while true; do

    echo -e "\n"
    echo "= = = = = = = = = ="
    echo "Demo E-commerce API"
    echo -e "\n"
    echo "1. Authentication"
    echo "2. Not implemented yet"
    echo "x. Exit"
    echo -e "\n"
    read -rp "Enter your choice: " category_choice

    if [ "$category_choice" = "x" ]; then
        echo "Exiting ..."
        break
    fi

    case $category_choice in
        1)
            while true; do
                echo -e "\n"
                echo "= = = = = = = = = ="
                echo "User Authentication"
                echo -e "\n"
                echo "1. Register"
                echo "2. Login"
                echo "3. Logout"
                echo "x. Back"
                echo -e "\n"
                read -rp "Enter your choice: " auth_choice

                if [ "$auth_choice" = "x" ]; then
                    break
                fi

                case $auth_choice in
                    1)
                        echo -e "\n"
                        echo "= = = = = = = = = ="
                        echo "Register User API"
                        echo -e "\n"
                        read -rp "Username: " username
                        read -rp "Email: " email
                        read -rp "Password: " password
                        echo -e "\n"
                        curl --location 'http://localhost:5000/api/v1/auth/register' \
                            --header 'Content-Type: application/json' \
                            --data-raw "{
                                    \"name\": \"$username\",
                                    \"email\": \"$email\",
                                    \"password\": \"$password\"
                                    }"
                        echo -e "\n"
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
