# Linux Configuration and Shell Scripts

## Shell Scripts

1. Shell script file permissions:
  - chmod 755 script.sh
  - chmod +x script.sh
  
2. The Basics:
  - Shebang: #!/bin/bash
  - Comments: #
  - Variables: VAR="value"

3. Create Standard Output and Quoting
   - The **echo** buildin.
   - Single versus double quotes:
     - "${VAR} gets expanded."
     - '${VAR} does NOT get expanded.'
     
4. Getting Help for Shell Builtins
   - type: 
     - type [-afptP] name [name ...]
   - help:
     - help [-s] [pattern ...]
     
 5. Getting Help for Linux Commands
    - man 
    
6. Shell Variables
   - Environment variables:
     - ${PATH}     :   Directories the shell searches for commands
     - ${HOME}     :   Current user's home directory
     - ${USER}     :   Username of the current user
     - ${SHELL}    :   Path to the current user
     - ${LANG}     :   Current language/location settings
     - ${PWD}      :   Present working directory
     - ${OLDPWD}   :   Previous directory
     - ${EDITOR}   :   Default text editor
     - ${TERM}     :   Terminal type
     - ${UID}      :   User ID of the current user
   - Special Shell variables:
     - ${0}   :   Name of the script
     - ${#}   :   Number of arguments
     - ${$}   :   Process ID of the current shell
     - ${?}   :   Exit status of the last command
     - ${!}   :   PID of the last background process
     - ${1},${2},etc.   :    Positional parameters(arguments)
     - ${@} / ${*}      :    All arguments
   - Shell Built-in variables:
     - ${PS1}       :   Defines the shell prompt
     - ${IFS}       :   Internal Field Separator (used for word spliting)
     - ${RANDOM}    :   Return a random number each time it isreferenced
     - ${SECONDS}   :   Number of seconds since the script started
     - ${BASH_VERSION}  :   Version of the bash shell
   - etc.

7. Command Substitution
   - VAR=$(command)   : execute command and assigne result to the variable
   - VAR=\`command\`  : old style
   - VAR="${command}" : new style
   
8. The if statement

```bash
if [[ COMMANDS ]]; then
    COMMANDS
elif [[ COMMANDS ]]; then
    COMMANDS
else
    COMMANDS
fi
```

9. Exit Statuses
   - 0 = true/successful
   - 1 = false/unsuccessful
   - Any non-zero exit status represents a failure.

10. Obtaining Standar Input
    - read - p 
    
11. The for loop

``` bash
for VARIABLE in LIST
do
    COMMANDS
done
```

12. The while loop

``` bash
while [[ COMMANDS ]]; 
do
    COMMANDS
done
```

13. I/O Redirection - Pipes
    - Sending STDOUT as STDIN
      - echo "${PWD}" | passwd --stdin "${NAME}"

14. File I/O Redirection 
    - COMMAND > /path/to/file   :   replace the content of the file
    - COMMAND >> /path/to/file  :   adds output to the end of the file
    - COMMAND < /path/to/file   :   reads the content of the file and sends it to the command
    - COMMAND 2> /path/to/file  :   redirects standard error (stderr) to a file
    - COMMAND &> /path/to/file  :   redirects stdout and stderr to a file
    - COMMAND |& COMMAND : redirects both stdout and stderr from the first command to the second 
    - COMMAND >&2 : redirects standar output (stdout) to the standard error (stderr)
    - COMMAND > /dev/null : redirects stdout to /dev/null, like (a "black hole")
     

## Dotfiles - Arch Frame
[Installing and configuring software for Arch Linux](https://github.com/bdostumski/arch-frame)

