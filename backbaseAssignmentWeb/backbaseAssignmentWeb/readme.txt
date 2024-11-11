## Backbase Automation Framework [iOS, Android & Unified Extension]

In this File I'm going to explain <b>How to configure </b> and <b>Run this Framework</b>

The tech stack used for developing this framework are:
1. **JAVA** as the programming language for writing test code
2. **Cucumber** as the BDD tool for developing the framework
3. **Selenium** as the Automation tool for Unified Extension
4. **TestNg** as the unit test framework
5. **Maven** as the build tool
6. **IntelliJ Idea** as the preferred IDE for writing java code


#### Getting Started
Set up your machine.
1. Install JDK 1.8 & set "JAVA_HOME" in environment variable
2. Install Eclipse
3. Download and Set "Maven_Home" as a environment variable
4. Install Cucumber Eclipse plugin in Eclipse


#### Running tests
``Note:`` Sometime JRE System Library might be referring the wrong Library, please do select the JDK path in Build Path ```
1. You can run the tests directly from the Eclipse, by right-clicking POM.xml and **maven test**.
2. After the Execution logs and HTML report will be generated with the time stamp under "reports" folder, right-click on the RWSExecutionResult.html to see the detailed results.
3. For Mac:
		-> Open the terminal
		-> Navigate to Project [Backbase] Folder{root} directory
		-> Execute the below command
		```mvn clean install```

#Note
1. Select the Test Tag in testNG.xml
2. Mention Feature folder name in TestRunner.java class and Mention the Tag name to execute
---

#### Reason to choose BDD framework approach
1. BDD is meant to be collaborative. Behaviour Driven Development (BDD) framework helps to attain all the prospects of a technical or business team.
2. Universal language which is very easy to describe
3. Business Value
4. Partnership between Business Analysts, Stake-holders, QA Team and developers
5. Separation of Test Cases from Test Code
6. Inherent Re-usability
7. Aspect-Oriented Controls
8. Easier Reviews
9. Clarity, Steam-lining, Shift left
10. Maintainable

## BDD Framework Execution flow

### Miro

#### Step 1: Run -mvn clean install command
#### Step 2: POM.xml starts downloading the dependencies and calls TestNG.xml
#### Step 3: TestNG.xml calls a class "TestRunner.java" [which is under src/test/java/runner package
#### Step 4: In TestRunner.java, CucumberOptions refers the feature files [which is under Feature/] folder, tags adds the scenarios to run, glue code refers the step definition package [src/test/java/com.Rakuten.rwdsdk.steps], plugin uses extent report for report generation.
#### Step 5: Once after referring all the required dependencies, Framework will start running the scenarios one by one, below is the one sample example of how a single scenario runs[Which is same for all the scenarios]
#### Step 6: Execution Completes
#### Step 7: We can examine the Framework execution by referring to HTML report

### Framework Folder Structure

### Backbase - Root Directory

	### src/main/java/com - For keeping all the reusable codes [Project Specific & Generic's]
		###base - For Managing the driver, page, property file reader
		###pages - Page manager classes for web page classes
		###utils - All the utilities functions are developed under this package in different classes.

	### src/test/java - Execution package
		###com.backbase.runner - To specify what to scenarios to run
		###PetClinicStep Definition - Step implementations for all the steps in feature files

	### src/test/resources - test data and configuration folder
		###features - petClinic.feature

	###Reports - Execution status in HTML /reports


	###POM.xml - Project Object Modal file for all the dependency and executions.
	###TestNG.xml - To identify and run the TestRunner.Java class
	###ReadMe.md - Details about the Backbase - BDD framework


























