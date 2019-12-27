FROM java:8
FROM maven:alpine
WORKDIR /app
COPY . /app
EXPOSE 8080
ADD ./target/cupom-da-vida-0.0.1-SNAPSHOT.jar cupom-da-vida-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","cupom-da-vida-0.0.1-SNAPSHOT.jar"]