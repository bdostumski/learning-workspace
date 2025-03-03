# Key Bindings

# setup zsh key bindings
bindkey -v # use vi key bindings
# bindkey -e # use emacs key bindings

# github copilot key bindings
bindkey '^[|' zsh_gh_copilot_explain  # bind Alt+shift+\ to explain
bindkey '^[\' zsh_gh_copilot_suggest  # bind Alt+\ to suggest

# setup auto-suggestions
bindkey '^F' autosuggest-accept # accept the current suggestion
bindkey '^D' autosuggest-execute # accept and execute the current suggestion
# bindkey '' autosuggest-clear # clear autosuggestions
# bindkey '' autosuggest-fetch # fetch autosuggestions
# bindkey '' autosuggest-disable # disable autosuggestions
# bindkey '' autosuggest-enable # enable autosuggestions
# bindkey '' autosuggest-toggle # toggle autosuggestions on/off

# setup history search
bindkey '^J' history-search-backward # search backward in history for a related command
bindkey '^K' history-search-forward # search forward in history for a related command

# fzf key bindings
bindkey '^R' fzf-history-widget # search history with fzf
# bindkey '^T' fzf-file-widget # search files with fzf
