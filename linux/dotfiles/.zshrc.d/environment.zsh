# Environment

export TERM="xterm-256color" 
export LS_COLORS="di=34:ln=36:so=35:pi=33:ex=32"
export LANG='en_US.UTF-8'
export LC_ALL='en_US.UTF-8'
export EDITOR="emacsclient -t -a ''" 
export VISUAL="emacsclient -c -a emacs" 
export MANPAGER="nvim +Man!"
export HISTORY_IGNORE="(ls|cd|pwd|exit|sudo reboot|history|cd -|cd ..)"


if [ -d "$HOME/.bin" ]; then
	PATH="$HOME/.bin:$PATH"
fi

if [ -d "$HOME/.local/bin" ]; then 
	PATH="$HOME/.local/bin:$PATH"
fi

if [ -d "$HOME/.config/emacs/bin" ]; then
	PATH="$HOME/.config/emacs/bin:$PATH"
fi

if [ -d "$HOME/.emacs.d/bin" ]; then
	PATH="$HOME/.emacs.d/bin:$PATH"
fi

if [ -d "$HOME/Applications" ]; then 
	PATH="$HOME/Applications:$PATH"
fi


export PATH
