# Functions

# archive extration
# usage: extract <file>
source "$(dirname "$0")/functions.d/archive-extraction.zsh"

# navigation
# example: cd-up 3
# this will navigate up 3 directories
source "$(dirname "$0")/functions.d/change-dir-up.zsh"

# find directory and open selected in nvim
source "$(dirname "$0")/functions.d/find-dir.zsh"

# find file and open selected in nvim
source "$(dirname "$0")/functions.d/find-file.zsh"

