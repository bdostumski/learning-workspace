#
# ALIASES
# Description: Aliases are short commands that can be used to replace long commands.
#

# -----------------
# MAIN EDITORS
# -----------------
# neovim
alias v='vim'
alias vi='nvim'
alias vim="nvim"
# ----------
# emacs
alias emacs="emacsclient -c -a 'emacs'"
alias emacs.="emacsclient -c -a 'emacs -nw'"
alias emacs-kill="killall emacs || echo 'Emacs server not running'; /usr/bin/emacs --daemon"

# -----------------
# SHELL COMMANDS
# -----------------
# external applications
alias help='tldr'                      # help with examples
alias zsh-source='source $HOME/.zshrc' # source zsh
alias zsh-theme='p10k configure'       # configure p10k theme
# ----------
# TUI applications
alias pdf='zathura' # pdf preview
alias md='mdfried'  # markdown preview
alias video='mpv'   # video player

# -----------------
# WEB COMMANDS
# -----------------
# web
alias httpie='http --print=HhBb'    # httpie with headers and body
alias ping='ping -c 5'              # ping 5 times
alias network-speed='speedtest-cli' # speedtest-cli

# -----------------
# FILE NAVIGATION COMMANDS
# -----------------
# navigation
alias mkdir='mkdir -p'   # create parent directories
alias rmi='rm -rfi'      # remove with confirmation, files and directories
alias up='cd_up '        # go up {level_number} directory: up 5
alias z="z -c"           # z with auto cd jump to directory
alias c.='cd ..'         # go back one directory
alias c..='cd ../..'     # go back two directories
alias c...='cd ../../..' # go back three directories
# ----------
# ls commands
alias ls='lsd -al --color=auto --group-directories-first'
alias ll='lsd -l --color=auto --group-directories-first'
alias lt='lsd -a --tree --color=auto --group-directories-first'
alias la='lsd -a --color=auto --group-directories-first'
alias l.='lsd -a --color=auto --group-directories-first ../'
alias l..='lsd -a --color=auto --group-directories-first ../../'
alias l...='lsd -a --color=auto --group-directories-first ../../../'
# # # # # # # # # #

# -----------------
# FILE OPERATIONS
# -----------------
# find text commands
alias find-text='rg -u -i ' # find text in files
# ----------
# find files and directories
alias find-file='find_file ' # find file and open it with nvim
alias find-dir='find_dir '   # find directory and open it with nvim
# ----------
# trash commands
alias trash='trash'                 # move to trash
alias trash-empty='trash-empty'     # empty trash
alias trash-list='trash-list'       # list trash
alias trash-restore='trash-restore' # restore from trash
alias trash-rm='trash-rm'           # remove from trash
alias trash-put='trash-put'         # put in trash
# ----------
# read files commands
alias cat='bat'              # cat with syntax highlightig
alias less='less -R'         # less with colors
alias more='less -R'         # less is more
alias grep='rg --color=auto' # ripgrep with colors

# -----------------
# KITTY TERMINAL
# -----------------
# kitty common commands
alias kitty-theme='kitty +kitten themes' # change kitty theme
alias kitty-fonts='kitty +kitten fonts'  # change kitty fonts
alias compare='kitty +kitten diff'       # view file diff in terminal
alias image='kitty +kitten icat'         # view image in terminal
alias unicode='kitty +kitten unicode'    # view unicode characters in terminal
# ----------
# Kitty remote file operations
# Edit, Open or Download files from local computer into remote computer
alias kitty-remote-file='kitty +kitten remote-file' # edit/open/download remote file in terminal
# kitty terminal - ssh download/upload files and directories (recursively)
alias kitty-ssh='kitty +kitten ssh' # ssh in terminal
# kitty sync download/upload all files and directories (recursively).
alias ssh-download='kitty +kitten transfer'                  # download file: ./remote-file to /path/on/local/computer/
alias ssh-upload='kitty +kitten transfer --direction=upload' # upload file: /path/on/local/computer ./remote-file
# kitty uses rsync protocol to download/upload only changes between files.
alias ssh-rsync-download='kitty +kitten transfer'                  # rsync download file: ./remote-file to /path/on/local/computer/
alias ssh-rsync-upload='kitty +kitten transfer --direction=upload' # rsync upload file: /path/on/local/computer ./remote-file

# -----------------
# GIT AND GITHUB
# -----------------
# git aliases
alias gitinfo='onefetch' # git information
alias git.='lazygit'     # git terminal ui
alias diff='git diff --color-words'
alias difftool='git difftool -y'
alias mergetool='git mergetool -y'
alias g='git' # g for git it is good combination with .gitconfig aliases
alias log='git log --oneline --graph --decorate | bat --paging=always --language=gitlog'
alias logall='git log --graph --decorate | bat --paging=always --language=gitlog'
alias logfull='git log --graph --decorate --full-history | bat --paging=always --language=gitlog'
alias logauthor='function_logauthor() { git log --graph --decorate --full-history --author="$1" | bat --paging=always --language=gitlog }; function_logauthor'
# ----------
# github cli aliases
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

