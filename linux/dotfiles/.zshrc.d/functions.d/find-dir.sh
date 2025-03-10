#
# Find directories and open selected in nvim
# Description: This script uses fd to find directories and open the selected
# Usage: find-dir <search dir>
#


find_dir() {
  fd -g -H -t d "$1" | \
  fzf --preview "exa -al {}" \
      --bind "enter:execute(nvim {})"
}
