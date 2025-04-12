#!/usr/bin/env zsh
#
# Install yay packages if not installed
#

yay -S --noconfirm core/iana-etc # Timezone data
yay -S --noconfirm extra/libheif # HEIF image format
yay -S --noconfirm extra/libnm # NetworkManager
yay -S --noconfirm extra/libqalculate # Qalculate! library
yay -S --noconfirm extra/networkmanager # NetworkManager
yay -S --noconfirm extra/sdl2_compat # SDL 1.2 compatibility layer
yay -S --noconfirm extra/sdl3 # Simple DirectMedia Layer
yay -S --noconfirm extra/suitesparse # Sparse matrix libraries
yay -S --noconfirm aur/intellij-idea-community-edition # Java IDE
# yay -S --noconfirm aur/intellij-idea-ultimate-edition # Java IDE
yay -S --noconfirm aur/mdfried # Markdown previewer
yay -S --noconfirm aur/mu # Maildir indexer
yay -S --noconfirm aur/visual-studio-code-bin # Code editor
yay -S --noconfirm aur/postman-bin # API testing
yay -S --noconfirm aur/stacer-bin # System optimizer
yay -S --noconfirm aur/viber # Messaging app
yay -S --noconfirm aur/auto-cpufreq # CPU frequency scaling
yay -S --noconfirm aur/backintime # gui backup system
yay -S --noconfirm aur/backintime-cli # cli backup system
yay -S --noconfirm aur/downgrade # downgrade one or more packages
yay -S --noconfirm aur/scala
yay -S --noconfirm aur/scalafmt
yay -S --noconfirm aur/metals
yay -S --noconfirm aur/js-beautify
yay -S --noconfirm aur/clj-kondo
yay -S --noconfirm aur/cljfmt
yay -S --noconfirm aur/mbsync
yay -S --noconfirm aur/offlineimap
yay -S --noconfirm aur/stylelint-order
yay -S --noconfirm aur/stylelint-scss
yay -S --noconfirm aur/stylelint-less
yay -S --noconfirm aur/stylelint-lsp
yay -S --noconfirm aur/gomodifytags
yay -S --noconfirm aur/gotests
yay -S --noconfirm aur/dart
yay -S --noconfirm aur/elixir
yay -S --noconfirm aur/haskell-language-server

# Important: Suggestions to install
# yay -S nemu # TUI for QEMU used to manage virual machines, can display the Virual Machine in the terminal using kitty graphics protocol. Should be installed independently (need configuration)