# -----------------
# ENCRYPTION / DECRIPTION
# -----------------
# ssh encription
alias ssh-keygen='ssh-keygen -t ed25519 -C' # generate ssh key
alias ssh-copy='ssh-copy-id'                # copy ssh key
alias ssh-add='ssh-add -K'                  # add ssh key
alias ssh-agent='eval $(ssh-agent -s)'      # start ssh agent
alias ssh-kill='killall ssh-agent'          # kill ssh agent
# ----------
# gpg encription/decription
alias gpg-check='gpg2 --keyserver-options auto-key-retrive --verify'         # verify signature for isos
alias gpg-retrive='gpg2 --keyserver-options auto-key-retrive --receive-keys' # receive the key of a developer
alias gpg-encrypt='gpg2 --encrypt'                                           # encrypt a file
alias gpg-decrypt='gpg2 --decrypt'                                           # decrypt a file
alias gpg-sign='gpg2 --sign'                                                 # sign a file
alias gpg-verify='gpg2 --verify'                                             # verify a signature
alias gpg-list='gpg2 --list-keys'                                            # list keys
alias gpg-list-secret='gpg2 --list-secret-keys'                              # list secret keys
alias gpg-export='gpg2 --export'                                             # export a key
alias gpg-import='gpg2 --import'                                             # import a key
alias gpg-delete='gpg2 --delete-key'                                         # delete a key

# -----------------
# SYSTEM
# -----------------
# sudo commands
alias shutdown='sudo shutdown -h now' # shutdown
alias reboot='sudo reboot'            # reboot
alias sleep='sudo systemctl suspend'  # sleep
# ----------
# systemctl
alias sys-start='sudo systemctl start'     # start a service imediatly
alias sys-stop='sudo systemctl stop'       # stop a running service
alias sys-restart='sudo systemctl restart' # restart service (stop and start)
alias sys-enable='sudo systemctl enable'   # enable service to start at boot time
alias sys-disable='sudo systemctl disable' # disable service to start at boot time
alias sys-status='systemctl status'        # current status of a service
# ----------
# pacman
alias install='sudo pacman -S'                      # install package
alias remove='sudo pacman -R'                       # remove package
alias search='pacman -Ss'                           # search package
alias update='sudo pacman -Syu'                     # update system
alias clean='sudo pacman -Sc'                       # clean cache
alias autoremove='sudo pacman -Rns $(pacman -Qtdq)' # remove orphaned packages
# ----------
# pacman mirrors optimization
alias mirror='sudo reflector -f 30 -l 30 --number 10 --verbose --save /etc/pacman.d/mirrorlist'
alias mirrord='sudo reflector --latest 50 --number 20 --sort delay --save /etc/pacman.d/mirrorlist'
alias mirrors='sudo reflector --latest 50 --number 20 --sort score --save /etc/pacman.d/mirrorlist'
alias mirrora='sudo reflector --latest 50 --number 20 --sort age --save /etc/pacman.d/mirrorlist'
# ----------
# system and hardware commands
alias top='btop'                                                                                          # system monitor { htop|btop|gotop }
alias sysremote='glances'                                                                                 # system monitor can expose information about the system usage by using HTTP API
alias sysinfo='neofetch'                                                                                  # system information
alias cpu='lscpu'                                                                                         # cpu information
alias du='ncdu --color dark'                                                                              # disk usage with colors
alias df='pydf -h'                                                                                        # disk free
alias grub-install='sudo grub-install --target=x86_64-efi --efi-directory=/boot/efi --bootloader-id=GRUB' # install grub
alias grub-update='sudo grub-mkconfig -o /boot/grub/grub.cfg'                                             # update grub
# ----------
# ps
alias psa='ps auxf'
alias psgrep='ps aux | grep -v grep | grep -i -e VSZ -e'
alias psmem='ps auxf | sort -nr -k 4'
alias pscpu='ps auxf | sort -nr -k 3'
# ----------
# error messages
alias journal='journalctl -xe'                                   # show journalctl with errors
alias journalf='journalctl -f'                                   # follow journalctl
alias journalctl='journalctl -p 3 -xb'                           # show journalctl with errors
alias kernel-errors='sudo dmesg -wT --level=err,crit,alert,warn' # show kernel errors
# ----------
# change shell
alias tobash="sudo chsh $USER -s /bin/bash && echo 'Log out and log in again'"
alias tozsh="sudo chsh $USER -s /bin/zsh && echo 'Log out and log in again'"
