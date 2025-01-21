#!/bin/bash
#
# CURL HTTP REQUEST MESSAGES FOR API DEMO AND TESTING
#

source ./display_menu.sh
source ./authentication-api.sh

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
                        post_register_user
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
