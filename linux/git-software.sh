# -----------------
# INSTALL Tmux plugin manager 
# Directory: ~/.config/.tmux/plugins/tpm directory
# -----------------
if [ ! -d ~/.config/.tmux/plugins/tpm ]; then
	git clone https://github.com/tmux-plugins/tpm ~/.tmux/plugins/tpm
fi

# install zinit
bash -c "$(curl --fail --show-error --silent --location https://raw.githubusercontent.com/zdharma-continuum/zinit/HEAD/scripts/install.sh)" 

# -----------------
# INSTALL YAY Package Manager
# -----------------
sudo pacman -S --needed git base-devel && git clone https://aur.archlinux.org/yay.git && cd yay && makepkg -si && cd ../ && rm -rf yay 
 
# -----------------
# INSTALL LunarVim
# -----------------
git clone https://github.com/LunarVim/LunarVim.git ~/.config/nvim && cd ~/.config/nvim  && ./install.sh

# -----------------
# INSTALL Doom Emacs
# -----------------
git clone --depth 1 https://github.com/doomemacs/doomemacs ~/.config/emacs ~/.config/emacs/bin/doom install 
sudo ln -s /usr/lib/libtree-sitter.so /usr/lib/libtree-sitter.so.0.24 
doom sync 
doom build 

