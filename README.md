# PhoneBook RESTful Web Service

An example implementation of a RESTful Web Service using Spring Boot.

## How to run the service

This is a Spring Boot project built with Maven 3.3 and Java 8. So, after you clone it, you can follow Spring Boot instructions and run the phonebook
with one of the following 3 ways:

* Type `mvn spring-boot:run` in your console, to use the Maven plugin.

* Build the project with mvn install and then run it as a packaged application with `java -jar target/rest-service-0.0.1-SNAPSHOT.jar`.

* Load the project on your favourite IDE and run it from there. For Eclipse, this would be `mvn install eclipse:eclipse` to build the project, 
  Import -> Existing Projects into Workspace and finally Run as Java Application on the Application.java file.

## How to interact with the phone book
 To take a look at the users phonebook's API you can type `http://localhost:8080/api/users` on your browser. 
 There you will find a short description of the project and an overview of the operations you can execute, using the PhoneBook API. 
 
These operations are:

Search all contacts by name or phone. In case that there are not search criteria, all contacts will be returned.
Retrieve a single specific contact.
Create a new  contact.
Update an old one.
Delete a single specific contact.
and the same with users.
