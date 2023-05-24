FROM openjdk:21-ea-17-jdk
VOLUME /tmp
EXPOSE 8080
ADD ./target/lab6_sol-0.0.1-SNAPSHOT.jar lab6.jar
ENTRYPOINT ["java","-jar","lab6.jar"]
