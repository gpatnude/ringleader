#!/bin/sh

##
#
#
#
#
#
##

## 
function usage {

	echo ""
	echo "You must be fucking crazy to even try this..."
	echo ""

}

# LAUNCHER LOGIC:
export PARAMS=$@
for param in "$@"; 
do 

	echo $param; 

done

options=':q:nd:h'
while getopts $options option
do
    case $option in
        q  )    queue=$OPTARG;;
        n  )    execute=$FALSE; ret=$DRYRUN;; # do dry run
        d  )    setdate=$OPTARG; echo "Not yet implemented.";;
        h  )    error $EXIT $DRYRUN;;
        \? )    if (( (err & ERROPTS) != ERROPTS ))
                then
                    error $NOEXIT $ERROPTS "Unknown option."
                fi;;
        *  )    error $NOEXIT $ERROARG "Missing option argument.";;
    esac
done

shift $(($OPTIND - 1))

