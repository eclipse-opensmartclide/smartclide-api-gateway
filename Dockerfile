FROM eclipse-temurin:17.0.6_10-jre-focal
ADD target/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]