# Tmux plugin manager install on ~/.config/.tmux/plugins/tpm directory
if [ ! -d ~/.config/.tmux/plugins/tpm ]; then
	git clone https://github.com/tmux-plugins/tpm ~/.tmux/plugins/tpm
fi

bash -c "$(curl --fail --show-error --silent --location https://raw.githubusercontent.com/zdharma-continuum/zinit/HEAD/scripts/install.sh)" # install zinit

# install icons for ranger file manager
# echo "default_linemode devicons" >> $HOME/.config/ranger/rc.conf
git clone https://github.com/alexanderjeurissen/ranger_devicons ~/.config/ranger/plugins/ranger_devicons

# install doom emacs
git clone --depth 1 https://github.com/doomemacs/doomemacs ~/.config/emacs ~/.config/emacs/bin/doom install # install doom emacs
sudo ln -s /usr/lib/libtree-sitter.so /usr/lib/libtree-sitter.so.0.24 # fix doom emacs error
doom sync # to install packages
doom build # to build the packages

# install yay
sudo pacman -S --needed git base-devel && git clone https://aur.archlinux.org/yay.git && cd yay && makepkg -si && cd ../ && rm -rf yay # install yay
