FROM adoptopenjdk:16-jre-hotspot
ADD target/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]