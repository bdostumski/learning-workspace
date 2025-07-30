#!/bin/bash
#
# SED = Stream EDitor
# A stream is data that travels from:
# - One process to another through a pipe.
# - One file to another as a redirect.
# - One device to another

# Standard Input = Standard Input Stream
# Standard Output = Standard Output Stream

# Sed - stream editor for filtering and transorming text:
# - Substitue some text for other text.
# - Remove lines.
# - Append text after given lines.
# - Insert text before certain lines.

# Sed is used programmatically, not interactively.
echo 'Dwight is the assistant regional manager.' >manager.txt
# Substitute word 'assistant' with 'assistant to the'
sed 's/assistant/assistant to the/' manager.txt

# Sed is case sensitive - to use case insensitive
sed 's/Assistant/assistant to the/i' manager.txt

# For multiple lines - have to use global
sed 's/assistant/assistant to the/g' manager.txt

# Change sed delimiter from s/ to s: for example. To remove the escape usage for exmple \/
echo '/home/jason' | sed 's:/home/jason:/export/users/jasonc:'

# Delete first line where 'assistant' word is present
sed '/assistant/d' manager.txt

# Regex that matches the beginning of the line
sed '/^#/d' config.txt

# Regex that matches empty lines
sed '/^$/d' config.txt

# Group both
sed '/^#/d ; /^$/d' config.txt

# Replace 'some text' with 'text' word
sed '/^#/d; /^$/d; s/some text/text' config.txt
