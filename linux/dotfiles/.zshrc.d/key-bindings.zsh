#!/usr/bin/env zsh
#
# KEY BINDINGS
# Desciption: This file contains custom key bindings for shell configuration
#

# -----------------
# SETUP SHELL KEY BINDINGS
# -----------------

# ----------
# use vi or emacs key bindings
# bindkey -v # use [-v] vi key bindings, or [-e] emacs key bindings
# ----------
# shell navigation key bindings
# ----------
bindkey '^H' backward-kill-word # delete the word before the cursor "ctrl + backspace "
bindkey '^[[3;5~' kill-word     # delete the word after the cursor "ctrl + delete"
bindkey '^[[3~' delete-char     # delete the character under the cursor "delete"
# ----------
# [alt + key] key navigation use one word at a time
bindkey '\e^j' backward-word      # move backward one word "ctrl + alt + j"
bindkey '\e^k' forward-word       # move forward one word "ctrl + alt + k"
bindkey '\e^h' backward-kill-word # delete the word before the cursor "ctrl + alt +  h"
bindkey '\e^l' kill-word          # delete the word after the cursor "ctrl + alt + l"
# ----------
# [ctrl + alt + key] key navigation use one char at a time
bindkey '^[j' backward-char        # move backward one character "alt + j"
bindkey '^[k' forward-char         # move forward one character "alt + k"
bindkey '^[h' backward-delete-char # delete the word before the cursor "alt + h"
bindkey '^[l' delete-char          # delete the word after the cursor "alt + l"
bindkey '^[i' backward-kill-word   # delete the word before the cursor "alt +  i"
bindkey '^[o' kill-word            # delete the word after the cursor "alt + o"
# ----------
bindkey '^[n' beginning-of-line # move to the beginning of the line "alt + n"
bindkey '^[m' end-of-line       # move to the end of the line "alt + m"

# -----------------
# GITHUB COPILOT KEY BINDINGS
# -----------------
bindkey '^[|' zsh_gh_copilot_explain # bind Alt+shift+\ to explain
bindkey '^[\' zsh_gh_copilot_suggest # bind Alt+\ to suggest

# -----------------
# SETUP AUTO-SUGGESTIONS
# -----------------
bindkey '^F' autosuggest-accept  # accept the current suggestion
bindkey '^D' autosuggest-execute # accept and execute the current suggestion
# bindkey '' autosuggest-toggle # toggle autosuggestions on/off

# -----------------
# SETUP HISTORY SEARCH
# -----------------
bindkey '^R' history-incremental-search-backward # search backward in history for a related command
bindkey '^[]' history-beginning-search-forward   # search forward in history for a related command
bindkey '^[[' history-beginning-search-backward  # search backward in history for a related command
#
# -----------------
# FZF KEY BINDINGS
# -----------------
bindkey '^R' fzf-history-widget # search history with fzf
# bindkey '^T' fzf-file-widget # search files with fzf
