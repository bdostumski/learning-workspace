#!/usr/bin/env zsh

# Install yay packages one by one with status icons

packages=(
    # Code editor
    aur/visual-studio-code-bin
    # API testing
    aur/postman-bin
    # System optimizer
    aur/stacer-bin
    # Messaging app
    aur/viber
    # GUI backup system
    aur/backintime
    # CLI backup system
    aur/backintime-cli
    # Downgrade packages
    aur/downgrade
    # Scala programming language
    aur/scala
    # Scala language server
    aur/metals
    # Elixir programming language
    aur/elixir
    # Haskell language server
    aur/haskell-language-server
    # Java IDE
    aur/intellij-idea-community-edition
)

echo "\n🔧 Starting installation of AUR packages...\n"

for pkg in "${packages[@]}"; do
    echo "📦 Installing: $pkg"
    if yay -S --noconfirm "$pkg" &>/dev/null; then
        echo "✅ Success: $pkg installed"
    else
        echo "❌ Failed: $pkg installation failed"
    fi
    echo ""
done

echo "🏁 All packages processed."

# Suggestions (manual install/configuration may be required):
# yay -S --noconfirm aur/intellij-idea-ultimate-edition  # Java IDE (Ultimate)
# yay -S nemu  # TUI for QEMU, supports Kitty graphics protocol (requires config)
