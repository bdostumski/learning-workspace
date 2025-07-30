#!/bin/bash
#
#  Count the number of failed logins by IP address.
#  If there are any IPs with over LIMIT failuers, display the count, IP and location.

LIMIT='10'
LOG_FILE="${1}"

# Make sure a file was supplied as a argument.
if [[ ! -e "${LOG_FILE}" ]]; then
    echo "Cannot open log file: ${LOG_FILE}" >&2
    exit 1
fi

# Loop through the list of failed attempts and corresponding IP addresses.
# Example:
# 123 192.168.1.1
# 110 192.168.1.2
# 100 192.168.1.3
#
# Explain:
# Count column values: 123, 110, 100
#
# Display the CSV header.
echo "Count,IP,Location"

# IP column values: *.*.1.1, *.*.1.2, *.*.1.3
grep Failed "${LOG_FILE}" | awk '{print $(NF -3)}' | sort | uniq -c | sort -nr | while read -r COUNT IP; do
    # If the number of failed attempts is greater than the limit, display count, IP, and location.
    if [[ "${COUNT}" -gt "${LIMIT}" ]]; then
        LOCATION=$(geoiplookup "${IP}" | awk -F ',' '{print $2}')
        echo "${COUNT},${IP},${LOCATION}"
    fi
done

exit 0
