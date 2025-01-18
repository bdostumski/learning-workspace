#!/bin/bash
#
# CURL HTTP REQUESTS FOR TESTING
#

while true; do

    echo -e "\n"
    echo "= = = = = = = = = ="
    echo "Choose a category:"
    echo -e "\n"
    echo "1. Authentication"
    echo "2. Not implemented yet"
    echo "x. Exit from programm"
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
                echo "Choose an option:"
                echo -e "\n"
                echo "1. Register"
                echo "2. Login"
                echo "3. Logout"
                echo "x. Back to main menu"
                echo -e "\n"
                read -rp "Enter your choice: " auth_choice

                if [ "$auth_choice" = "x" ]; then
                    break
                fi

                case $auth_choice in
                    1)
                        echo -e "\n"
                        echo "= = = = = = = = = ="
                        echo "Executing Logout ..."
                        echo -e "\n"
                        curl --location 'http://localhost:5000/api/v1/auth/logout'
                        echo -e "\n"
                        read -rp "Press enter to continue ..."
                        ;;
                    2)
                        echo -e "\n"
                        echo "= = = = = = = = = ="
                        echo -e "\n"
                        echo "Executing Register ..."
                        echo -e "\n"
                        curl --location --request POST 'http://localhost:5000/api/v1/auth/register'
                        echo -e "\n"
                        read -rp "Press enter to continue ..."
                        ;;
                    3)
                        echo -e "\n"
                        echo "= = = = = = = = = ="
                        echo -e "\n"
                        echo "Execuring Login ..."
                        echo -e "\n"
                        curl --location --request POST 'http://localhost:5000/api/v1/auth/login'
                        echo -e "\n"
                        read -rp "Press enter to continue ..."
                        ;;
                    *)
                        echo -e "\n"
                        echo "= = = = = = = = = ="
                        echo -e "\n"
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
