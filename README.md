
# GLI HIRING

This project is test hiring from Global Loyalty Indonesia.

**Apllication.properties**
```
server.port=8085

spring.datasource.url=jdbc:h2:mem:DB;DB_CLOSE_DELAY=-1;
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.platform=h2

spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect

spring.main.allow-bean-definition-overriding=true

spring.main.banner-mode=off

app.token=12345678
app.dogsbreeds.url=https://dog.ceo/api

spring.mvc.pathmatch.matching-strategy=ant_path_matcher

# Redis Config
spring.cache.type=redis
spring.redis.host=localhost
spring.redis.port=6379
spring.cache.type=redis
spring.cache.cache-names=country
spring.cache.redis.time-to-live=60000
spring.cache.redis.host=192.168.0.101
spring.cache.redis.port=6379
```

**Run this application**
- Terminal
```
mvn clean spring-boot:run
```
- Open in your browser
```
http://localhost:8085/
```
- Swagger UI
```
http://localhost:8085/swagger-ui/#/
```
