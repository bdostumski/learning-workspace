#!/bin/zsh

echo "\n🌙 Checking for LunarVim installation...\n"

# ----------------------
# INSTALL LunarVim
# ----------------------
if [[ ! -d "$HOME/.config/lvim" ]]; then
    echo "📦 Installing LunarVim..."
    if LV_BRANCH='release-1.4/neovim-0.9' bash <(curl -fsSL https://raw.githubusercontent.com/LunarVim/LunarVim/release-1.4/neovim-0.9/utils/installer/install.sh); then
        echo "✅ LunarVim installed successfully."
    else
        echo "❌ LunarVim installation failed."
        exit 1
    fi
else
    echo "✅ LunarVim is already installed at ~/.config/lvim."
fi
