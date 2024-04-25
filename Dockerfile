# D:\javaProjects\microservices\inventoryservice\Dockerfile
FROM openjdk:17
COPY ./target/inventoryservice-0.0.1-SNAPSHOT.jar /app/inventoryservice.jar
CMD ["java", "-jar", "/app/inventoryservice.jar"]