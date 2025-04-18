#!/usr/bin/env zsh
#
# Install common tools for Arch Linux
#
# Update the system
sudo pacman -Syu --noconfirm
#
# Install core dependencies [System, Security, Vim, Zsh]"
#
packages = (

    # System Utilities
    kitty # A GPU-accelerated terminal
    tmux # Terminal multiplexer
    github-cli # GitHub CLI
    fd # Fast file search
    less # Terminal pager
    man # System manuals
    bat # Better cat command
    btop # System monitoring
    htop # Interactive process viewer
    pydf # disk space usage analyzer
    tldr # Simplified help pages for command-line tools
    reflector # Arch linux mirrorlist
    stow # Symlink manager
    ranger # Terminal file manager
    speedtest-cli # Command-line interface for speedtest.net
    openssh # SSH protocol implemantation for remote login, comman execution and file transfer
    trash-cli # Command-line trash utility
    fzf # Fuzzy finder for the command-line
    glances # An eye on your system
    lsd # A modern replacement for ls better icons and colors
    ripgrep # Faster alternative to grep for searching files
    lazygit # Terminal UI for git
    vivid # A themeable LS_COLORS generator
    k3diff # A diff tool for comparing files and directories
    httpie # A user-friendly HTTP client (better than curl)
    curl # Command-line tool for transferring data with URLs
    ncdu # Disk usage analyzer
    onefetch # Fetch information about a Git repositories
    neofetch # Show system information with a logo
    fastfetch # A faster neofetch alternative. Customization posibbilites are endless.
    cronie # Daemon to execute scheduled commands
    ufw # Linux firewall
    clamav # Linux antivirus
    git-delta # A syntax-highlighting pager for git
    ueberzug # Image preview
    wine # Windows compatibility layer

    # Fonts
    ttf-dejavu             # DejaVu fonts
    ttf-liberation         # Liberation fonts
    ttf-roboto             # Roboto fonts
    ttf-ubuntu-font-family # Ubuntu fonts
    noto-fonts             # Noto fonts
    noto-fonts-emoji       # Noto fonts with emoji
    noto-fonts-cjk         # Noto fonts with CJK support
    ttf-fira-code          # Fira Code fonts
    ttf-fira-mono          # Fira Mono fonts
    ttf-fira-sans          # Fira Sans fonts
    ttf-jetbrains-mono     # JetBrains Mono fonts
    ttf-hack               # Hack fonts
    ttf-inconsolata        # Inconsolata fonts
    nerd-fonts             # Nerd Fonts
    ttf-opensans           # Open Sans fonts

    # GUI Applications
    virtualbox # Virtual machine hypervisor
    firefox     # Web browser
    thunderbird # Email client
    filezilla   # FTP client
    gimp        # Image editor
    libreoffice # Office suite
    dbeaver     # Database management tool
    steam       # Gaming platform
    discord     # Chat application
    obs-studio  # Screen recording and streaming software
    kdenlive    # Video editor
    gparted     # Partition editor
    vlc         # Media player

    # Development Tools
    vim # Text editor
    neovim # Better Text editor
    emacs # Ide editor 
    make # Build automation tool
    gcc # C and C++ compiler
    clang # C and C++ compiler
    cmake # Cross-platform build system
    direnv # Environment variable manager
    maven # Java build automation tool
    gradle # Alternative to Maven for Java builds
    nodejs # JavaScript runtime
    npm # Node.js package manager
    yarn # JavaScript package manager
    jdk17-openjdk # Java Development Kit 21
    go # Go programming language
    gore # Go package manager
    ruby # Ruby programming language
    python # Python programming language
    python-pip # Python package manager
    python-pipenv # Python dependency manager
    pyenv # Python version manager
    rust # Rust programming language
    luarocks # Lua package manager
    cabal-install # Haskell package manager
    kotlin # Kotlin programming language
    clojure # Clojure programming language
    lighttpd # Light Web server
    php      # PHP programming language
    composer # PHP dependency manager

)

# Install packages using pacman
for package in "${packages[@]}"; do
  echo "Installing $package..."
  sudo pacman -S --needed --noconfirm "$package"
  if [ $? -ne 0 ]; then
    echo "Error installing $package. Continuing..."
  fi
done

# Python Environment Setup
python -m venv ~/.pyenv
python -m pip install --upgrade pip

# UFW Configuration
sudo systemctl enable --now ufw
sudo systemctl status ufw
sudo ufw enable
#
# sudo ufw allow 5432 # Allow PostgreSQL
sudo ufw allow http             # Allow HTTP (port 80)
sudo ufw allow https            # Allow HTTPS (port 443)
sudo ufw logging high           # Enable logging for debugging
sudo ufw deny 5900              # Block VNC if not needed
sudo ufw limit 22/tcp           # Limit SSH to prevent brute force attacs
sudo ufw default allow outgoing # Allow outgoing connections
sudo ufw default deny incoming  # Deny incoming connections

# ClamAV Configuration
sudo systemctl stop clamav-clamonacc.service
sudo systemctl stop clamav-daemon.service
sudo systemctl stop clamav-freshclam.service

sudo groupadd shadow
sudo usermod -aG shadow clamav
sudo useradd -r -s /usr/bin/nologin clamav
sudo crontab -u clamav -e
echo 'clamav ALL = (ALL) NOPASSWD: SETENV: /usr/bin/notify-send' | sudo tee /etc/sudoers.d/clamav

cat <<EOF >~/.config/systemd/user/clamav-clamonacc.service
[Service]
ExecStart=
ExecStart=/usr/sbin/clamonacc -F --fdpass --log=/var/log/clamav/clamonacc.log
EOF

sudo chown root:shadow /etc/shadow
sudo chmod 640 /etc/shadow

sudo mkdir -p /root/quarantine
sudo chown -R clamav:clamav /root/quarantine
sudo chmod -R 755 /root/quarantine

sudo chown -R clamav:clamav /var/lib/clamav
sudo chmod -R 755 /var/lib/clamav

mkdir -p ~/quarantine
sudo chown -R clamav:clamav ~/quarantine
sudo chmod -R 755 /var/run/clamav
sudo chown -R clamav:clamav /var/run/clamav

sudo mkdir -p /var/lib/clamav
sudo chmod -R 755 /var/lib/clamav
sudo chown -R 1000:1000 /var/lib/clamav
sudo chown -R clamav:clamav /var/lib/clamav

sudo mkdir -p /var/log/clamav
sudo chmod -R 755 /var/log/clamav
sudo chown -R clamav:clamav /var/log/clamav

sudo touch /var/log/clamav/freshclam.log
sudo chmod -R 755 /var/log/clamav/freshclam.log
sudo chown -R clamav:clamav /var/log/clamav/freshclam.log

sudo systemctl enable --now clamav-daemon # enable clamav daemon
sudo systemctl start clamav-daemon
systemctl status clamav-daemon
sudo systemctl enable --now clamav-freshclam # enable automaticaly update virus definition
sudo systemctl start clamav-freshclam
systemctl status clamav-freshclam
sudo freshclam # update virus definition
sudo systemctl enable --now clamav-clamonacc.service
sudo systemctl start clamav-clamonacc.service
systemctl status clamav-clamonacc.service

sudo systemctl enable --now cronie.service
sudo systemctl start cronie.service
