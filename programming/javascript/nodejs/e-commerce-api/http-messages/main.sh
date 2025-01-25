#!/bin/bash
#
# CURL HTTP REQUEST MESSAGES FOR API DEMO AND TESTING
#

source ./authentication-api.sh
source ./users-api.sh

while true; do

    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nDemo E-commerce API"
    printf "\n"
    printf "\n1. Authentication"
    printf "\n2. User CRUD Operations"
    printf "\nx. Exit"
    printf "\n"
    printf "\nEnter your choice: "
    read -r category_choice
    if [ "$category_choice" = "x" ]; then
        echo "Exiting ..."
        break
    fi

    case $category_choice in
    1)
        while true; do

            printf "\n"
            printf "= = = = = = = = = ="
            printf "\nUser Authentication"
            printf "\n"
            printf "\n1. Register"
            printf "\n2. Login"
            printf "\n3. Logout"
            printf "\nx. Back"
            printf "\n"
            printf "\nEnter your choice: "
            read -r auth_choice
            if [ "$auth_choice" = "x" ]; then
                break
            fi

            case $auth_choice in
            1)
                post_register_user
                ;;
            2)
                post_login_user
                ;;
            3)
                post_logout_user
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
        while true; do

            printf "\n"
            printf "= = = = = = = = = ="
            printf "\nUser CRUD Operations"
            printf "\n"
            printf "\n1. Get All"
            printf "\n2. Show Current User"
            printf "\n3. Get Single User"
            printf "\n4. Update User"
            printf "\n5. Update User Password"
            printf "\nx. Back"
            printf "\n"
            printf "\nEnter your choice: "
            read -r user_choice
            if [ "$user_choice" = "x" ]; then
                break
            fi

            case $user_choice in
            1)
                get_all_users
                ;;
            2)
                get_show_current_user
                ;;
            3)
                get_single_user
                ;;
            4)
                patch_update_user
                ;;
            5)
                patch_update_user_password
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
    *)
        echo -e "\nInvalid category choice"
        ;;
    esac
done
