#!/usr/bin/env zsh

# -------------------------------------
# Install Common Tools for Arch Linux
# -------------------------------------

echo "🔄 Updating system..."
sudo pacman -Syu --noconfirm

# Define packages
packages=(
    # System Utilities
    kitty tmux github-cli fd less man bat btop htop pydf tldr reflector stow
    ranger speedtest-cli openssh trash-cli fzf glances lsd ripgrep lazygit vivid
    k3diff httpie curl ncdu onefetch neofetch fastfetch cronie ufw clamav git-delta
    ueberzug wine

    # Fonts
    ttf-dejavu ttf-liberation ttf-roboto ttf-ubuntu-font-family noto-fonts
    noto-fonts-emoji noto-fonts-cjk ttf-fira-code ttf-fira-mono ttf-fira-sans
    ttf-jetbrains-mono ttf-hack ttf-inconsolata nerd-fonts ttf-opensans

    # GUI Applications
    virtualbox firefox thunderbird filezilla gimp libreoffice dbeaver steam
    discord obs-studio kdenlive gparted vlc

    # Development Tools
    vim neovim emacs make gcc clang cmake direnv maven gradle nodejs npm yarn
    jdk17-openjdk go gore ruby python python-pip python-pipenv pyenv rust luarocks
    cabal-install kotlin clojure lighttpd php composer
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

echo "🧹 Cleaning up orphaned packages..."
sudo pacman -Rns --noconfirm $(pacman -Qdtq)

# -------------------------------------
# Python Environment Setup
# -------------------------------------
python -m venv ~/.pyenv && source ~/.pyenv/bin/activate
python -m pip install --upgrade pip

# -------------------------------------
# UFW Firewall Configuration
# -------------------------------------
echo "🔧 Configuring UFW firewall..."
sudo systemctl enable --now ufw
sudo ufw --force enable
sudo ufw allow http https
sudo ufw deny 5900
sudo ufw limit 22/tcp
sudo ufw default allow outgoing
sudo ufw default deny incoming
sudo ufw logging high

# -------------------------------------
# ClamAV Configuration
# -------------------------------------
echo "🛡️ Setting up ClamAV..."

# Stop existing ClamAV services
sudo systemctl stop clamav-clamonacc.service clamav-daemon.service clamav-freshclam.service

# Ensure clamav user and shadow group exist
sudo groupadd -f shadow
sudo usermod -aG shadow clamav
sudo useradd -r -s /usr/bin/nologin clamav 2>/dev/null || true

# Permissions
sudo chown root:shadow /etc/shadow && sudo chmod 640 /etc/shadow

# Create required directories
sudo install -d -o clamav -g clamav -m 755 /var/lib/clamav /var/log/clamav /var/run/clamav /root/quarantine
install -d ~/quarantine && sudo chown -R clamav:clamav ~/quarantine

# Freshclam log
sudo touch /var/log/clamav/freshclam.log
sudo chown clamav:clamav /var/log/clamav/freshclam.log
sudo chmod 644 /var/log/clamav/freshclam.log

# Systemd user override
mkdir -p ~/.config/systemd/user
cat <<EOF >~/.config/systemd/user/clamav-clamonacc.service
[Service]
ExecStart=
ExecStart=/usr/sbin/clamonacc -F --fdpass --log=/var/log/clamav/clamonacc.log
EOF

# Allow notifications
echo 'clamav ALL=(ALL) NOPASSWD: SETENV: /usr/bin/notify-send' | sudo tee /etc/sudoers.d/clamav >/dev/null

# Enable and start ClamAV services
sudo systemctl enable --now clamav-daemon clamav-freshclam clamav-clamonacc.service
sudo systemctl start clamav-daemon clamav-freshclam clamav-clamonacc.service
sudo freshclam

# Enable scheduled tasks
sudo systemctl enable --now cronie.service

echo -e "\n🎉 Setup complete. Your system is ready!"
