#!/bin/bash
#
# Wellcome Screen
#

display_category_choice_menu() {
    printf "\n"
    printf "= = = = = = = = = ="
    printf "\nDemo E-commerce API"
    printf "\n"
    printf "\n1. Authentication"
    printf "\n2. Not implemented yet"
    printf "\nx. Exit"
    printf "\n"
    printf "\nEnter your choice: "
    read -r  category_choice
    export category_choice
}

display_authentication_choice_menu() {
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
    read -r  auth_choice
    export auth_choice
}
