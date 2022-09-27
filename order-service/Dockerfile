FROM maven:3-amazoncorretto-17 AS maven_build

COPY pom.xml /tmp/

COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn package

FROM openjdk

EXPOSE 9090

CMD java -jar /data/order-service-0.0.1-SNAPSHOT.jar

COPY --from=maven_build /tmp/target/order-service-0.0.1-SNAPSHOT.jar /data/order-service-0.0.1-SNAPSHOT.jar
