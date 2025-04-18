#!/usr/bin/env zsh
#
# ----------------------------------------------------------------------
# Install DevOps Tools on Arch Linux
# ----------------------------------------------------------------------
# Update the system
echo "🔄 Updating system packages..."
sudo pacman -Syu --noconfirm

# DevOps packages to install
packages=(
    docker terraform ansible
    minikube kubeadm kubectl
    containerd helm vagrant
)

# Install all packages in one pacman call (faster, no loop)
echo "📥 Installing DevOps tools..."
sudo pacman -S --needed --noconfirm ${packages[@]}

# 🧹 Remove orphaned packages
echo "🧹 Removing orphaned packages..."
orphans=$(pacman -Qdtq)
if [[ -n "$orphans" ]]; then
    sudo pacman -Rns --noconfirm $orphans
else
    echo "✅ No orphaned packages found."
fi

echo "🎉 DevOps tools installed successfully!"
