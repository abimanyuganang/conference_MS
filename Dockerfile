FROM eclipse-temurin:17-jdk-jammy

# Set the working directory 
WORKDIR /app

RUN apt-get update && apt-get install -y default-mysql-client && rm -rf /var/lib/apt/lists/*

# Jar
COPY target/conference-management-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-mysql.sh wait-for-mysql.sh

RUN chmod +x wait-for-mysql.sh

# Expose port
EXPOSE 8080

# Command to run the JAR
ENTRYPOINT ["./wait-for-mysql.sh", "mysql", "java", "-jar", "app.jar"]
