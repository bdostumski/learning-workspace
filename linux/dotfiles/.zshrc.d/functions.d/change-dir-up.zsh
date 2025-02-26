#!/usr/bin/env zsh
#
# navigation
# example usage: cd-up 3 
# this will navigate up 3 directories
#
cd-up () {
	local d=""
	local limit="$1"

	if [ -z "$limit" ] || [ "$limit" -le 0 ] ; then
		limit=1
	fi

	for (( i=1; i<=limit; i++ )) do
		d="../$d"
	done

	if ! cd "$d"; then
		echo "Could not go up $limit dirs.";
	fi
}


