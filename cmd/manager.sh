
app="manager"
runAt="../$app"

if [ ！ -d  $runAt ]; then
	mkdir $runAt
fi

if [ "$i" = "web" ];then
	echo "launch $app web app..."
	cd "e3-$app/e3-$app-$1"
	nohup nvm spring-boot:run > $runAt/$1.txt & echo $! > pid_$1.txt
fi

if [ "$i" = "svr" ];then
	echo "launch $app service app..."
	cd "e3-$app"
	nohup nvm spring-boot:run > $runAt/$1.txt & echo $! > pid_$1.txt
fi

if [ "$i" = "" ];then
	echo "no implemented!"
fi