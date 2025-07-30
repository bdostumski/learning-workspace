#!/bin/bash
#
#  This script show the open network ports on a system.
ss -nult | grep ':' | awk '{print $5}' | awk -F ':' '{print $NF}' | grep -v '^Local' | sort -n | uniq -c
