#!/bin/bash
#
# This script generates a random password.
# This user can set the password length with -l and add a special character with -s.
# Verbose mode can be enabled with -v.
#
# Set a default passwrod length
LENGTH=48

usage() {
    echo "Usage: ${0} [-vs] [-l Length]" >&2
    echo "Generate a random password."
    echo '  -l  LENGTH  Specify the password length.'
    echo '  -s          Append a special character to the password'
    echo '  -v          Increase verbosity.'
    exit 1
}

log() {
    local MESSAGE
    MESSAGE="${*}"
    if [[ "${VERBOSE}" = 'true' ]]; then
        echo "${MESSAGE}"
    fi
}

while getopts vl:s OPTION; do
    # v - Indicates a flag option (-v) that does not require argument
    # l: - The l option (-l) requires an argument. The colon (:) right after the l means argument must follol (-l), like (-l something)
    # s - This is another flag option (-s) that does not require an argument
    case ${OPTION} in
    v)
        VERBOSE='true'
        log 'Verbose mode on.'
        ;;
    l)
        LENGTH="${OPTARG}"
        ;;
    s)
        USE_SPECIAL_CHARACTER='true'
        ;;
    ?)
        usage
        ;;
    esac
done

# Print passed arguments
# echo "Number of args: ${#}"
# echo "All args: ${*}"
# echo "Fist arg: ${1}"
# echo "Second arg: ${2}"
# echo "Third arg: ${3}"

# Inspect OPTIND
# echo "OPTIND: ${OPTIND}"

# Remove the options while leaving the remaining arguments.
shift "$((OPTIND - 1))"

# echo "After the shift:"
# echo "All args: ${*}"
# echo "Fist arg: ${1}"
# echo "Second arg: ${2}"
# echo "Third arg: ${3}"

# Exit from code
if [[ "${#}" -gt 0 ]]; then
    usage
fi

log 'Generating a password'

# Generate a random password with specific length
PASSWORD=$(date +%s%N${RANDOM}${RANDOM} | sha256sum | head -c"${LENGTH}")

# Append a special character if requested to do so.
if [[ "${USE_SPECIAL_CHARACTER}" = 'true' ]]; then
    log 'Selecting a random special character.'
    SPECIAL_CHARACTER=$(echo '!@#$%^&*()_-+=' | fold -w1 | shuf | head -c1)
    PASSWORD="${PASSWORD}${SPECIAL_CHARACTER}"
fi

log 'Done.'
log 'Here is the password:'

# Display the password.
echo "${PASSWORD}"

exit 0
