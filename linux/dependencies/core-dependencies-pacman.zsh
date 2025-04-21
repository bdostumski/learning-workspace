#!/usr/bin/env zsh

# Exit on error
set -e

# -------------------------------------
# Install Common Tools for Arch Linux
# -------------------------------------

echo "🔄 Updating system..."
sudo pacman -Syu --noconfirm

# Define packages
packages=(
    # Fonts
    ttf-dejavu ttf-liberation ttf-roboto ttf-ubuntu-font-family noto-fonts
    noto-fonts-emoji noto-fonts-cjk ttf-fira-code ttf-fira-mono ttf-fira-sans
    ttf-jetbrains-mono ttf-hack ttf-inconsolata nerd-fonts ttf-opensans

    # System Utilities
    zsh kitty tmux git github-cli ranger

    # Python + tools
    python python-pip python-pipenv python-virtualenv python-pynvim pyenv
)

echo "📦 Installing ${#packages[@]} packages..."
for pkg in "${packages[@]}"; do
    echo -e "\n👉 Installing: \033[1m$pkg\033[0m"
    if ! pacman -Qi "$pkg" &>/dev/null; then
        if sudo pacman -S --needed --noconfirm "$pkg"; then
            echo -e "✅ \033[1m$pkg\033[0m installed."
        else
            echo -e "❌ Failed to install: \033[1m$pkg\033[0m"
        fi
    else
        echo -e "✅ \033[1m$pkg\033[0m is already installed."
    fi
done

# -------------------------------------
# Configure Zsh as Default Shell
# -------------------------------------
if [[ "$SHELL" != *"zsh" ]]; then
    echo "⚙️ Setting Zsh as default shell..."
    chsh -s "$(which zsh)"
else
    echo "✅ Zsh is already the default shell."
fi

# -------------------------------------
# Dotfiles
# -------------------------------------
echo "💾 Copying main config file to home root directory..."
if [[ -d "dotfiles" ]]; then
    cp -f ./dotfiles/.zshrc ~/.zshrc
    cp -rf ./dotfiles/.zshrc.d ~/
    cp -f ./dotfiles/.zshrc.d/config.d/gitconf/.gitconfig ~/
    cp -rf ./dotfiles/.zshrc.d/config.d/kitty ~/.config/
    cp -rf ./dotfiles/.zshrc.d/config.d/ranger ~/.config/
    cp -f ./dotfiles/.zshrc.d/config.d/vim/.vimrc ~/
else
    echo "❌ Dotfiles directory not found. Skipping dotfile setup."
fi

# -------------------------------------
# Done
# -------------------------------------
echo "\n🎉 All setup steps completed!"
echo "🚀 Continue installation script with kitty terminal"
echo "💡 Installation completed start Kitty terminal, and rerun installation script ..."
read -r
exit 0
