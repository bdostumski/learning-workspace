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
    mv ~/.zshrc ~/.zshrc.bak
    cp ./dotfiles/.zshrc ~/.zshrc

    mv ~/.zshrc.d ~/.zshrc.d.bak
    cp -r ./dotfiles/.zshrc.d ~/

    mv ~/.gitconfig ~/.gitconfig.bak
    cp ./dotfiles/.zshrc.d/config.d/gitconf/.gitconfig ~/

    mv ~/.config/kitty ~/.config/kitty.bak
    cp -r ./dotfiles/.zshrc.d/config.d/kitty ~/.config/

    mv ~/.config ~/.config/ranger.bak
    cp -r ./dotfiles/.zshrc.d/config.d/ranger ~/.config/

    mv ~/.vimrc ~/.vimrc.bak
    cp ./dotfiles/.zshrc.d/config.d/vim/.vimrc ~/

    mv ~/.config/doom ~/.config/doom.bak
    cp -r ~/.zshrc.d/config.d/doom ~/.config/

    mv ~/.env.zsh ~/.env.zsh.bak
    cp ~/.zshrc.d/config.d/env/.env.zsh ~/

    mv ~/.config/lvim ~/.config/lvim.bak
    cp -r ~/.zshrc.d/config.d/lvim ~/.config/

    mv ~/.config/tmux ~/.config/tmux.bak
    cp -r ~/.zshrc.d/config.d/tmux ~/.config/

    sudo mv /etc/pacman.conf /etc/pacman.d/pacman.conf.bak
    sudo cp ~/.zshrc.d/config.d/arch/pacman.conf /etc/pacman.conf

    sudo mv /etc/clamav /etc/clamav.bak
    sudo cp -r ~/.zshrc.d/config.d/clamav /etc/clamav

    sudo mv /etc/cron.daily /etc/cron.daily.bak
    sudo cp -r ~/.zshrc.d/config.d/cron.daily /etc/cron.daily

    sudo mv /etc/cron.weekly /etc/cron.weekly.bak
    sudo cp -r ~/.zshrc.d/config.d/cron.weekly /etc/cron.weekly

    sudo mv /etc/ufw/before.rules /etc/ufw/before.rules.bak
    sudo cp ~/.zshrc.d/config.d/ufw/before.rules /etc/ufw/before.rules

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
