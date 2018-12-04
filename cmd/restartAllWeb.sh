SVR=" search sso item cart  order manager portal"
echo 'to start web apps :' $SVR
for x in $SVR
do
echo "          start app:  $x ...."
./runit.sh $x web

sleep 5

done
