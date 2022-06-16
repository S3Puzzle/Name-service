FROM openjdk:8
EXPOSE 8083
ADD target/s3puzzle.jar s3puzzle.jar
ENTRYPOINT ["java","-jar","/s3puzzle.jar"]