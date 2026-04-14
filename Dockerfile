# Base image olarak Java 17 kullanıyoruz
FROM eclipse-temurin:17-jdk-alpine

# Container içinde çalışacağımız dizin
WORKDIR /app

# Maven tarafından oluşturulan JAR dosyasını container'a kopyalıyoruz
COPY target/cicd-0.0.1-SNAPSHOT.jar app.jar

# Uygulamanın çalışacağı port (Spring Boot varsayılan: 8080)
EXPOSE 8080

# Container başlatıldığında çalıştırılacak komut
ENTRYPOINT ["java", "-jar", "app.jar"]
