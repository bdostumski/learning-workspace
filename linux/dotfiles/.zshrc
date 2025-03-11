#
# ZSH CONFIGURATION
# Description: This file is the main configuration file for zsh. It loads all
#

# -----------------
# ZSH SHELL CONFIGURATION
# -----------------
# If not running shell interactively, don't do anyting
[[ $- != *i* ]] && return

# -----------------
# INITIALIZE SHELL
# -----------------
# Shell Home Directory
export SHELLDIR="$HOME/.zshrc.d"
# ---------- 
# load shell initialization
[ -f "$SHELLDIR/initialize.sh" ] && source "$SHELLDIR/initialize.sh"

# -----------------
# SHELL CONFIGURATION FILES
# -----------------
# load common enviroment variables
[ -f "$SHELLDIR/environment.sh" ] && source "$SHELLDIR/environment.sh"
# ---------- 
# load aliases
[ -f "$SHELLDIR/aliases.sh" ] && source "$SHELLDIR/aliases.sh"
# ---------- 
# load template files
[ -f "$SHELLDIR/templates.sh" ] && source "$SHELLDIR/templates.sh"
# ---------- 
# load functions 
[ -f "$SHELLDIR/functions.sh" ] && source "$SHELLDIR/functions.sh"
# ---------- 
# load history settings
[ -f "$SHELLDIR/history.sh" ] && source "$SHELLDIR/history.sh"
# ---------- 
# load key bindings
[ -f "$SHELLDIR/key-bindings.sh" ] && source "$SHELLDIR/key-bindings.sh"
# ---------- 
# load plugins
[ -f "$SHELLDIR/plugins.sh" ] && source "$SHELLDIR/plugins.sh"
# ---------- 
# custom profile settings
[ -f "$SHELLDIR/profile.sh" ] && source "$SHELLDIR/profile.sh"
# ---------- 
# load local machine-specific configuration (optional)
# this file is for settings that should not be shared between machines
[ -f "$SHELLDIR/local.sh" ] && source "$SHELLDIR/local.sh"
