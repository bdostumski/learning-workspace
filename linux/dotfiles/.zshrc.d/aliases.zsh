# Aliases

# neovim and emacs 
alias vim="nvim"
alias emacs="emacsclient -c -a 'emacs'"
alias emacs-cli="/usr/bin/emacs -nw" 
alias emacs-kill="killall emacs || echo 'Emacs server not running'; /usr/bin/emacs --daemon"

# ls
# --color=always for ls colors in scripts
# --icon for icons
alias ls='eza -al --color=auto --icons --color=auto --group-directories-first' 
alias la='eza -a --color=auto --icons --color=auto --group-directories-first'
alias ll='eza -l --color=auto --icons --color=auto --group-directories-first'
alias lt='eza -aT --color=auto --icons --color=auto --group-directories-first'
alias l.='eza -a --color=auto --icons --color=auto --group-directories-first ../'
alias l..='eza -a --color=auto --icons --color=auto --group-directories-first ../../'
alias l...='eza -a --color=auto --icons --color=auto --group-directories-first ../../../'

# pacman
alias pacsyu='sudo pacman -Syu'
alias pacsyyu='sudo pacman -Syyu'

# mirrors
alias mirror='sudo reflector -f 30 -l 30 --number 10 --verbose --save /etc/pacman.d/mirrorlist'
alias mirrord='sudo reflector --latest 50 --number 20 --sort delay --save /etc/pacman.d/mirrorlist'
alias mirrors='sudo reflector --latest 50 --number 20 --sort score --save /etc/pacman.d/mirrorlist'
alias mirrora='sudo reflector --latest 50 --number 20 --sort age --save /etc/pacman.d/mirrorlist'

# flags 
alias df='df -h'
alias free='free -m'
alias grep='grep --color=auto'

# ps
alias psa='ps auxf'
alias psgrep='ps aux | grep -v grep | grep -i -e VSZ -e'
alias psmem='ps auxf | sort -nr -k 4'
alias pscpu='ps auxf | sort -nr -k 3'

# git
alias add='git add'
alias addall='git add .'
alias branch='git branch'
alias checkout='git checkout'
alias clone='git clone'
alias commit='git commit -m'
alias fetch='git fetch'
alias pull='git pull origin'
alias push='git push origin'
alias status='git status'
alias tag='git tag'
alias newtag='git tag -a'

# error messages
alias jctl='journalctl -p 3 -xb'

# gpg encription
# verify signature for isos
alias gpg-check='gpg2 --keyserver-options auto-key-retrive --verify'
# receive the key of a developer
alias gpg-retrive='gpg2 --keyserver-options auto-key-retrive --receive-keys'

# change shell
alias tobash="sudo chsh $USER -s /bin/bash && echo 'Log out and log in again'"
alias tozsh="sudo chsh $USER -s /bin/zsh && echo 'Log out and log in again'"



