#!/usr/bin/env zsh
#
# STILL WORKING ON THIS SCRIPT 
#
# Install common tools for Arch Linux

packages=(
	git
	bat
	btop
	htop
	stow
	eza
	ranger
	neovim
	emacs
	vscode
	kitty
	maven
	gradle
	nodejs
	docker
	kubectl
	minikube
	kubernetes-cli
	vagrant
	virtualbox
	wine
	jekyll
	ruby
	fzf
	jq
	thefuck
)

# Install packages using pacman
for package in "${packages[@]}"; do
	echo "Installing $package..."
	sudo pacman -S --noconfirm "$package"
	if [ $? -ne 0 ]; then
		echo "Error installing $package. Continuing..."
	fi
done



