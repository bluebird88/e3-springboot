SVR="search sso cart content order manager"
echo 'to start service:' $SVR
for x in $SVR
do
echo "          start $x ...."
./runit.sh $x svr
sleep 5

done
