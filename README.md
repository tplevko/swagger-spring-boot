# Swagger + SpringFox + SpringBoot example

This is a simple example to demonstrate Swagger with Spring Boot.  The integration
is handled by SpringFox, a 3rd party library for enabling Swagger on Spring MVC projects.

For more information on SpringFox, pleas visit [http://springfox.io](http://springfox.io)

## Building

This project requires Java 7 or greater.

To build:

```
mvn clean package
```

This produces an exectuable jar in the `target` folder.

To run:

```
java -jar target/swagger-spring-boot-sample-1.0.0-SNAPSHOT.jar
```

on Java 9: 
java  --add-modules java.xml.bind -jar target/swagger-spring-boot-sample-1.0.0-SNAPSHOT.jar

To create image in oc:

```
mvn package -P image
```

To create a docker image in dockerhub:
```
docker image build build/ -t syndesisqe/swagger-spring-boot
docker push syndesisqe/swagger-spring-boot
```
