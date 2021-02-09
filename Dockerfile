FROM openjdk:latest
COPY ./target/semcourseworkgroupb-0.1.0.4-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semcourseworkgroupb-0.1.0.4-jar-with-dependencies.jar"]