FROM openjdk:17-jdk-alpine
ADD target/job-app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]