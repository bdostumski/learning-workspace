# Key Bindings

# setup zsh key bindings
bindkey -v # use vi key bindings
# bindkey -e # use emacs key bindings

# setup auto-suggestions
bindkey '^V' autosuggest-accept # accept the current suggestion
bindkey '^X' autosuggest-execute # accept and execute the current suggestion
# bindkey '' autosuggest-clear # clear autosuggestions
# bindkey '' autosuggest-fetch # fetch autosuggestions
# bindkey '' autosuggest-disable # disable autosuggestions
# bindkey '' autosuggest-enable # enable autosuggestions
# bindkey '' autosuggest-toggle # toggle autosuggestions on/off

# setup history search
bindkey '^P' history-search-backward # search backward in history for a related command
bindkey '^N' history-search-forward # search forward in history for a related command

# fzf key bindings
bindkey '^R' fzf-history-widget # search history with fzf
# bindkey '^T' fzf-file-widget # search files with fzf
