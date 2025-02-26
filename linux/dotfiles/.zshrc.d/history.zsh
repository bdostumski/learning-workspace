# History

HISTFILE=~/.zsh_history
if [ ! -f "$HISTFILE" ]; then
	touch "$HISTFILE"
fi

HISTSIZE=50000
SAVEHIST=50000

setopt append_history # Append history insted of overwriting
setopt inc_append_history # Write commands to history imediately
setopt hist_ignore_dups # Ignore duplicate commands
setopt hist_ignore_space # Ignore commands starting with space
setopt hist_verify # Show command before execution
setopt share_history # Share history across sessions
