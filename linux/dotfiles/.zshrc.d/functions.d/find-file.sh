#
# FIND FILES AND OPEN SELECTED IN NVIM
# Description: This function uses fd to find files and open select one
# Usage: find-file <file name>
#

find_file() {
  fd -g -H -t f "$1" | \
  fzf --preview "exa -al {}" \
      --bind "enter:execute(nvim {})"
}

