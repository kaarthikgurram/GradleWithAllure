#Upgrade Coding Challange Repo
This repo contains integration tests for both front end and back end application

##Requirements

    Windows machine/server
    Java JDK 13 or above version
    Chrome Installed

## Commands to run tests locally/QA/DEV
To test against your local environment, simply execute the gradle test task.  For dev and QA, run the testDev and testQA
tasks. Tests all are build on Junit framework.

    ./gradlew test
    ./gradlew testDev
    ./gradlew testQA

##Command to run tests on CI/CD(GITHUB)
Right now the repo is hosted on GIT, up on each commit to master and on each pull request the build will run. 
Developer doesnt have to do anything explicitly to kick the build

The junit test report will be in

    build/reports/tests/[test/testDev/testQA]

If you want to run a single test class within Intellij, then use the "Edit Configurations..." feature and set the
"Environment variables" text box to: "spring.profiles.active=qa" (or dev/local/staging)

To Run checkstyle, use below commands. Checkstyle used is Google check style and manually edited few rules to make 
compatible with project like line number, imports ordering etc.

    ./gradlew checkStyleTest
    ./gradlew checkstyleMain

##Folder Structure
* com.upgrade
    * frontend
        * Client
        * Fixtures
        * Test classes
    * Backend
        * Client
        * Fixtures
        * Test classes
    
## Usage
* The package name is the repo name, following java naming conventions.
* Since most of the tests are supposed to run in different environments preferred to use the concept of spring 
  profiles which provides users the ability to run tests in different environment directly from command line or yml scripts for 
  continuous integration.  
* Below are standards used for test case naming convention
  First part of test case name should mention on what functionality/application/endpoint test is running on.
  Second part of test name should mention about what are the inputs we are supplying to test case
  Third part of test case name should mention about expected output.
  eg:upgradeApi_happyPath_acceptedResponse, upgradeApi_invalidUsername_declineWithUnAuthorized
* Construction of Pojos in the repo is done using Java builder pattern. This gives the user ability to improve the 
  readability and sending dynamic values in test cases reducing the burden of creating whole object again.
  

## Generate Allure reports
Allure Server C:\karthik\upgrade\upgrade\build\allure-results