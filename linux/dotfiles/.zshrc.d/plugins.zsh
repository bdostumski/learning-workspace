# Plugins
# Load the plugin manager

# plugins from oh-my-zsh repository
zinit snippet OMZ::plugins/z # z jump around directories with ease
zinit snippet OMZ::plugins/jsontools # json tools

# syntax highlighting - colorize commands and options
zinit light zsh-users/zsh-syntax-highlighting

# completions - use tabkey to complete commands and options
autoload -Uz compinit
zinit ice wait lucid
zinit light zdharma-continuum/fast-syntax-highlighting
zinit light zsh-users/zsh-completions
compinit

# autosuggestions - use ctrl+f key to accept suggestion
zinit light zsh-users/zsh-autosuggestions

# fzf - fuzzy finder completion tab
zinit light Aloxaf/fzf-tab

