FROM eclipse-temurin:19.0.2_7-jre-focal
ADD target/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]