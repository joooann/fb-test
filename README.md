# fb-test

Prerequisites
---------------
*	Java jdk-1.8 or higher
*	Apache Maven 3 or higher

The test
---------------
Verifies a happy path of fb's sign up functionality using test data that are randomly generated. It is found in src\test\com\planit\jo\app\fb\suites\SignUpTest.java

To execute the test
---------------
*	Open command prompt and go to  root folder
*	Run command 'mvn clean test -P account-creation'

Test report
---------------
The report can be accessed from 'target\surefire-reports\emailable-report.html' folder