#!/usr/bin/env sh
#
#  This script creates a new user on the local system.
#  You will be prompted to enter the username (login), the person name, and a password.
#  The username, password, and host for the account will be displayed.
#
#  Make sure the script is being executed with superuser privileges.
if [[ "${UID}" -ne 0 ]]; then
    echo 'Please run with sudo or as root.' 1>&2
    exit 1
fi
#
# Get the username (login).
read -r -p 'Enter the username to create: ' USER_NAME
#
# Get the real name (contents for the description field).
read -r -p 'Enter the name of the person or application that will be using this account: ' COMMENT
#
# Get the password.
read -r -p 'Enter the password to use for the account: ' PASSWORD
#
# Create the account.
useradd -c "${COMMENT}" -m ${USER_NAME} >&/dev/null
#
# Check to see if the useradd command succeeded.
# We don't want to tell the user that an account was created when it hasn't been.
if [[ "${?}" -ne 0 ]]; then
    echo 'The account could not be created.' 1>&2
    exit 1
fi
#
# Set the password
echo ${PASSWORD} | passwd --stdin ${USER_NAME} &> /dev/null
if [[ "${?}" -ne 0 ]]; then
    echo 'The password for the account could not be set.' 1>&2
    exit 1
fi
#
# Force password change on first login.
passwd -e ${USER_NAME}
#
# Display the username, password, and the host where the user was created.
echo
echo 'username:'
echo "${USER_NAME}"
echo
echo 'password:'
echo "${PASSWORD}"
echo
echo 'host:'
echo "${HOSTNAME}"
#
exit 0
