# Zsh Config

# if not running shell interactively, don't do anyting
[[ $- != *i* ]] && return

# set ZDOTDIR
export ZDOTDIR="$HOME"

# set the directory we want to store zinit and plugins
ZINIT_HOME="$ZDOTDIR/.config/zinit/.zinit.git"
# download zinit, if not already installed
if [[ ! -d "$ZINIT_HOME" ]]; then
	mkdir -p "$(dirname $ZINIT_HOME)"
	git clone https://github.com/zdharma-continuum/zinit.git "$ZINIT_HOME"
fi
# load zinit plugin manager
source "${ZINIT_HOME}/zinit.zsh"

# set tmux as the default terminal multiplexer
TMUX_HOME="$HOME/.config/tmux/plugins/tpm/tmp"
# download tmux plugin manager, if not already installed
if [[ ! -d "$TMUX_HOME" ]]; then
	mkdir -p "$(dirname $TMUX_HOME)"
	git clone https://github.com/tmux-plugins/tpm "$TMUX_HOME"
fi

# Start tmux automatically if it's not already running
if command -v tmux &> /dev/null && ! tmux has-session -t main 2>/dev/null; then
  tmux new-session -d -s main
  tmux attach -t main
fi


# create logs directory for application history and log files
if [[ ! -d "$HOME/.logs.d" ]]; then
	mkdir -p "$HOME/.logs.d"
	touch "$HOME/.logs.d/.zsh_history"
fi

# load enviroment variables
[ -f "$ZDOTDIR/.zshrc.d/environment.zsh" ] && source "$ZDOTDIR/.zshrc.d/environment.zsh"

# load aliases
[ -f "$ZDOTDIR/.zshrc.d/aliases.zsh" ] && source "$ZDOTDIR/.zshrc.d/aliases.zsh"

# load template files
[ -f "$ZDOTDIR/.zshrc.d/templates.zsh" ] && source "$ZDOTDIR/.zshrc.d/templates.zsh"

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

# Load a few important annexes, without Turbo
# (this is currently required for annexes)
zinit light-mode for \
    zdharma-continuum/zinit-annex-as-monitor \
    zdharma-continuum/zinit-annex-bin-gem-node \
    zdharma-continuum/zinit-annex-patch-dl \
    zdharma-continuum/zinit-annex-rust

### End of Zinit's installer chunk
