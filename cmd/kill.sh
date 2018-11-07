basedir=`pwd`
app="$1"
runAt="$basedir/../$app"

if [ -d  $runAt ]; then
	cmd="$2"
	if [ -f $runAt/pid_$cmd.txt ]; then
		kill -9 `cat $runAt/pid_$cmd.txt`
		echo "killed the $app !"
	else
		echo "can't find the $app's pid"
	fi
else
	echo "can't find $app's data dir !!"
fi
