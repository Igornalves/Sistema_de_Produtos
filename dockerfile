FROM openjdk:21

WORKDIR /app

COPY ./target/sistema_produtos-0.0.1-SNAPSHOT.jar /app/sistema_produtos.jar

EXPOSE 3000:8080

ENTRYPOINT ["java", "-jar", "/app/sistema_produtos.jar"]