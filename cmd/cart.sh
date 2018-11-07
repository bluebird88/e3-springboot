basedir=`pwd`
app="cart"
runAt="$basedir/../$app"

if [ ! -d  $runAt ]; then
	mkdir $runAt
fi

if [ "$1" = "web" ]; then
	echo "launch $app web app..."
	cd "e3-$app-$1"
	mvn spring-boot:run  > $runAt/$1.log 2>&1 &
	 echo $! > $runAt/pid_$1.txt
	cd $basedir
fi

if [ "$1" = "svr" ];then
	echo "launch $app service app..."
	cd "e3-$app/e3-$app-service"
	mvn spring-boot:run  > $runAt/$1.log 2>&1 &
	 echo $! > $runAt/pid_$1.txt
	cd $basedir
fi

if [ "$1" = "" ];then
	echo "no implemented!"
fi
