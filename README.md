# embedded-rest-example
Embedded Jetty and Derby Example using Jersy REST 

git clone https://github.com/subramanyahs/embedded-rest-example.git
cd embedded-rest-example
mvn clean install

#run the app 
java -jar shareapp-1.0-SNAPSHOT.jar

#with debugger
java -agentlib:jdwp=transport=dt_socket,server=y,address=8000,suspend=n -jar shareapp-1.0-SNAPSHOT.jar

#load sample db 
#goto target folder and execute below command 
java -cp shareapp-1.0-SNAPSHOT.jar org.apache.derby.tools.ij ..\src\main\resources\sql_scripts.txt

#Login details 
Mobile Number: 123456789
OTP: 1234
