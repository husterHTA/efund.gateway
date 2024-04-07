FROM maven:3.8.3-jdk-11-slim AS MAVEN_BUILD
MAINTAINER Anhht
COPY out/pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/efund-gateway-0.0.1.jar /app/efund-gateway-0.0.1.jar
#COPY config /app/

#EXPOSE 9004

#ENTRYPOINT ["java", "-jar", "efund-gateway-0.0.1.jar" ,"--spring.config.location=./application.properties"]
ENTRYPOINT ["java", "-jar", "efund-gateway-0.0.1.jar" ]