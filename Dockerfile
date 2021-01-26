FROM openjdk:latest
COPY ./target/SEMCourseworkGroupB-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEMCourseworkGroupB-0.1.0.2-jar-with-dependencies.jar"]