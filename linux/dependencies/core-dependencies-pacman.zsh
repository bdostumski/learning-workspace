#!/usr/bin/env zsh

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
    zsh kitty

    # Development Tools
    python python-pip python-virtualenv

)

echo "📦 Installing ${#packages[@]} packages..."
for pkg in "${packages[@]}"; do
    echo -e "\n👉 Installing: \033[1m$pkg\033[0m"
    if sudo pacman -S --needed --noconfirm "$pkg"; then
        echo -e "✅ \033[1m$pkg\033[0m installed."
    else
        echo -e "❌ Failed to install: \033[1m$pkg\033[0m"
    fi
done

# -------------------------------------
# Configure Zsh as Default Shell
# -------------------------------------
chsh -s "$(which zsh)" || echo "Zsh is already set as default shell."

# -------------------------------------
# Python Environment Setup
# -------------------------------------
python -m venv ~/.pyenv
source ~/.pyenv/bin/activate
sudo ln -s /usr/bin/python3 /usr/bin/python
sudo packamn -Syu python
python -m pip install --upgrade pip

echo "🧹 Cleaning up orphaned packages..."
sudo pacman -Rns --noconfirm $(pacman -Qdtq)

echo "\n"
echo "🎉 All setup steps completed!"
echo "🚀 Continue installation script with kitty terminal"
echo "💡 Press ENTER to exit the terminal..."
read -r
exit
