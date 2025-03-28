#
# Install common tools for Arch Linux
#

# Update the system
sudo pacman -Syu --noconfirm
#
# List of packages to install
packages=(
	# Command-Line Utilities
	git # Version control system
	zsh # Zsh Shell
	mdcat # A cat alternative with markdown rendering
  fd # 
	bat # A cat alternative with syntax highlighting
	btop # A graphical system monitor (better than htop)
	tldr # Simplified help pages for command-line tools
	reflector # Arch linux mirrorlist
	github-cli # github command line
	less # show text line by line
	pydf # disk space usage analyzer
	htop # An interactive process viewer
	stow # Manages symlinks (useful for dotfiles)
	ranger # File manager with VI keybindings
	ueberzug # Image preview
	ffmpegthumbnailer # Video thumbnails
	highlight # Syntax highlithing for text previews 
	poppler # PDF previews
	mediainfo # Medatada for media files
	feh # image
	mpv # video 
	zathura # pdf
	sxiv # X image viewr
	speedtest-cli # Command-line interface for speedtest.net
	zathura # Document viewer with vi keybindings
	# zathura-pdf-mupdf # PDF support for Zathura
	zathura-pdf-poppler # PDF support for Zathura
	mpv # Terminal Media player
	glances # An eye on your system
	tmux # Terminal multiplexer
	trash-cli # Command-line trash utility 
	fzf # Fuzzy finder for the command-line
	xclip # Command-line interface to the X11 clipboard
	xsel # Command-line clipboard and selection tool
	eza # A modern replacement for ls
	lsd # A modern replacement for ls better icons and colors
	vivid # A themeable LS_COLORS generator
	ripgrep # Faster alternative to grep for searching files
	lazygit # Terminal UI for git
	git-delta # A syntax-highlighting pager for git
	k3diff # A diff tool for comparing files and directories
	httpie # A user-friendly HTTP client (better than curl)
	ncdu # Disk usage analyzer
	onefetch # Fetch information about a Git repositories
	neofetch # Show system information with a logo
	fastfetch # A faster neofetch alternative. Customization posibbilites are endless.
	wine # Windows compatibility layer

	# Development Tools 
	neovim # A modern Vim-based text editor
	emacs # A powerful text editor (Doom Emacs is recommended)
	tree-sitter # Parser generator tool and incremental parsing library
	kitty # A GPU-accelerated terminal 
	maven # Java build automation tool
	gradle # Alternative to Maven for Java builds
	nodejs # JavaScript runtime
	npm # Node.js package manager
	yarn # JavaScript package manager
	jdk21-openjdk # Java Development Kit 21
	ruby # Ruby programming language
	go # Go programming language
	nginx # Web server
	php # PHP programming language
	composer # PHP dependency manager
	python # Python programming language
	pyenv # Python version manager
	mariadb # MySQL database
	postgresql # Object-relational database
	redis # In-memory data structure store
	cmake # Cross-platform build system
	make # Build automation tool
	gcc # C and C++ compiler
	clang # C and C++ compiler
	lighttpd # Web server

	# Codecs & Fonts
	vlc # Media player
	ttf-dejavu # DejaVu fonts
	ttf-liberation # Liberation fonts
	ttf-roboto # Roboto fonts
	ttf-ubuntu-font-family # Ubuntu fonts
	noto-fonts # Noto fonts
	noto-fonts-emoji # Noto fonts with emoji
	noto-fonts-cjk # Noto fonts with CJK support
	ttf-fira-code # Fira Code fonts
	ttf-fira-mono # Fira Mono fonts
	ttf-fira-sans # Fira Sans fonts
	ttf-jetbrains-mono # JetBrains Mono fonts
	ttf-hack # Hack fonts
	ttf-inconsolata # Inconsolata fonts
	nerd-fonts # Nerd Fonts
	ttf-opensans # Open Sans fonts

	# DevOps & Containeriztion
	docker # Container engine
	minikube # Run Kubernetes locally
	kubeadm # Kubernetes cluster setup tool
	kubectl # Kubernetes command-line tool
	containerd # Container runtime
	helm # Kubernetes package manager
	vagrant # Virtual machine automation
	virtualbox # Virtual machine hypervisor

	# GUI Applications
	firefox # Web browser
	thunderbird # Email client
	filezilla # FTP client
	gimp # Image editor
	libreoffice # Office suite
	dbeaver # Database management tool
	steam # Gaming platform
	discord # Chat application
	obs-studio # Screen recording and streaming software
	kdenlive # Video editor
	gparted # Partition editor

)

# Install packages using pacman
for package in "${packages[@]}"; do
	echo "Installing $package..."
	sudo pacman -S --needed --noconfirm "$package"
	if [ $? -ne 0 ]; then
		echo "Error installing $package. Continuing..."
	fi
done
