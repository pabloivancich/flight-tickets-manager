FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/flight-tickets-manager-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} flight-tickets-manager.jar
CMD java -jar flight-tickets-manager.jar

