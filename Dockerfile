FROM maven:3.8.2-jdk-8
RUN mvn clean package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]