#!/usr/bin/env zsh
#
# Install common tools for Arch Linux
#

# Update the system
sudo pacman -Syu --noconfirm
#
# List of packages to install
packages=(
  # Command-Line Utilities
  #  git                 # Version control system
  #---  zsh                 # Zsh Shell
  # no-needed  mdcat   # A cat alternative with markdown rendering
  #  openssh # SSH protocol implemantation for remote login, comman execution and file transfer
  # man      # System manuals
  eslint   # JavaScript linter
  prettier # Code formatter
  #  fd                  #File finder
  #  isync      # IMAP email synchronization
  shellcheck #Shell script analysis tool
  # ufw        # Linux firewall
  # clamav     # Linux antivirus
  ansible # Automation tool for configuration management
  #  bat                 # A cat alternative with syntax highlighting
  #  btop                # A graphical system monitor (better than htop)
  # tldr                # Simplified help pages for command-line tools
  #  reflector           # Arch linux mirrorlist
  #  github-cli          # github command line
  #  less                # show text line by line
  # pydf # disk space usage analyzer
  #  htop                # An interactive process viewer
  #  stow                # Manages symlinks (useful for dotfiles)
  #  ranger              # File manager with VI keybindings
  # ueberzug          # Image preview
  # no  ffmpegthumbnailer # Video thumbnails
  highlight # Syntax highlithing for text previews
  # no poppler   # PDF previews
  # no  mediainfo # Medatada for media files
  # no feh               # image
  # no mpv     # video
  # no zathura # pdf
  # no sxiv              # X image viewr
  #  speedtest-cli       # Command-line interface for speedtest.net
  # no zathura # Document viewer with vi keybindings
  # no zathura-pdf-poppler # PDF support for Zathura
  # no  mpv # Terminal Media player
  # glances             # An eye on your system
  # tmux                # Terminal multiplexer
  # trash-cli           # Command-line trash utility
  # fzf                 # Fuzzy finder for the command-line
  # no  xclip # Command-line interface to the X11 clipboard
  # no xsel  # Command-line clipboard and selection tool
  # no eza   # A modern replacement for ls
  #  lsd       # A modern replacement for ls better icons and colors
  # vivid # A themeable LS_COLORS generator
  #  ripgrep   # Faster alternative to grep for searching files
  #  lazygit   # Terminal UI for git
  # git-delta # A syntax-highlighting pager for git
  # k3diff    # A diff tool for comparing files and directories
  # httpie    # A user-friendly HTTP client (better than curl)
  # curl      # Command-line tool for transferring data with URLs
  # ncdu      # Disk usage analyzer
  # onefetch  # Fetch information about a Git repositories
  # neofetch  # Show system information with a logo
  # fastfetch # A faster neofetch alternative. Customization posibbilites are endless.
  #  wine     # Windows compatibility layer
  # lighttpd # Light Web server

  # Development Tools
  # direnv # Environment variable manager
  # neovim   # A modern Vim-based text editor
  #  luarocks # Lua package manager
  stylua # Lua code formatter
  # emacs    # A powerful text editor (Doom Emacs is recommended)
  # no wl-clipboard     # Clipboard manager for Wayland
  # no gnome-screenshot # Screenshot tool
  # tree-sitter             # Parser generator tool and an incremental parsing library
  # kitty                   # A GPU-accelerated terminal
  # maven                   # Java build automation tool
  # gradle                  # Alternative to Maven for Java builds
  # nodejs                  # JavaScript runtime
  # npm                     # Node.js package manager
  # yarn                    # JavaScript package manager
  # jdk17-openjdk           # Java Development Kit 21
  #  ruby # Ruby programming language
  # go                      # Go programming language
  gopls # Go language server
  # gore                    # Go package manager
  hoogle #Haskell API search engine
  #  kotlin                  # Kotlin programming language
  ktlint # Kotlin linter
  #  clojure                 # Clojure programming language
  sbcl                    # Common Lisp compiler
  gnuplot                 # Plotting utility
  tidy                    # HTML cleaner
  haskell-language-server # Haskell language server
  emacs-haskell-mode      # Haskell mode for Emacs
  shfmt                   #Shell script formatter
  #  cabal-install           # Haskell package manager
  stylelilnt #Haskell linter
  # NO nginx                   # Web server
  #php      # PHP programming language
  # composer # PHP dependency manager
  # python          # Python programming language
  python-pyflakes # Python linter
  python-isort    # Python import sorter
  # python-pip      # Python package manager
  # python-pipenv   # Python dependency manager
  python-nose   # Python testing framework
  python-pytest # Python testing framework
  python-black  # Python code formatter
  # pyenv           # Python version manager
  # rust            # Rust programming language
  rust-analyzer # Language server for Rust
  # no mariadb         # MySQL database
  # no postgresql      # Object-relational database
  # no redis # In-memory data structure store
  # cmake           # Cross-platform build system
  # cronie          # Daemon to execute scheduled commands
  #  make                    # Build automation tool
  #  gcc                     # C and C++ compiler
  #  clang                   # C and C++ compiler
  # lighttpd # Web server
  # vlc      # Media player
  # Codecs & Fonts
  # ttf-dejavu             # DejaVu fonts
  # ttf-liberation         # Liberation fonts
  # ttf-roboto             # Roboto fonts
  # ttf-ubuntu-font-family # Ubuntu fonts
  # noto-fonts             # Noto fonts
  # noto-fonts-emoji       # Noto fonts with emoji
  # noto-fonts-cjk         # Noto fonts with CJK support
  # ttf-fira-code          # Fira Code fonts
  # ttf-fira-mono          # Fira Mono fonts
  # ttf-fira-sans          # Fira Sans fonts
  # ttf-jetbrains-mono     # JetBrains Mono fonts
  # ttf-hack               # Hack fonts
  # ttf-inconsolata        # Inconsolata fonts
  # nerd-fonts             # Nerd Fonts
  # ttf-opensans           # Open Sans fonts

  # DevOps & Containeriztion
  # docker # Container engine
  # terraform
  # minikube   # Run Kubernetes locally
  # kubeadm    # Kubernetes cluster setup tool
  # kubectl    # Kubernetes command-line tool
  # containerd # Container runtime
  # helm       # Kubernetes package manager
  # vagrant    # Virtual machine automation
  # virtualbox # Virtual machine hypervisor

  # GUI Applications
  #firefox     # Web browser
  #thunderbird # Email client
  #filezilla   # FTP client
  #gimp        # Image editor
  #libreoffice # Office suite
  #dbeaver     # Database management tool
  #steam       # Gaming platform
  #discord     # Chat application
  #obs-studio  # Screen recording and streaming software
  #kdenlive    # Video editor
  #gparted     # Partition editor

)

