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
    zsh kitty tmux git github-cli

    # Python + tools
    python python-pip python-virtualenv
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
# Python Environment Setup
# -------------------------------------

echo "🐍 Setting up Python environment..."

# Create venv (for personal use, optional if using pyenv or pipenv)
if [[ ! -d "$HOME/.venv" ]]; then
    python -m venv "$HOME/.venv"
    source "$HOME/.venv/bin/activate"
    echo "✅ Virtual environment created and activated."
else
    echo "✅ Virtual environment already exists at $HOME/.venv."
fi

# Ensure 'python' is available (symlink if needed)
if ! command -v python &>/dev/null; then
    echo "🔗 Symlinking python3 to python..."
    sudo ln -sf /usr/bin/python3 /usr/bin/python
fi

# Check if pipenv was installed properly in the user directory
if ! command -v pipenv &>/dev/null; then
    echo "❌ pipenv installation failed."
else
    echo "✅ pipenv is installed and ready to use."
fi

# Handle pyenv (if you want to use it)
if ! command -v pyenv &>/dev/null; then
    echo "📦 Installing pyenv manually..."

    # Install required dependencies for pyenv
    sudo pacman -S --needed --noconfirm gcc make libffi zlib bzip2

    # Clone pyenv from GitHub
    git clone https://github.com/pyenv/pyenv.git "$HOME/.pyenv"

    # Add pyenv init commands to .zshrc if not already added
    if ! grep -q 'pyenv init' "$HOME/.zshrc"; then
        echo 'export PYENV_ROOT="$HOME/.pyenv"' >>"$HOME/.zshrc"
        echo 'export PATH="$PYENV_ROOT/bin:$PATH"' >>"$HOME/.zshrc"
        echo 'eval "$(pyenv init --path)"' >>"$HOME/.zshrc"
        echo 'eval "$(pyenv init -)"' >>"$HOME/.zshrc"
        echo "✅ Added pyenv init to .zshrc"
    fi

    echo "✅ pyenv installed successfully!"
else
    echo "✅ pyenv is already installed."
fi

# -------------------------------------
# Dotfiles
# -------------------------------------
echo "💾 Copying main config file to home root directory..."
if [[ -d "dotfiles" ]]; then
    cp dotfiles/.zshrc ~/.zshrc
    cp -r dotfiles/.zshrc.d ~/.zshrc.d
    cp dotfiles/.zshrc.d/config.d/gitconf/.gitconfig ~/.gitconfig
    cp -r dotfiles/.zshrc.d/config.d/kitty ~/.config/kitty
    cp -r dotfiles/.zshrc.d/config.d/ranger ~/.config/ranger
    cp dotfiles/.zshrc.d/config.d/vim/.vimrc ~/.vimrc
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
