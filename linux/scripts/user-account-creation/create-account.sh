#!/bin/bash
#
# This script creates an account on the local system.
# You will be prompted for the account name and password.
#
# Ask for the user name.
read -r -p 'Enter the username to create: ' USER_NAME
#
# Ask for the real name.
read -r -p 'Enter the name of the person who this account is for: ' COMMENT
#
# Ask for the password.
read -r -p 'Enter the password to use for the account: ' PASSWORD
#
# Create the user.
useradd -c "${COMMENT}" -m ${USER_NAME} &> /dev/null
#
# Set the password for the user.
echo "${PASSWORD}" | passwd --stdin ${USER_NAME}
#
# Force password change on first login.
passwd -e ${USER_NAME}
