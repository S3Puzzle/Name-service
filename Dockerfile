FROM openjdk:11
EXPOSE 8083
ADD target/name.jar name.jar
ENTRYPOINT ["java","-jar","/name.jar"]