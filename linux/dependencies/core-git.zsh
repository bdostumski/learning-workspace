#!/bin/zsh

# ----------------------------------------
# Install yay (AUR Helper)
# ----------------------------------------
if ! command -v yay &>/dev/null; then
    echo "📦 Installing yay..."
    sudo pacman -S --needed git base-devel --noconfirm
    tmpdir=$(mktemp -d)
    git clone https://aur.archlinux.org/yay.git "$tmpdir/yay"
    cd "$tmpdir/yay" && makepkg -si --noconfirm
    cd ~ && rm -rf "$tmpdir"
else
    echo "✅ yay is already installed."
fi

# ----------------------------------------
# Install Tmux Plugin Manager (TPM)
# ----------------------------------------
TPM_DIR="$HOME/.config/tmux/plugins/tpm"
if [ ! -d "$TPM_DIR" ]; then
    echo "📦 Installing TPM..."
    git clone https://github.com/tmux-plugins/tpm "$TPM_DIR"
else
    echo "✅ TPM already exists at $TPM_DIR"
fi

# ----------------------------------------
# Install Zinit (Zsh Plugin Manager)
# ----------------------------------------
if [ ! -d "$HOME/.config/zinit" ]; then
    echo "📦 Installing Zinit..."
    bash -c "$(curl -fsSL https://raw.githubusercontent.com/zdharma-continuum/zinit/HEAD/scripts/install.sh)"
else
    echo "✅ Zinit already installed."
fi
