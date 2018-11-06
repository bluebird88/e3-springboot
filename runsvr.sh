## runsvr.sh <name>  <type>

### web1: deep dir mode

if [ "$2" = "web1" ]
then
cd "$1"
echo "~~~~~~~~~~~~~recompile and install ~~~~~~~~~~~:$(pwd)"
mvn clean package

cd "$1-web"
echo "~~~~~~~~~~~launch service ~~~~~~~~~~~~~~~~~~~~:$(pwd)"
mvn spring-boot:run
cd ..
fi


### web2: low dir mode
if [ "$2" = "web2" ]
then

cd "$1-web"
echo "~~~~~~~~~~~~~recompile and install ~~~~~~~~~~~:$(pwd)"
mvn clean package

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