#
# KEY BINDINGS
# Desciption: This file contains custom key bindings for shell configuration
#

# -----------------
# SETUP SHELL KEY BINDINGS
# -----------------
# use vi or emacs key bindings
bindkey -v # use vi key bindings
# bindkey -e # use emacs key bindings
# ---------- 
# shell navigation key bindings
bindkey '^[n' beginning-of-line # move to the beginning of the line "alt + n"
bindkey '^[m' end-of-line # move to the end of the line "alt + m"
bindkey '^[j' backward-word # move backward one word "alt + j"
bindkey '^[k' forward-word # move forward one word "ctrl + f"
bindkey '^[h' backward-kill-word # delete the word before the cursor "alt +  h"
bindkey '^H' backward-kill-word # delete the word before the cursor "ctrl + backspace "
bindkey '^[l' kill-word # delete the word after the cursor "alt + l"
bindkey '^[[3;5~' kill-word # delete the word after the cursor "ctrl + delete"
bindkey '^[[3~' delete-char # delete the character under the cursor "delete"
# bindkey '^B' backward-char # move backward one character "ctrl + b"
# bindkey '^F' forward-char # move forward one character "ctrl + f"
# bindkey '^P' up-line-or-history # move to the previous line in history "ctrl + p"
# bindkey '^N' down-line-or-history # move to the next line in history "ctrl + n"
# bindkey '^K' kill-line # delete from the cursor to the end of the line "ctrl + k"
# bindkey '^U' backward-kill-line # delete from the cursor to the beginning of the line "ctrl + u"
# bindkey '^W' backward-kill-word # delete the word before the cursor "ctrl + w"
# bindkey '^R' history-incremental-search-backward # search backward in history for a related command "ctrl + r"
# bindkey '^L' clear-screen # clear the screen "ctrl + l"



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
