FROM openjdk:8-jdk-alpine

WORKDIR ./

COPY * ./

RUN mvn clean build

ADD ./target/helloworld-0.0.1-SNAPSHOT.jar helloworld-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD java -jar helloworld-0.0.1-SNAPSHOT.jar
