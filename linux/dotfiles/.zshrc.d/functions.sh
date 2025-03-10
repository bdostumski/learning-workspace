#
# Functions
# Description: custom shell scripts
# Path: ~/.zshrc.d/functions.d/
#

# archive extration
# usage: extract <file>
source "$(dirname "$0")/functions.d/archive-extraction.sh"

# navigation
# example: cd-up 3
# this will navigate up 3 directories
source "$(dirname "$0")/functions.d/change-dir-up.sh"

# find directory and open selected in nvim
source "$(dirname "$0")/functions.d/find-dir.sh"

# find file and open selected in nvim
source "$(dirname "$0")/functions.d/find-file.sh"

