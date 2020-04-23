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
To run the application with spring-boot maven plugin to have to run
```
> mvnw spring-boot:run
```
or you can run it via the java -jar command
```
> java -jar .\target\flight-tickets-manager-0.0.1-SNAPSHOT.jar
```

Now, the application is running on http://locahost:8080/flighttickets.

### Database

This application uses an in memory H2 database.

You can access the console in browser with URL http://localhost:8080/h2.

Here you can verify the table structure and data.

### Testing
To execute the application tests using maven, you have to run
```
> mvnw clean test
```
Also, in the folder postman in the project root, there is a Postman collection to test te API.

### Running Docker container
You can create a docker image and run the app in a docker container. For this you need Docker installed in your machine. 


Open a terminal and go to app root folder and build the application .jar file using maven wrapper.
```
> mvnw clean package
```
Build a docker image from the Dockerfile.
```
> docker build -t flight-tickets-manager .
> docker run --rm -ti -d -p 8080:8080 --name flighttickets flight-tickets-manager
```
Now, the application is running on http://locahost:8080/flighttickets.

If you want to access to the container you have to run
```
> docker attach flighttickets
```
If you want to remove the container, you have to run
```
> docker kill flighttickets
```



