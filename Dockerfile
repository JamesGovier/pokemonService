FROM openjdk:11
EXPOSE 8080
RUN mkdir -p /app/
ADD target/pokespear-0.0.1-SNAPSHOT.jar /app/pokespear.jar
ENTRYPOINT ["java","-jar", "/app/pokespear.jar"]