#!/usr/bin/env zsh

echo "\n"
echo " ▗▄▖ ▗▄▄▖  ▗▄▄▖▗▖ ▗▖    ▗▄▄▄▖▗▄▄▖  ▗▄▖ ▗▖  ▗▖▗▄▄▄▖ "
echo "▐▌ ▐▌▐▌ ▐▌▐▌   ▐▌ ▐▌    ▐▌   ▐▌ ▐▌▐▌ ▐▌▐▛▚▞▜▌▐▌    "
echo "▐▛▀▜▌▐▛▀▚▖▐▌   ▐▛▀▜▌    ▐▛▀▀▘▐▛▀▚▖▐▛▀▜▌▐▌  ▐▌▐▛▀▀▘ "
echo "▐▌ ▐▌▐▌ ▐▌▝▚▄▄▖▐▌ ▐▌    ▐▌   ▐▌ ▐▌▐▌ ▐▌▐▌  ▐▌▐▙▄▄▖ "
echo "\n"
echo "- - Created by: Borislav Aleksandrov Dostumski - - "
echo "\n"
echo "- -"
echo "Manual dependencies to isntall: zsh"
echo "- -"
echo "Install Dependencies"
echo "0) Install dependencies neede for the script [Zsh, Kitty, Fonts, Python]"
echo "1) Install core dependencies [System, Security, Virtualization, Basic Edittors]"
echo "2) Install DevOps tools [Docker, Vagrant, K8s, etc.]"
echo "3) Install IDE for programming [Doom Emacs]"
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
    echo "💡 Exit default terminal, and run kitty terminal"
    ;;
1)
    echo "\n"
    echo "= = = = = = = = = ="
    echo "Starting installation [System, ClamAV, UFW, Wine, VirtualBox, Vim, Neovim, Emacs, etc] . . ."
    source ./dependencies/core-pacman.zsh
    source ./dependencies/core-git.zsh
    source ./dependencies/core-yay.zsh
    echo "💡 Restart [exit/start again] rerun the script with kitty terminal"
    ;;
2)
    echo "\n"
    echo "= = = = = = = = = ="
    echo "Starting installation [Docker, Vagrant, K8s, etc.] . . ."
    source ./dependencies/devops-pacman.zsh
    echo "💡 Restart [exit/start again] kitty terminal"
    ;;
3)
    echo "\n"
    echo "= = = = = = = = = ="
    echo "Starting installation [Doom Emacs] . . ."
    source ./dependencies/doom-emacs-git.zsh
    echo "💡 Restart [exit/start again] kitty terminal"
    ;;
4)
    echo "\n"
    echo "= = = = = = = = = ="
    echo "Starting installation [Firmware, Drivers, Nvidia] . . ."
    source ./dependencies/firmware-drivers.zsh
    echo "💡 Restart [exit/start again] kitty terminal"
    ;;
*)
    echo "\n"
    echo -e "Invalid choice. Please try again."
    ;;
esac
