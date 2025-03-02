# Plugins
# Load the plugin manager

# plugins from oh-my-zsh repository
zinit snippet OMZ::plugins/z # z jump around directories with ease
zinit snippet OMZ::plugins/jsontools # json tools

# plugins from zinit repository
zinit light loiccoyle/zsh-github-copilot # github copilot
zinit light ael-code/zsh-colored-man-pages # colored man pages

# syntax highlighting - colorize commands and options
zinit light zsh-users/zsh-syntax-highlighting

# completions - use tabkey to complete commands and options
autoload -Uz compinit
zinit ice wait lucid
zinit light zdharma-continuum/fast-syntax-highlighting
zinit light zsh-users/zsh-completions
rm -f ~/.zcompdump
compinit

# autosuggestions - use ctrl+f key to accept suggestion
zinit light zsh-users/zsh-autosuggestions

# fzf - fuzzy finder completion tab
zinit light Aloxaf/fzf-tab

