# Aliases

# neovim and emacs 
alias vi='nvim'
alias vim="nvim"
alias emacs="emacsclient -c -a 'emacs'"
alias emacs-cli="/usr/bin/emacs -nw" 
alias emacs-kill="killall emacs || echo 'Emacs server not running'; /usr/bin/emacs --daemon"

# common commands
alias cat='bat' # cat with syntax highlighting
alias btop='btop -d 5' # top with delay
alias htop='htop -d 5' # htop with delay
alias less='less -R' # less with colors
alias more='less' # less is more
alias mkdir='mkdir -p' # create parent directories
alias diff='diff --color=auto' # diff with colors
alias du='du -h' # disk usage
alias df='df -h' # disk free
alias ping='ping -c 5' # ping 5 times
alias free='free -m' # show memory in MB
alias grep='grep --color=auto' # grep with colors

# ls commands
# --color=always for ls colors in scripts
# --icon for icons
alias ls='eza -al --color=auto --icons --color=auto --group-directories-first' 
alias la='eza -a --color=auto --icons --color=auto --group-directories-first'
alias ll='eza -l --color=auto --icons --color=auto --group-directories-first'
alias lt='eza -aT --color=auto --icons --color=auto --group-directories-first'
alias l.='eza -a --color=auto --icons --color=auto --group-directories-first ../'
alias l..='eza -a --color=auto --icons --color=auto --group-directories-first ../../'
alias l...='eza -a --color=auto --icons --color=auto --group-directories-first ../../../'

# systemctl
alias sys-start='sudo systemctl start' # start service
alias sys-stop='sudo systemctl stop' # stop service
alias sys-restart='sudo systemctl restart' # restart service
alias sys-enable='sudo systemctl enable' # enable service
alias sys-disable='sudo systemctl disable' # disable service
alias sys-status='systemctl status' # status of service

# sudo
alias su-reboot='sudo reboot' # reboot
alias su-poweroff='sudo poweroff' # poweroff
alias su-shutdown='sudo shutdown' # shutdown
alias su-update-grub='sudo update-grub' # update grub

# pacman
alias update='sudo pacman -Syu' # update system
alias upgrade='sudo pacman -Syu' # upgrade system
alias install='sudo pacman -S' # install package
alias remove='sudo pacman -R' # remove package
alias search='pacman -Ss' # search package
alias clean='sudo pacman -Sc' # clean cache
alias autoremove='sudo pacman -Rns $(pacman -Qtdq)' # remove orphaned packages

# mirrors
alias mirror='sudo reflector -f 30 -l 30 --number 10 --verbose --save /etc/pacman.d/mirrorlist'
alias mirrord='sudo reflector --latest 50 --number 20 --sort delay --save /etc/pacman.d/mirrorlist'
alias mirrors='sudo reflector --latest 50 --number 20 --sort score --save /etc/pacman.d/mirrorlist'
alias mirrora='sudo reflector --latest 50 --number 20 --sort age --save /etc/pacman.d/mirrorlist'

# flags 

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
alias journal='journalctl -xe' # show journalctl with errors
alias syslog='grep -i "error" /var/log/syslog' # show syslog with errors
alias errormsg='grep -i "error" /var/log/messages' # show messages with errors
alias dmesg='grep -i "error" /var/log/dmesg' # show dmesg with errors
alias journalf='journalctl -f' # follow journalctl
alias journalc='journalctl --disk-usage' # show disk usage of journalctl
alias journalctl='journalctl -p 3 -xb' # show journalctl with errors

# gpg encription
# verify signature for isos
alias gpg-check='gpg2 --keyserver-options auto-key-retrive --verify'
# receive the key of a developer
alias gpg-retrive='gpg2 --keyserver-options auto-key-retrive --receive-keys'

# change shell
alias tobash="sudo chsh $USER -s /bin/bash && echo 'Log out and log in again'"
alias tozsh="sudo chsh $USER -s /bin/zsh && echo 'Log out and log in again'"



