#!/usr/bin/env zsh
#
# EDITOR
# Description: Choose editor
# Example: if nvim exists then use nvim, else vim
#

editor_nvim_vim() {
    if command -v nvim >/dev/null 2>&1; then
        exec nvim
    elif command -v vim >/dev/null 2>&1; then
        exec vim
    else
        echo "No suitable editor (lvim, nvim, or vim) found in PATH." >&2
        exit 1
    fi
}
