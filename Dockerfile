FROM eclipse-temurin:18.0.2.1_1-jre-focal
ADD target/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]