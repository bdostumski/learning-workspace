#!/usr/bin/env zsh
#
# Install DevOps tools for Arch Linux
#
# Update the system
sudo pacman -Syu --noconfirm
#
# Install DevOps dependencies [Docker, K8s, Vagrant, etc.]"
#
packages = (

  docker # Container engine
  terraform # Infrastructure as code tool
  ansible # Automation tool for configuration management
  minikube   # Run Kubernetes locally
  kubeadm    # Kubernetes cluster setup tool
  kubectl    # Kubernetes command-line tool
  containerd # Container runtime
  helm       # Kubernetes package manager
  vagrant    # Virtual machine automation

)

# Install packages using pacman
for package in "${packages[@]}"; do
  echo "Installing $package..."
  sudo pacman -S --needed --noconfirm "$package"
  if [ $? -ne 0 ]; then
    echo "Error installing $package. Continuing..."
  fi
done
