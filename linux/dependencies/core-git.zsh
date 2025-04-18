#!/bin/zsh
#

# -----------------
# INSTALL YAY Package Manager
# -----------------
sudo pacman -S --needed git base-devel && git clone https://aur.archlinux.org/yay.git && cd yay && makepkg -si && cd ../ && rm -rf yay

# -----------------
# INSTALL Tmux plugin manager
# Directory: ~/.config/.tmux/plugins/tpm directory
# -----------------
if [ ! -d "$HOME/.config/tmux/plugins/tpm" ]; then
    git clone https://github.com/tmux-plugins/tpm ~/.config/tmux/plugins/tpm
fi

# -----------------
# INSTALL Zinit
# -----------------
if [ ! -d "$HOME/.config/zinit" ]; then
    bash -c "$(curl --fail --show-error --silent --location https://raw.githubusercontent.com/zdharma-continuum/zinit/HEAD/scripts/install.sh)"
fi
