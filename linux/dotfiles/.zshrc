# Zsh Config

# if not running shell interactively, don't do anyting
[[ $- != *i* ]] && return

# set ZDOTDIR
export ZDOTDIR="$HOME"

# load enviroment variables
[ -f "$ZDOTDIR/.zshrc.d/environment.zsh" ] && source "$ZDOTDIR/.zshrc.d/environment.zsh"

# load aliases
[ -f "$ZDOTDIR/.zshrc.d/aliases.zsh" ] && source "$ZDOTDIR/.zshrc.d/aliases.zsh"

# load functions 
[ -f "$ZDOTDIR/.zshrc.d/functions.zsh" ] && source "$ZDOTDIR/.zshrc.d/functions.zsh"

# load history settings
[ -f "$ZDOTDIR/.zshrc.d/history.zsh" ] && source "$ZDOTDIR/.zshrc.d/history.zsh"

# load completions
[ -f "$ZDOTDIR/.zshrc.d/completions.zsh" ] && source "$ZDOTDIR/.zshrc.d/completions.zsh"

# load plugins
[ -f "$ZDOTDIR/.zshrc.d/plugins.zsh" ] && source "$ZDOTDIR/.zshrc.d/plugins.zsh"

# custom profile settings
[ -f "$ZDOTDIR/.zshrc.d/profile.zsh" ] && source "$ZDOTDIR/.zshrc.d/profile.zsh"

# load local machine-specific configuration (optional)
# this file is for settings that should not be shared between machines
[ -f "$ZDOTDIR/.zshrc.d/local.zsh" ] && source "$ZDOTDIR/.zshrc.d/local.zsh"
