# QAA-Module3-UnitTest-Actions-Solution
Solution for automating the unit tests provided using Github Actions  

This repository builds upon the [reference solutions for QAA-Module3-UnitTest-Exercises](https://github.com/MrWalshyType2/QAA-Module3-UnitTest-Exercise-Solutions) by automating the process of 
testing and building the java code provided using a Github Actions workflow.

## Workflow Structure
The workflow follows the standard Github Actions workflow structure. After setting the name, the triggers are defined - in this case pushes 
to the main branch and manual invocation will trigger the workflow. The workflow has one job, with six steps:
* The repository is checked out using actions/checkout
* The JDK is configured, using actions/java-setup
* Maven is used to run the unit tests, and the output of this is saved to a logfile
* Maven is then used to package the compiled source code into a jar file
* The test log and jar file are copied into an artifacts directory
* The artifacts directory is saved as a build artifact using actions/upload-artifact

## Java Issues
A few issues with the original reference solutions had to be overcome to run the tests using Actions:
* The test classes and methods were not public - maven did not seem to be able to find the test classes until they were made public
* method naming conventions - for maven to find the test methods, they must be prefixed with 'test'
* setUp and tearDown - the housekeeping methods are not being run - fixing this is a work in progress
* changes to pom.xml - to ensure compatibility, it is suggested to change 'junit-jupiter-api' to simply 'junit-jupiter', and add a 
dependency for a compatible version of the maven-surefire-plugin
