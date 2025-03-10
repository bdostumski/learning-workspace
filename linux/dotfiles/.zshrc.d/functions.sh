#
# Functions
# Description: custom shell scripts
# Path: ~/.zshrc.d/functions.d/
#

# -----------------
# Archive Extration
# -----------------
# Usage: extract <file name>
source "$(dirname "$0")/functions.d/archive-extraction.sh"

# -----------------
# Navigation
# -----------------
# Example: cd-up 3
# This will navigate up 3 directories
source "$(dirname "$0")/functions.d/change-dir-up.sh"

# -----------------
# Find Directory 
# -----------------
# Find directory and open selected in Nvim
source "$(dirname "$0")/functions.d/find-dir.sh"

# -----------------
# Find File
# -----------------
# Find file and open selected in Nvim
source "$(dirname "$0")/functions.d/find-file.sh"

