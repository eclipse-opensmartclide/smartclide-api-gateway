FROM adoptopenjdk:11-jre-hotspot
ADD target/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]