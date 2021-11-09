FROM openjdk:11.0.12-jdk-oracle
COPY target/spring-cloud-gateway-security-0.0.1-SNAPSHOT.jar spring-cloud-gateway-security-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/spring-cloud-gateway-security-0.0.1-SNAPSHOT.jar"]