#!/usr/bin/env sh
#
# This script generates a list of random passwords.
#
# A random number as a password.
PASSWORD="${RANDOM}"
echo "${PASSWORD}"
#
# Three random numbers together.
PASSWORD="${RANDOM}${RANDOM}${RANDOM}"
echo "${PASSWORD}"
#
# Use the current date/time/nano seconds as the basis for the password.
PASSWORD=$(date +%s%N)
echo "${PASSWORD}"
#
# Use the current date/time/nano seconds as the basis for the password.
PASSWORD=$(date +%s%N)
echo "${PASSWORD}"
#
# A better password.
PASSWORD=$(date +%s%N${RANDOM}${RANDOM} | sha256sum | head -c 48)
echo "${PASSWORD}"
#
# Append a speciall character to the password.
SPECIAL_CHARACTER=$(echo '!@#$%^&*()_-+=' | fold -w1 | shuf | head -c1)
echo "${PASSWORD}${SPECIAL_CHARACTER}"