# Install packages using pacman
#for package in "${packages[@]}"; do
#  echo "Installing $package..."
#  sudo pacman -S --needed --noconfirm "$package"
#  if [ $? -ne 0 ]; then
#    echo "Error installing $package. Continuing..."
#  fi
#done
#
## Python Environment Setup
#python -m venv ~/.pyenv
#python -m pip install --upgrade pip
#
## UFW Configuration
#sudo systemctl enable --now ufw
#sudo systemctl status ufw
#sudo ufw enable
##
## sudo ufw allow 5432 # Allow PostgreSQL
#sudo ufw allow http             # Allow HTTP (port 80)
#sudo ufw allow https            # Allow HTTPS (port 443)
#sudo ufw logging high           # Enable logging for debugging
#sudo ufw deny 5900              # Block VNC if not needed
#sudo ufw limit 22/tcp           # Limit SSH to prevent brute force attacs
#sudo ufw default allow outgoing # Allow outgoing connections
#sudo ufw default deny incoming  # Deny incoming connections
#
## ClamAV Configuration
#sudo systemctl stop clamav-clamonacc.service
#sudo systemctl stop clamav-daemon.service
#sudo systemctl stop clamav-freshclam.service
#
#sudo groupadd shadow
#sudo usermod -aG shadow clamav
#sudo useradd -r -s /usr/bin/nologin clamav
#sudo crontab -u clamav -e
#echo 'clamav ALL = (ALL) NOPASSWD: SETENV: /usr/bin/notify-send' | sudo tee /etc/sudoers.d/clamav
#
#cat <<EOF >~/.config/systemd/user/clamav-clamonacc.service
#[Service]
#ExecStart=
#ExecStart=/usr/sbin/clamonacc -F --fdpass --log=/var/log/clamav/clamonacc.log
#EOF
#
#sudo chown root:shadow /etc/shadow
#sudo chmod 640 /etc/shadow
#
#sudo mkdir -p /root/quarantine
#sudo chown -R clamav:clamav /root/quarantine
#sudo chmod -R 755 /root/quarantine
#
#sudo chown -R clamav:clamav /var/lib/clamav
#sudo chmod -R 755 /var/lib/clamav
#
#mkdir -p ~/quarantine
#sudo chown -R clamav:clamav ~/quarantine
#sudo chmod -R 755 /var/run/clamav
#sudo chown -R clamav:clamav /var/run/clamav
#
#sudo mkdir -p /var/lib/clamav
#sudo chmod -R 755 /var/lib/clamav
#sudo chown -R 1000:1000 /var/lib/clamav
#sudo chown -R clamav:clamav /var/lib/clamav
#
#sudo mkdir -p /var/log/clamav
#sudo chmod -R 755 /var/log/clamav
#sudo chown -R clamav:clamav /var/log/clamav
#
#sudo touch /var/log/clamav/freshclam.log
#sudo chmod -R 755 /var/log/clamav/freshclam.log
#sudo chown -R clamav:clamav /var/log/clamav/freshclam.log
#
#sudo systemctl enable --now clamav-daemon # enable clamav daemon
#sudo systemctl start clamav-daemon
#systemctl status clamav-daemon
#sudo systemctl enable --now clamav-freshclam # enable automaticaly update virus definition
#sudo systemctl start clamav-freshclam
#systemctl status clamav-freshclam
#sudo freshclam # update virus definition
#sudo systemctl enable --now clamav-clamonacc.service
#sudo systemctl start clamav-clamonacc.service
#systemctl status clamav-clamonacc.service
#
#sudo systemctl enable --now cronie.service
#sudo systemctl start cronie.service
