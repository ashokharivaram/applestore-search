# project: applestore-search
Apple iTunes search API tests with Query Parameters


--------------------------------- Contents ---------------------------------

Prerequisites: Java 1.8, maven 3+

>> TestPlan
	- Refer to GitHub project folder for the test plan document named "TestPlan.xlsx"

>> Automated tests
	- Used a very generic framework for automating the tests
	- Tests can be found in "src/test/java/tests" folder
	- TestData can be found in "src/test/resources" folder
	- Used Restassured-java for automating API calls and TestNG for running the tests

>> Execution steps and results
	- Make sure of the Prerequisites mentioned in the section above
	- Navigate to "https://github.com/ashokharivaram/applestore-search" from browser
	- Download the codebase from "https://github.com/ashokharivaram/applestore-search.git" to local machine
	- Open command prompt and navigate to the project folder using command "cd <path/to/project/folder>
	- Enter the command "mvn test" and click ENTER
	- In case of first run, it will download the required jars from maven repo and then runs the tests
	- Post execution, TestNG report can be found in the path "{project-folder}/target/surefire-reports/emailable-report.html"

>> Issues found
	- Refer the "TestPlan.xlsx" document "Issues" column for the discovered Issues.