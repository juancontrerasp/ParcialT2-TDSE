FROM openjdk:21-jdk-slim
COPY target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

 docker build -t my-app .

docker run -d -p 8080:8080 my-app
