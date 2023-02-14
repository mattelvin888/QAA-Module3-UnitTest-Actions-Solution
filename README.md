# QAA-Module3-UnitTest-Actions-Solution
Solution for automating the unit tests provided using Github Actions  

This repository builds upon the reference solutions for QAA-Module3-UnitTest-Exercises by automating the process of testing and building 
the java code provided using a Github Actions workflow.

## Workflow Structure
The workflow follows the standard Github Actions workflow structure. After setting the name, the triggers are defined - in this case pushes 
to the main branch and manual invocation will trigger the workflow. The workflow has one job, with three steps: first the repository is 
checked out, the github actions java-setup module is used to configure a JDK installation, which includes maven, and then the unit tests are
run via `maven clean test`

## Java Issues
A few issues with the original reference solutions had to be overcome to run the tests using Actions:
* The test classes and methods were not public - maven did not seem to be able to find the test classes until they were made public
* method naming conventions - for maven to find the test methods, they must be prefixed with 'test'
* setUp and tearDown - the housekeeping methods are not being run - fixing this is a work in progress
* changes to pom.xml - to ensure compatibility, it is suggested to change 'junit-jupiter-api' to simply 'junit-jupiter', and add a 
dependency for a compatible version of the maven-surefire-plugin
