FROM openjdk:latest
COPY ./target/semcourseworkgroupb-0.1.0.5-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semcourseworkgroupb-0.1.0.5-jar-with-dependencies.jar"]