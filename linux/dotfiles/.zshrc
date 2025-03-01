# Zsh Config

# if not running shell interactively, don't do anyting
[[ $- != *i* ]] && return

# set ZDOTDIR
export ZDOTDIR="$HOME"

# set the directory we want to store zinit and plugins
ZINIT_HOME="$ZDOTDIR/.zshrc.d/zinit.d/.zinit.git"

# download zinit, if not already installed
if [[ ! -d "$ZINIT_HOME" ]]; then
	mkdir -p "$(dirname $ZINIT_HOME)"
	git clone https://github.com/zdharma-continuum/zinit.git "$ZINIT_HOME"
fi

# create logs directory for application history and log files
if [[ ! -d "$HOME/.logs.d" ]]; then
	mkdir -p "$HOME/.logs.d"
	touch "$HOME/.logs.d/.zsh_history"
fi

# load zinit plugin manager
source "${ZINIT_HOME}/zinit.zsh"

# load enviroment variables
[ -f "$ZDOTDIR/.zshrc.d/environment.zsh" ] && source "$ZDOTDIR/.zshrc.d/environment.zsh"

# load aliases
[ -f "$ZDOTDIR/.zshrc.d/aliases.zsh" ] && source "$ZDOTDIR/.zshrc.d/aliases.zsh"

# load functions 
[ -f "$ZDOTDIR/.zshrc.d/functions.zsh" ] && source "$ZDOTDIR/.zshrc.d/functions.zsh"

# load history settings
[ -f "$ZDOTDIR/.zshrc.d/history.zsh" ] && source "$ZDOTDIR/.zshrc.d/history.zsh"

# load key bindings
[ -f "$ZDOTDIR/.zshrc.d/key-bindings.zsh" ] && source "$ZDOTDIR/.zshrc.d/key-bindings.zsh"

# load plugins
[ -f "$ZDOTDIR/.zshrc.d/plugins.zsh" ] && source "$ZDOTDIR/.zshrc.d/plugins.zsh"

# custom profile settings
[ -f "$ZDOTDIR/.zshrc.d/profile.zsh" ] && source "$ZDOTDIR/.zshrc.d/profile.zsh"

# load local machine-specific configuration (optional)
# this file is for settings that should not be shared between machines
[ -f "$ZDOTDIR/.zshrc.d/local.zsh" ] && source "$ZDOTDIR/.zshrc.d/local.zsh"
