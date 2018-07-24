<h1><a id="embeddedrestexample_0"></a>embedded-rest-example</h1>
<p>Embedded Jetty and Derby Example using Jersy REST</p>
<p>git clone <a href="https://github.com/subramanyahs/embedded-rest-example.git">https://github.com/subramanyahs/embedded-rest-example.git</a><br>
cd embedded-rest-example<br>
mvn clean install</p>
<p>#run the app<br>
java -jar shareapp-1.0-SNAPSHOT.jar</p>
<p>#with debugger<br>
java -agentlib:jdwp=transport=dt_socket,server=y,address=8000,suspend=n -jar shareapp-1.0-SNAPSHOT.jar</p>
<p>#load sample db<br>
#goto target folder and execute below command<br>
java -cp shareapp-1.0-SNAPSHOT.jar org.apache.derby.tools.ij …\src\main\resources\sql_scripts.txt</p>
<p>#Login details<br>
Mobile Number: 123456789<br>
OTP: 1234</p>
