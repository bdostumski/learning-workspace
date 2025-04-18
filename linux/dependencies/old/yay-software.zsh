#!/usr/bin/env zsh
#
# Install yay packages if not installed
#
yay -S --noconfirm core/iana-etc        # Timezone data
yay -S --noconfirm extra/libheif        # HEIF image format
yay -S --noconfirm extra/libnm          # NetworkManager
yay -S --noconfirm extra/libqalculate   # Qalculate! library
yay -S --noconfirm extra/networkmanager # NetworkManager
yay -S --noconfirm extra/sdl2_compat    # SDL 1.2 compatibility layer
yay -S --noconfirm extra/sdl3           # Simple DirectMedia Layer
yay -S --noconfirm extra/suitesparse    # Sparse matrix libraries
yay -S --noconfirm aur/mdfried          # Markdown previewer
yay -S --noconfirm aur/mu               # Maildir indexer
#yay -S --noconfirm aur/visual-studio-code-bin          # Code editor
#yay -S --noconfirm aur/postman-bin                     # API testing
#yay -S --noconfirm aur/stacer-bin                      # System optimizer
#yay -S --noconfirm aur/viber                           # Messaging app
yay -S --noconfirm aur/auto-cpufreq # CPU frequency scaling
#yay -S --noconfirm aur/backintime                      # gui backup system
#yay -S --noconfirm aur/backintime-cli                  # cli backup system
#yay -S --noconfirm aur/downgrade                       # downgrade one or more packages
#yay -S --noconfirm aur/scala                           # Scala programming language
yay -S --noconfirm aur/scalafmt # Scala code formatter
#yay -S --noconfirm aur/metals                          # Scala language server
yay -S --noconfirm aur/js-beautify     # JavaScript beautifier
yay -S --noconfirm aur/clj-kondo       # Clojure linter
yay -S --noconfirm aur/cljfmt          # Clojure formatter
yay -S --noconfirm aur/mbsync          # Maildir synchronizer
yay -S --noconfirm aur/offlineimap     # Maildir synchronizer
yay -S --noconfirm aur/stylelint-order # Stylelint plugin for ordering properties
yay -S --noconfirm aur/stylelint-scss  # Stylelint plugin for SCSS
yay -S --noconfirm aur/stylelint-less  # Stylelint plugin for LESS
yay -S --noconfirm aur/stylelint-lsp   # Stylelint plugin for LSP
yay -S --noconfirm aur/gomodifytags    # Go struct tags generator
yay -S --noconfirm aur/gotests         # Go tests generator
yay -S --noconfirm aur/dart            # Dart programming language
#yay -S --noconfirm aur/elixir                          # Elixir programming language
#yay -S --noconfirm aur/haskell-language-server         # Haskell language server
#yay -S --noconfirm aur/intellij-idea-community-edition # Java IDE

# Important: Suggestions to install
# yay -S --noconfirm aur/intellij-idea-ultimate-edition # Java IDE
# yay -S nemu # TUI for QEMU used to manage virual machines, can display the Virual Machine in the terminal using kitty graphics protocol. Should be installed independently (need configuration)
