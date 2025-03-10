#
# FUNCTIONS
# Description: custom shell scripts
# Path: ~/.zshrc.d/functions.d/
#

# -----------------
# ARCHIVE EXTRATION
# -----------------
# Usage: extract <file name>
source "$(dirname "$0")/functions.d/archive-extraction.sh"

# -----------------
# NAVIGATION
# -----------------
# Example: cd-up 3
# This will navigate up 3 directories
source "$(dirname "$0")/functions.d/change-dir-up.sh"

# -----------------
# FIND DIRECTORY 
# -----------------
# Find directory and open selected in Nvim
source "$(dirname "$0")/functions.d/find-dir.sh"

# -----------------
# FIND FILE
# -----------------
# Find file and open selected in Nvim
source "$(dirname "$0")/functions.d/find-file.sh"

