#
# KEY BINDINGS
# Desciption: This file contains custom key bindings for shell configuration
#

# -----------------
# SETUP SHELL KEY BINDINGS
# -----------------
bindkey -v # use vi key bindings
# bindkey -e # use emacs key bindings

# -----------------
# GITHUB COPILOT KEY BINDINGS
# -----------------
bindkey '^[|' zsh_gh_copilot_explain  # bind Alt+shift+\ to explain
bindkey '^[\' zsh_gh_copilot_suggest  # bind Alt+\ to suggest

# -----------------
# SETUP AUTO-SUGGESTIONS
# -----------------
bindkey '^F' autosuggest-accept # accept the current suggestion
bindkey '^D' autosuggest-execute # accept and execute the current suggestion
# bindkey '' autosuggest-clear # clear autosuggestions
# bindkey '' autosuggest-fetch # fetch autosuggestions
# bindkey '' autosuggest-disable # disable autosuggestions
# bindkey '' autosuggest-enable # enable autosuggestions
# bindkey '' autosuggest-toggle # toggle autosuggestions on/off
# bindkey '^N' autosuggest-next # move to the next suggestion
# bindkey '^P' autosuggest-previous # move to the previous suggestion

# -----------------
# SETUP HISTORY SEARCH
# -----------------
# bindkey '^J' history-search-backward # search backward in history for a related command
# bindkey '^K' history-search-forward # search forward in history for a related command
bindkey '^R' history-incremental-search-backward # search backward in history for a related command

# -----------------
# FZF KEY BINDINGS
# -----------------
bindkey '^R' fzf-history-widget # search history with fzf
# bindkey '^T' fzf-file-widget # search files with fzf
