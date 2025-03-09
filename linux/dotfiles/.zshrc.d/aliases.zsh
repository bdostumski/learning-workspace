# Aliases

# neovim  
alias vi='nvim'
alias vim="nvim"

# emacs 
alias emacs="emacsclient -c -a 'emacs'"
alias emacs-cli="emacsclient -c -a 'emacs -nw'" 
alias emacs-kill="killall emacs || echo 'Emacs server not running'; /usr/bin/emacs --daemon"

# external applications
alias zsh-source='source ~/.zshrc' # source zsh
alias zsh-theme='p10k configure' # configure p10k theme

# navigation commands
alias mkdir='mkdir -p' # create parent directories
alias z="z -c" # z with auto cd jump to directory
alias c.='cd ..' # go back one directory
alias c..='cd ../..' # go back two directories
alias c...='cd ../../..' # go back three directories

# ls commands
alias ls='eza -al --color=auto --icons --color=auto --group-directories-first' 
alias ll='eza -l --color=auto --icons --color=auto --group-directories-first'
alias lt='eza -aT --color=auto --icons --color=auto --group-directories-first'
alias la='eza -a --color=auto --icons --color=auto --group-directories-first'
alias l.='eza -a --color=auto --icons --color=auto --group-directories-first ../'
alias l..='eza -a --color=auto --icons --color=auto --group-directories-first ../../'
alias l...='eza -a --color=auto --icons --color=auto --group-directories-first ../../../'

# find text commands
alias find-text='rg -u -i ' # find text in files

# find files and directories
alias find-file='find_file ' # find file and open it with nvim
alias find-dir='find_dir ' # find directory and open it with nvim

# trash commands
alias trash='trash' # move to trash
alias trash-empty='trash-empty' # empty trash
alias trash-list='trash-list' # list trash
alias trash-restore='trash-restore' # restore from trash
alias trash-rm='trash-rm' # remove from trash
alias trash-put='trash-put' # put in trash

# read files commands
alias cat='bat' # cat with syntax highlightig
alias less='less -R' # less with colors
alias more='less -R' # less is more
alias grep='rg --color=auto' # ripgrep with colors
alias replace='fd -e txt -x sed -i' # replace text in files

# systemctl
alias sys-start='sudo systemctl start' # start a service imediatly
alias sys-stop='sudo systemctl stop' # stop a running service
alias sys-restart='sudo systemctl restart' # restart service (stop and start)
alias sys-enable='sudo systemctl enable' # enable service to start at boot time
alias sys-disable='sudo systemctl disable' # disable service to start at boot time
alias sys-status='systemctl status' # current status of a service

# system and hardware commands
alias htop='btop' # top with delay
alias glances='glances' # system monitor
alias sysinfo='neofetch' # system information
alias du='ncdu --color dark' # disk usage with colors
alias df='pydf -h' # disk free
alias grub-install='sudo grub-install --target=x86_64-efi --efi-directory=/boot/efi --bootloader-id=GRUB' # install grub
alias grub-update='sudo grub-mkconfig -o /boot/grub/grub.cfg' # update grub

# error messages
alias journal='journalctl -xe' # show journalctl with errors
alias journalf='journalctl -f' # follow journalctl
alias journalctl='journalctl -p 3 -xb' # show journalctl with errors
alias kernel-errors='sudo dmesg -wT --level=err,crit,alert,warn' # show kernel errors

# sudo
alias shutdown='sudo shutdown -h now' # shutdown
alias reboot='sudo reboot' # reboot
alias sleep='sudo systemctl suspend' # sleep

# pacman
alias install='sudo pacman -S' # install package
alias remove='sudo pacman -R' # remove package
alias search='pacman -Ss' # search package
alias update='sudo pacman -Syu' # update system
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

# web commands 
alias httpie='http --print=HhBb' # httpie with headers and body
alias ping='ping -c 5' # ping 5 times
alias network-speed='speedtest-cli' # speedtest-cli

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

# kitty terminal
alias kitty-theme='kitty +kitten themes' # change kitty theme
alias kitty-fonts='kitty +kitten fonts' # change kitty fonts
alias compare='kitty +kitten diff' # view file diff in terminal
alias image='kitty +kitten icat' # view image in terminal
alias unicode='kitty +kitten unicode' # view unicode characters in terminal

# Kitty remote file operations
# Edit, Open or Download files from local computer into remote computer
alias kitty-remote-file='kitty +kitten remote-file' # edit/open/download remote file in terminal
# kitty terminal - ssh download/upload files and directories (recursively)
alias kitty-ssh='kitty +kitten ssh' # ssh in terminal
# kitty sync download/upload all files and directories (recursively).
alias ssh-download='kitty +kitten transfer' # download file: ./remote-file to /path/on/local/computer/
alias ssh-upload='kitty +kitten transfer --direction=upload' # upload file: /path/on/local/computer ./remote-file
# kitty uses rsync protocol to download/upload only changes between files.
alias ssh-rsync-download='kitty +kitten transfer' # rsync download file: ./remote-file to /path/on/local/computer/
alias ssh-rsync-upload='kitty +kitten transfer --direction=upload' # rsync upload file: /path/on/local/computer ./remote-file

# git aliases
alias diff='git diff --color-words'
alias difftool='git difftool -y'
alias mergetool='git mergetool -y'
alias g='git' # g for git it is good combination with .gitconfig aliases
alias log='git log --oneline --graph --decorate | bat --paging=always --language=gitlog'
alias logall='git log --graph --decorate | bat --paging=always --language=gitlog'
alias logfull='git log --graph --decorate --full-history | bat --paging=always --language=gitlog'
alias logauthor='function_logauthor() { git log --graph --decorate --full-history --author="$1" | bat --paging=always --language=gitlog }; function_logauthor'
#
# github cli aliases
alias git-cli='lazygit'
alias gh='gh --color=always'
alias copilot='gh copilot'
alias pull-list='gh pr list'
alias pull-view='gh pr view'
alias issue='gh issue create -f'
alias issue-view='gh issue view'
alias issue-comment='gh issue comment'
alias issue-list='gh issue list'
alias issue-search='gh issue list --search'
alias issue-assign='gh issue assign'
alias issue-close='gh issue close'

# change shell
alias tobash="sudo chsh $USER -s /bin/bash && echo 'Log out and log in again'"
alias tozsh="sudo chsh $USER -s /bin/zsh && echo 'Log out and log in again'"
