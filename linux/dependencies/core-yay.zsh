#!/usr/bin/env zsh
#
# Install yay packages if not installed
#

yay -S --noconfirm aur/visual-studio-code-bin          # Code editor
yay -S --noconfirm aur/postman-bin                     # API testing
yay -S --noconfirm aur/stacer-bin                      # System optimizer
yay -S --noconfirm aur/viber                           # Messaging app
yay -S --noconfirm aur/backintime                      # gui backup system
yay -S --noconfirm aur/backintime-cli                  # cli backup system
yay -S --noconfirm aur/downgrade                       # downgrade one or more packages
yay -S --noconfirm aur/scala                           # Scala programming language
yay -S --noconfirm aur/metals                          # Scala language server
yay -S --noconfirm aur/elixir                          # Elixir programming language
yay -S --noconfirm aur/haskell-language-server         # Haskell language server
yay -S --noconfirm aur/intellij-idea-community-edition # Java IDE
yay -S --noconfirm aur/elixir                          # Elixir programming language

# Important: Suggestions to install
# yay -S --noconfirm aur/intellij-idea-ultimate-edition # Java IDE
# yay -S nemu # TUI for QEMU used to manage virual machines, can display the Virual Machine in the terminal using kitty graphics protocol. Should be installed independently (need configuration)
