FROM openjdk:8-jre-alpine
ADD target/employee-0.0.1-SNAPSHOT.jar employee-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "employee-0.0.1-SNAPSHOT.jar"]