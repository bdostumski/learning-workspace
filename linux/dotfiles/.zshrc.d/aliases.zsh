# Aliases

# neovim and emacs 
alias vi='nvim'
alias vim="nvim"
alias emacs="emacsclient -c -a 'emacs'"
alias emacs-cli="emacsclient -c -a 'emacs -nw'" 
alias emacs-kill="killall emacs || echo 'Emacs server not running'; /usr/bin/emacs --daemon"

# common commands
alias zsh-source='source ~/.zshrc' # source zsh
alias tmux-source='tmux source ~/.zshrc.d/config.d/tmux/.tmux.conf' # source tmux
alias zsh-theme='p10k configure' # configure p10k theme
alias cat='bat' # cat with syntax highlighting
alias btop='btop -d 5' # top with delay
alias htop='htop -d 5' # htop with delay
alias less='less -R' # less with colors
alias more='less' # less is more
alias mkdir='mkdir -p' # create parent directories
alias du='du -h' # disk usage
alias ncdu='ncdu --color dark' # disk usage with colors
alias httpie='http --print=HhBb' # httpie with headers and body
alias df='df -h' # disk free
alias ping='ping -c 5' # ping 5 times
alias free='free -m' # show memory in MB
alias grep='grep --color=auto' # grep with colors
alias find-file='find . -type f -name ' # find file
alias find-dir='find . -type d -name ' # find directory
alias find-text='grep -r ' # find text in files
alias cd.='cd ..' # go back one directory
alias cd..='cd ../..' # go back two directories
alias cd...='cd ../../..' # go back three directories
alias trash='trash' # move to trash
alias trash-empty='trash-empty' # empty trash
alias trash-list='trash-list' # list trash
alias trash-restore='trash-restore' # restore from trash
alias trash-rm='trash-rm' # remove from trash
alias trash-put='trash-put' # put in trash
alias z="z -c" # z with auto cd jump to directory

# ls commands
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

# ps
alias psa='ps auxf'
alias psgrep='ps aux | grep -v grep | grep -i -e VSZ -e'
alias psmem='ps auxf | sort -nr -k 4'
alias pscpu='ps auxf | sort -nr -k 3'

# git aliases
alias status='git status'
alias commit='git commit -m'
alias fixup='git commit --fixup'
alias squash='git commit --squash'
alias amend='git commit --amend --no-edit'
alias checkout='git checkout'
alias branch='git branch -vv'
alias diff='git diff --color-words'
alias difftool='git difftool -y'
alias mergetool='git mergetool -y'
alias add='git add'
alias addall='git add -A .'
alias colone='git clone --recurse-submodules'
alias fetch='git fetch origin'
alias pull='git pull origin'
alias push='git push origin'
alias rebase='git rebase'
alias reset='git reset'
alias reset-hard='git reset --hard'
alias uncommit='git reset --soft HEAD~1'
alias unstage='git reset HEAD --'
alias stash='git stash -m'
alias apply='git stash apply'
alias list='git stash list'
alias pop='git stash pop'
alias log='git log --oneline --graph --decorate | bat --paging=always --language=gitlog'
alias logall='git log --graph --decorate | bat --paging=always --language=gitlog'
alias logfull='git log --graph --decorate --full-history | bat --paging=always --language=gitlog'
alias logauthor='function_logauthor() { git log --graph --decorate --full-history --author="$1" | bat --paging=always --language=gitlog }; function_logauthor'
#
# github cli aliases
alias git-cli='lazygit'
alias gitignore="cat '$HOME/.zshrc.d/templates.d/.gitignore' >> .gitignore"
alias gh='gh --color=always'
alias copilot='gh copilot'
alias pull='gh pr create -f'
alias pull-list='gh pr list'
alias pull-view='gh pr view'
alias issue='gh issue create -f'
alias issue-view='gh issue view'
alias issue-comment='gh issue comment'
alias issue-list='gh issue list'
alias issue-search='gh issue list --search'
alias issue-assign='gh issue assign'
alias issue-close='gh issue close'

# error messages
alias journal='journalctl -xe' # show journalctl with errors
alias syslog='grep -i "error" /var/log/syslog' # show syslog with errors
alias errormsg='grep -i "error" /var/log/messages' # show messages with errors
alias dmesg='grep -i "error" /var/log/dmesg' # show dmesg with errors
alias journalf='journalctl -f' # follow journalctl
alias journalc='journalctl --disk-usage' # show disk usage of journalctl
alias journalctl='journalctl -p 3 -xb' # show journalctl with errors

# gpg encription/decription
alias gpg-check='gpg2 --keyserver-options auto-key-retrive --verify' # verify signature for isos
alias gpg-retrive='gpg2 --keyserver-options auto-key-retrive --receive-keys' # receive the key of a developer
alias gpg-encrypt='gpg2 --encrypt' # encrypt a file
alias gpg-decrypt='gpg2 --decrypt' # decrypt a file
alias gpg-sign='gpg2 --sign' # sign a file
alias gpg-verify='gpg2 --verify' # verify a signature
alias gpg-list='gpg2 --list-keys' # list keys
alias gpg-list-secret='gpg2 --list-secret-keys' # list secret keys
alias gpg-export='gpg2 --export' # export a key
alias gpg-import='gpg2 --import' # import a key
alias gpg-delete='gpg2 --delete-key' # delete a key

# ssh encription
alias ssh-keygen='ssh-keygen -t ed25519 -C' # generate ssh key
alias ssh-copy='ssh-copy-id' # copy ssh key
alias ssh-add='ssh-add -K' # add ssh key
alias ssh-agent='eval $(ssh-agent -s)' # start ssh agent
alias ssh-kill='killall ssh-agent' # kill ssh agent

# change shell
alias tobash="sudo chsh $USER -s /bin/bash && echo 'Log out and log in again'"
alias tozsh="sudo chsh $USER -s /bin/zsh && echo 'Log out and log in again'"



