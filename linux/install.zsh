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
    echo "- -"
    echo "Manual dependencies installation: kitty, zsh"
    echo "- -"
    echo "Install Dependencies"
    echo "0) Install dependencies neede for the script [Zsh, Kitty, Fonts, Python]"
    echo "1) Install core dependencies [System, Security, Wine, VirtualBox, Vim, Emacs]"
    echo "2) Install DevOps tools [Docker, Vagrant, K8s, etc.]"
    echo "3) Install basic editor for shell scripts and DevOps [LunarVim]"
    echo "4) Install IDE for programming [Doom Emacs]"
    echo "x) Exit"
    echo "\n"
    echo -n "Enter your choise: "
    read -r choice
    if [ "$choice" = "x" ]; then
        echo "Exiting..."
        break
    fi

    case $choice in
    0)
        echo "\n"
        echo "= = = = = = = = = ="
        echo "Starting installation [Zsh, Kitty, Fonts, Python] . . ."
        source ./dependencies/core-dependencies-pacman.zsh
        ;;
    1)
        echo "\n"
        echo "= = = = = = = = = ="
        echo "Starting installation [System, Security, Wine, VirtualBox, Vim, Emacs] . . ."
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
        echo "Bug fix: When you run installation on the question 'Do you want to install pynvim?' answer 'no'"
        echo "It will be installed automatically from pacman."
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
