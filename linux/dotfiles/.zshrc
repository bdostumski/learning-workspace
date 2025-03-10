# Zsh Config

# if not running shell interactively, don't do anyting
[[ $- != *i* ]] && return

# set ZDOTDIR
export ZDOTDIR="$HOME"

# set the directory we want to store zinit and plugins
ZINIT_HOME="$HOME/.config/zinit/.zinit.git"
# download zinit, if not already installed
if [[ ! -d "$ZINIT_HOME" ]]; then
	mkdir -p "$(dirname $ZINIT_HOME)"
	git clone https://github.com/zdharma-continuum/zinit.git "$ZINIT_HOME"
fi

# load zinit plugin manager
source "${ZINIT_HOME}/zinit.zsh"

# create logs directory for application history and log files
if [[ ! -d "$HOME/.logs.d" ]]; then
	mkdir -p "$HOME/.logs.d"
	touch "$HOME/.logs.d/.zsh_history"
fi

# load enviroment variables
[ -f "$ZDOTDIR/.zshrc.d/environment.sh" ] && source "$ZDOTDIR/.zshrc.d/environment.sh"

# load aliases
[ -f "$ZDOTDIR/.zshrc.d/aliases.sh" ] && source "$ZDOTDIR/.zshrc.d/aliases.sh"

# load template files
[ -f "$ZDOTDIR/.zshrc.d/templates.sh" ] && source "$ZDOTDIR/.zshrc.d/templates.sh"

# load functions 
[ -f "$ZDOTDIR/.zshrc.d/functions.sh" ] && source "$ZDOTDIR/.zshrc.d/functions.sh"

# load history settings
[ -f "$ZDOTDIR/.zshrc.d/history.sh" ] && source "$ZDOTDIR/.zshrc.d/history.sh"

# load key bindings
[ -f "$ZDOTDIR/.zshrc.d/key-bindings.sh" ] && source "$ZDOTDIR/.zshrc.d/key-bindings.sh"

# load plugins
[ -f "$ZDOTDIR/.zshrc.d/plugins.sh" ] && source "$ZDOTDIR/.zshrc.d/plugins.sh"

# custom profile settings
[ -f "$ZDOTDIR/.zshrc.d/profile.sh" ] && source "$ZDOTDIR/.zshrc.d/profile.sh"

# load local machine-specific configuration (optional)
# this file is for settings that should not be shared between machines
[ -f "$ZDOTDIR/.zshrc.d/local.sh" ] && source "$ZDOTDIR/.zshrc.d/local.sh"

# Load a few important annexes, without Turbo
# (this is currently required for annexes)
zinit light-mode for \
    zdharma-continuum/zinit-annex-as-monitor \
    zdharma-continuum/zinit-annex-bin-gem-node \
    zdharma-continuum/zinit-annex-patch-dl \
    zdharma-continuum/zinit-annex-rust

### End of Zinit's installer chunk
