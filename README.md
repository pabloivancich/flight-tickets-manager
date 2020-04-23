# Flight Tickets Manager
Demo microservice project to manage flight tickets

### Prerequisites

In order to run the microservice, you have to have installed Java JDK 13 in your local machine.
This project uses maven wrapper, so you don't need to have maven installed.

### Installing and running

Checkout the project from GitHub and go to the root folder. 
To compile and package the application
```
> mvnw clean package
```
To run the application you have to run spring-boot maven plugin
```
> mvnw spring-boot:run
```
or you can run ti via the java -jar command
```
> java -jar .\target\flight-tickets-manager-0.0.1-SNAPSHOT.jar
```

This application uses an in memory H2 database.
You can access the console in browser with URL http://localhost:8080/h2.
Here you can verify the table structure and data.

### Testing
To execute the applciation test using maven, you have to run
```
> mvnw clean test
```
Also, in the folder postman in the project root, there is a Postman collection to test te API. 



