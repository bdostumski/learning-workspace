#
# Zsh Config
# Description: This file is the main configuration file for zsh. It loads all
#

# -----------------
# Shell Configuration
# -----------------
# If not running shell interactively, don't do anyting
[[ $- != *i* ]] && return
# ---------- 

# -----------------
# Create Direcotries 
# &
# Copy Config Files
# -----------------
LOGS="$HOME/.logs.d"
# Create .logs.d to store application messages
if [[ ! -d "$LOGS" ]]; then
	mkdir -p "$LOGS"
fi

# -----------------
# Setup history file
# -----------------
# Create history file if it does not exist
if [ ! -f "$LOGS/.zsh_history" ]; then
	touch "$LOGS/.zsh_history"
fi

# -----------------
# Zinit Configuration
# -----------------
# Home Directory
export SHELLDIR="$HOME/.zshrc.d"
ZINIT_HOME="$HOME/.config/zinit/.zinit.git"
# ---------- 
# Download Zinit, if not already installed
if [[ ! -d "$ZINIT_HOME" ]]; then
	mkdir -p "$(dirname $ZINIT_HOME)"
	git clone https://github.com/zdharma-continuum/zinit.git "$ZINIT_HOME"
fi
# ---------- 
# Plugin Manager
source "${ZINIT_HOME}/zinit.zsh"

# -----------------
# Shell Configuration Files
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

# -----------------
# Zinit Configuration
# -----------------
# Load a few important annexes, without Turbo
# (this is currently required for annexes)
zinit light-mode for \
    zdharma-continuum/zinit-annex-as-monitor \
    zdharma-continuum/zinit-annex-bin-gem-node \
    zdharma-continuum/zinit-annex-patch-dl \
    zdharma-continuum/zinit-annex-rust

### End of Zinit's installer chunk
