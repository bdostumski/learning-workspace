#!/bin/zsh
#

# -----------------
# INSTALL Doom Emacs
# -----------------
if [ ! -d "$HOME/.config/emacs" ]; then
    git clone --depth 1 https://github.com/doomemacs/doomemacs ~/.config/emacs
    ~/.config/emacs/bin/doom install
    ~/.config/emacs/bin/doom profile sync --all
    ~/.config/emacs/bin/doom sync --rebuild

    # Create the systemd service file for Emacs
    mkdir -p ~/.config/systemd/user
    cat <<EOF >~/.config/systemd/user/emacs.service
[Unit]
Description=Emacs text editor
Documentation=info:emacs man:emacs(1) https://gnu.org/software/emacs/

[Service]
Type=forking
ExecStart=/usr/bin/emacs --daemon
ExecStop=/usr/bin/emacsclient --eval "(kill-emacs)"
Environment=SSH_AUTH_SOCK=%t/keyring/ssh
Restart=on-failure

[Install]
WantedBy=default.target
EOF

    cat <<EOF >~/.mbsyncrc
IMAPAccount gmail
Host imap.gmail.com
User your@gmail.com
PassCmd "gpg -q --for-your-eyes-only --no-tty -d ~/.authinfo.gpg"
SSLType IMAPS

IMAPStore gmail-remote
Account gmail

MaildirStore gmail-local
Path ~/.mail/gmail/
Inbox ~/.mail/gmail/INBOX

Channel gmail
Master :gmail-remote:
Slave :gmail-local:
Patterns *
Create Both
Sync All
Expunge Both
EOF

    mv ~/.emacs.d ~/.emacs.d-bak
    systemctl --user enable --now emacs.service
    systemctl --user restart emacs.service
    systemctl --user status emacs.service
    systemctl --user stop emacs.service

fi

# Lib to fix emacs
if [ ! -f "/usr/lib/libtree-sitter.so" ]; then
    sudo ln -s /usr/lib/libtree-sitter.so /usr/lib/libtree-sitter.so.0.24
fi
