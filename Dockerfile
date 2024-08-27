FROM amazoncorretto:17.0.7-alpine
EXPOSE 8081
ADD target/springboot-jenkins.jar springboot-jenkins.jar
ENTRYPOINT ["java", "-jar", "/springboot-jenkins.jar"]