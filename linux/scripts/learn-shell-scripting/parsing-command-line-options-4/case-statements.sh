#!/bin/bash
#
# This script demonstrates the case statement.
#
#
# If statement
# if [[ "${1}" = "start" ]]; then
#     echo "Starting."
# elif [[ "${1}" = "stop" ]]; then
#     echo "Stopping."
# elif [[ "${1}" = "status" ]]; then
#     echo 'Supply a valid option.' >&2
#     exit 1
# fi
#
#
# Case statement
case "${1}" in
start)
    echo "Starting."
    ;;
stop)
    echo "Stopping."
    ;;
status | state | --status | --state)
    echo 'Supply.'
    ;;
*)
    echo 'Supply a valid option'. >&2
    exit 1
    ;;
esac
#
#
# Single line case statement
# case "${1}" in
# start) echo "Starting." ;;
# stop) echo "Stopping." ;;
# status) echo 'Supply.' ;;
# * )
#     echo 'Supply a valid option'. >&2
#     exit 1
#     ;;
# esac
