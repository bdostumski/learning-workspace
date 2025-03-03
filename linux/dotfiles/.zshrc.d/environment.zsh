#!/bin/zsh
# Environment

# ZSH Environment Configuration

export TERM="xterm-256color" # Set terminal to 256 colors
export LANG='en_US.UTF-8' # Set language to US English
export LC_ALL='en_US.UTF-8' # Set locale to US English
export EDITOR="emacsclient -t -a ''" # Set editor to emacsclient
export VISUAL="emacsclient -c -a emacs" # Set visual to emacsclient
export MANPAGER="nvim +Man!"
export PAGER="nvim +Man!"

# Path Configuration
#
# add bin to path
if [ -d "$HOME/.bin" ]; then
	PATH="$HOME/.bin:$PATH"
fi

# add local bin to path
if [ -d "$HOME/.local/bin" ]; then 
	PATH="$HOME/.local/bin:$PATH"
fi

# add emacs path
if [ -d "$HOME/.emacs.d/bin" ]; then
	PATH="$HOME/.emacs.d/bin:$PATH"
fi

# add emacs config path
if [ -d "$HOME/.config/emacs/bin" ]; then
	PATH="$HOME/.config/emacs/bin:$PATH"
fi

# add Applications to path
if [ -d "$HOME/Applications" ]; then 
	PATH="$HOME/Applications:$PATH"
fi

# add tmux path
if [ -d "$HOME/.config/.tmux/plugins/tpm" ]; then
	PATH="$HOME/.config/.tmux/plugins/tpm:$PATH"
fi

if [ -d "$HOME/.config/emacs/bin/doom" ]; then
	PATH='$HOME/.config/emacs/bin/doom:$PATH'
fi

#
# Export path
export PATH

# Plugins Environment Configuration
#
# ZSH_AUTOSUGGEST_HIGHLIGHT_STYLE="fg=#ff00ff,bg=cyan,bold,underline" # set autosuggest highlight style
ZSH_AUTOSUGGEST_STRATEGY=(history completion) # set autosuggest strategy (history, completion, match_prev_cmd)
ZSH_AUTOSUGGEST_HISTORY_IGNORE="(ls|cd|pwd|exit|sudo reboot|cd -|cd ..)" # ignore these commands in autosuggest history
ZSH_AUTOSUGGEST_COMPLETION_IGNORE="(ls|cd|pwd|exit|sudo reboot|cd -|cd ..)" # ignore these commands in autosuggest completion
ZSH_IGNORE_ALL_DUPS=1 # ignore all duplicates in history
#ZSH_AUTOSUGGEST_ACCEPT_WIDGET="^V" # accept autosuggest widget
#ZSH_AUTOSUGGEST_EXECUTE_WIDGET="^X" # execute autosuggest widget
# ZSH_AUTOSUGGEST_CLEAR_WIDGET="^d" # clear autosuggest widget
# ZSH_AUTOSUGGEST_IGNORE_WIDGET="^i" # ignore autosuggest widget

# Zinit Configuration
ZINIT[PLUGINS_DIR]=$HOME/.config/zinit/share/zinit/plugins
ZINIT[SNIPPETS_DIR]=$HOME/.config/zinit/share/zinit/snippets
ZINIT_HOME="$HOME/.config/zinit"
ZINIT[COMPINIT_OPTS]=-C
ZINIT[ZCOMET_NO_UPDATE]=1
ZINIT_DEFAULT_PROTOCOL="SSH"

