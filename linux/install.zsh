#!/usr/bin/env zsh

while true; do

    echo "\n"
    echo " ▗▄▖ ▗▄▄▖  ▗▄▄▖▗▖ ▗▖    ▗▄▄▄▖▗▄▄▖  ▗▄▖ ▗▖  ▗▖▗▄▄▄▖ "
    echo "▐▌ ▐▌▐▌ ▐▌▐▌   ▐▌ ▐▌    ▐▌   ▐▌ ▐▌▐▌ ▐▌▐▛▚▞▜▌▐▌    "
    echo "▐▛▀▜▌▐▛▀▚▖▐▌   ▐▛▀▜▌    ▐▛▀▀▘▐▛▀▚▖▐▛▀▜▌▐▌  ▐▌▐▛▀▀▘ "
    echo "▐▌ ▐▌▐▌ ▐▌▝▚▄▄▖▐▌ ▐▌    ▐▌   ▐▌ ▐▌▐▌ ▐▌▐▌  ▐▌▐▙▄▄▖ "
    echo "\n"
    echo "- - Created by: Borislav Aleksandrov Dostumski - - "
    echo "\n"
    echo "Install Dependencies"
    echo "1) Install core dependencies [System, Security, Wine, VirtualBox, Vim, Zsh]"
    echo "2) Install Virtual and DevOps tools [Docker, Vagrant, K8s, etc.]"
    echo "3) Install basic editor for shell scripts and DevOps [LunarVim]"
    echo "4) Install IDE for programming [Doom Emacs]"
    echo "0) Exit"
    echo "\n"
    echo -n "Enter your choise: "
    read -r choice
    if [ "$choice" = "0" ]; then
        echo "Exiting..."
        break
    fi

    case $choice in
    1)
        echo "\n"
        echo "= = = = = = = = = ="
        echo "Starting installation [System, Security, Wine, VirtualBox, Vim, Zsh] . . ."
        source ./dependencies/core-pacman.zsh
        source ./dependencies/core-git.zsh
        source ./dependencies/core-yay.zsh
        ;;
    2)
        echo "\n"
        echo "= = = = = = = = = ="
        echo "Starting installation [Docker, Vagrant, K8s, etc.] . . ."
        source ./dependencies/devops-pacman.zsh
        ;;
    3)
        echo "\n"
        echo "= = = = = = = = = ="
        echo "Starting installation [LunarVim] . . ."
        source ./dependencies/lvim-git.zsh
        ;;
    4)
        echo "\n"
        echo "= = = = = = = = = ="
        echo "Starting installation [Doom Emacs] . . ."
        source ./dependencies/doom-emacs-git.zsh
        ;;
    *)
        echo "\n"
        echo -e "Invalid choice. Please try again."
        ;;
    esac
done
