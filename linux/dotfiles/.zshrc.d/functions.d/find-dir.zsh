# Find directories and open selected in nvim
find_dir() {
  fd -g -H -t d "$1" | \
  fzf --preview "exa -al {}" \
      --bind "enter:execute(nvim {})"
}
