## runsvr.sh <name>  <type>
if [ "$2" = "web" ]
then
cd "$1"
echo "~~~~~~~~~~~~~recompile and install ~~~~~~~~~~~:$(pwd)"
mvn clean package

cd "$1-web"
echo "~~~~~~~~~~~launch service ~~~~~~~~~~~~~~~~~~~~:$(pwd)"
mvn spring-boot:run
cd ..
fi

if [ "$2" = "" ]
 then
cd "$1"
echo "~~~~~~~~~~~~~recompile and install ~~~~~~~~~~~:$(pwd)"
mvn clean package install
cd "$1-service"
echo "~~~~~~~~~~~launch service ~~~~~~~~~~~~~~~~~~~~:$(pwd)"
mvn spring-boot:run
cd ..
fi