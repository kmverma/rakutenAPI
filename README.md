# rakutenAPI
Steps to run Test 

1- Clone code using clone url 

git clone https://github.com/kmverma/rakutenAPI.git

2- Check to master branch by following command

git checkout master

3- edit config app.properties inside src/main/resources and change following properties (this step is optional, do only if already mentioned port are already in use)

	3.1 change port in api.endpoint and this port should be same as server port defined in property file
	3.2 change server port
	3.3 change propxy server port

4- run following command from inventoryapi-test directory inside project root directory which contains pom.xml file to run test 

 mvn clean test  -Dsuite=testng.xml

5- Report will be generated inside inventoryapi-test/target/surefire-reports/html/ folder and open overview.html file to see report
