#
# Plugins
# Description: Install and configure shell plugins
#

# -----------------
# Load the plugin manager
# -----------------
zinit snippet OMZ::plugins/z # z jump around directories with ease
zinit light loiccoyle/zsh-github-copilot # github copilot
zinit light ael-code/zsh-colored-man-pages # colored man pages
zinit light zsh-users/zsh-autosuggestions # autosuggestions - use ctrl+f key to accept suggestion
zinit light Aloxaf/fzf-tab # fzf - fuzzy finder completion tab
zinit light zsh-users/zsh-syntax-highlighting # syntax highlighting - colorize commands and options

# -----------------
# Completions - use tabkey to complete commands and options
# -----------------
autoload -Uz compinit
zinit ice wait lucid
zinit light zdharma-continuum/fast-syntax-highlighting
zinit light zsh-users/zsh-completions
rm -f ~/.zcompdump
compinit -d "$HOME/.logs.d/zcompdump"
