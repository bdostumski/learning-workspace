# Prompt & Keybindings

# enabve vi mode for command-line editing
bindkey -v

# custom zsh propmt with git
autoload -Uz promptinit && promptinit

# set the prompt
PROMPT='%F{cyan}%n@%m%f:%F{yellow}%~%f %# '

# terminal title
case ${TERM} in
	xterm*|rxvt*|Eterm*|aterm|kterm|gnome*alacritty|st|konsole*|kitty*)
		PROMPT_COMMAND='echo -ne "\033]0;${USER}@${HOSTNAME%%.*}:${PWD/#$HOME/\~}\007"'
		;;
	screen*)
		PROMPT_COMMAND='echo -ne "\033_${USER}@${HOSTNAME%%.*}:${PWD/#$HOME/\~}\033\\"'
		;;
esac

