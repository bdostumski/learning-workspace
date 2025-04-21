#!/usr/bin/env zsh

export   backup_and_copy() {
        local src="$1"
        local dest="$2"
        local is_root="${3:-false}"

        if [[ $is_root == "true" ]]; then
            [[ -e "$dest" && ! -e "${dest}.bak" ]] && sudo mv "$dest" "${dest}.bak"
            sudo cp -r "$src" "$dest"
        else
            [[ -e "$dest" && ! -e "${dest}.bak" ]] && mv "$dest" "${dest}.bak"
            cp -r "$src" "$dest"
        fi
    }

#    backup_and_copy ~/.zshrc.d/config.d/kitty ~/.config/kitty
#    backup_and_copy ~/.zshrc.d/config.d/ranger ~/.config/ranger
#    backup_and_copy ~/.zshrc.d/config.d/doom ~/.config/doom
#    backup_and_copy ~/.zshrc.d/config.d/lvim ~/.config/lvim
#    backup_and_copy ~/.zshrc.d/config.d/tmux ~/.config/tmux
#
#    backup_and_copy ~/.zshrc.d/config.d/clamav /etc/clamav true
#    backup_and_copy ~/.zshrc.d/config.d/cron/cron.daily /etc/cron.daily true
#    backup_and_copy ~/.zshrc.d/config.d//cron/cron.weekly /etc/cron.weekly true
#    backup_and_copy ~/.zshrc.d/config.d/ufw/before.rules /etc/ufw/before.rules true
