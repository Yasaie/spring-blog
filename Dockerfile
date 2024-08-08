# # Use an official Maven image as the base image
FROM maven:latest

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src

# Build the application using Maven
RUN mvn clean verify -DskipTests

# Set the command to run the application
ENTRYPOINT ["mvn", "spring-boot:run"]
