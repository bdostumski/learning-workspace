#!/bin/bash
#
# Declare log function
# log() {
#     local VERBOSE="${1}"
#     shift
#     local MESSAGE="${*}"
#     if [[ "${VERBOSE}" = 'true' ]]; then
#         echo "${MESSAGE}"
#     fi
# }
# # Call log function with parameters
# VERBOSITY='true'
# log "${VERBOSITY}" 'Hello!'
# log "${VERBOSITY}" 'This is fun!'
#
# Declare log function
log() {
    # This function sends a message to syslog and to standard output if VERBOSE is true.
    local MESSAGE="${*}"
    if [[ "${VERBOSE}" = 'true' ]]; then
        echo "${MESSAGE}"
    fi
    logger -t functions.sh "${MESSAGE}"
}

backup_file() {
    # This function creates a backup of a file. Returns non-zero status on error.
    local FILE="${1}"

    # Make sure the file exists.
    if [[ -f "${FILE}" ]]; then
        local BACKUP_FILE
        BACKUP_FILE="/var/tmp/$(basename ${FILE}).$(date +%F-%N)"
        log "Backing up ${FILE} to ${BACKUP_FILE}"

        # The exit status of the function will be the exit status of the cp command.
        cp -p ${FILE} ${BACKUP_FILE}
    else
        # The file does not exists, so return a non-zero exit status.
        return 1
    fi
}

# Call log function with parameters
# To make global variable unchangable use readonly key word
readonly VERBOSE='true'
log 'Hello!'
log 'This is fun!'

# Backup /etc/passwd file into /var/tmp/passwd.[current date]
backup_file '/etc/passwd'

# Make a decision based on the exit status of the funciton.
if [[ "${?}" -eq '0' ]]; then
    log 'File backup succeded!'
else
    log 'File backup failed!'
    exit 1
fi
