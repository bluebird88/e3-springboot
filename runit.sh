app=$1
cmd=$2

if [ ! "$app" = "" ] && [ ! "$cmd" = "" ]; then
	source ./cmd/$app.sh $cmd
	echo " $app has been launched ..."
else
	echo "missing param, run it like: run.sh <app> <cmd>"
fi
