# taxi24

Taxi24 is a new startup based in Kigali. They would like to disrupt the taxi industry in Rwanda by providing a white-label solution to the
existing taxi companies and hotels. Practically, they will build a set of APIs that other companies can use to manage their fleet of drivers and
allocate drivers to passengers. They would like your help building these APIs

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

first you need to install below:
1.jdk-11.0.7
2.Eclipse IDE for Enterprise Java Developers - 2020-03
3. MYSQL Workbench
4. postman=> create account.
5. Apache Tomcat 9.0

##import

after installation you import the below database and project in:

tax24 (project)=>Eclipse 
tax24 (database)=> Mysql workbbench

## Running the tests

after importing the project into Eclipse below are package names and classes to be used:

main package: com.tax24.application
main Class: mainApplication.java (to run it right click on it and run as java application.
* once the tomcat started go to 
* postman and use any method you want(POST,GET, DELETE,...) using different paths indicated in different classes. 

example: 
postman path to save into database(Riders table):http://localhost:8080/company/Riders
Note: remember to change the password and username to yours into application.properties file:
-spring.datasource.username=??????????
-spring.datasource.password=???????????



thank you !!

