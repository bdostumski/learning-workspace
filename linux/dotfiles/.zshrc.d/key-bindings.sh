#
# KEY BINDINGS
# Desciption: This file contains custom key bindings for shell configuration
#

# -----------------
# SETUP SHELL KEY BINDINGS
# -----------------
# use vi or emacs key bindings
bindkey -v # use [-v] vi key bindings, or [-e] emacs key bindings
# ---------- 
# shell navigation key bindings
# ---------- 
bindkey '^H' backward-kill-word # delete the word before the cursor "ctrl + backspace "
bindkey '^[[3;5~' kill-word # delete the word after the cursor "ctrl + delete"
bindkey '^[[3~' delete-char # delete the character under the cursor "delete"
# ---------- 
# [alt + key] key navigation use one word at a time
bindkey '^[j' backward-word # move backward one word "alt + j"
bindkey '^[k' forward-word # move forward one word "alt + k"
bindkey '^[h' backward-kill-word # delete the word before the cursor "alt +  h"
bindkey '^[l' kill-word # delete the word after the cursor "alt + l"
# ---------- 
# [ctrl + alt + key] key navigation use one char at a time
bindkey '\e^j' backward-char # move backward one character "ctrl + alt + j"
bindkey '\e^k' forward-char # move forward one character "ctrl + alt + k"
bindkey '\e^h' backward-delete-char # delete the word before the cursor "ctrl + alt + h"
bindkey '\e^l' delete-char # delete the word after the cursor "ctrl + alt + l"
# ---------- 
bindkey '^[n' beginning-of-line # move to the beginning of the line "alt + n"
bindkey '^[m' end-of-line # move to the end of the line "alt + m"

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
# bindkey '' autosuggest-next # move to the next suggestion
# bindkey '' autosuggest-previous # move to the previous suggestion

# -----------------
# SETUP HISTORY SEARCH
# -----------------
bindkey '^R' history-incremental-search-backward # search backward in history for a related command
# bindkey '' history-search-backward # search backward in history for a related command
# bindkey '' history-search-forward # search forward in history for a related command

# -----------------
# FZF KEY BINDINGS
# -----------------
bindkey '^R' fzf-history-widget # search history with fzf
# bindkey '^T' fzf-file-widget # search files with fzf
