# Find files and open selected in nvim
find_file() {
  fd -g -H -t f "$1" | \
  fzf --preview "exa -al {}" \
      --bind "enter:execute(nvim {})"
}

