# Swagger + SpringFox + SpringBoot example

This is a simple example to demonstrate Swagger with Spring Boot.  The integration
is handled by SpringFox, a 3rd party library for enabling Swagger on Spring MVC projects.

For more information on SpringFox, pleas visit [http://springfox.io](http://springfox.io)

## Building and running localy

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

On Java 9:
```
java  --add-modules java.xml.bind -jar target/swagger-spring-boot-sample-1.0.0-SNAPSHOT.jar
```

## Run app in OpenShift:

You can create the image on your OpenShift using the s2i build:

```
mvn package -P image
```
Alternatively you can just pull a docker image from dockerhub to your OS instance using:

```
docker pull syndesisqe/swagger-spring-boot
```

To start the application on OpenShift:
```
oc new-app syndesisqe/swagger-spring-boot
```

Create a route to this application, to expose it, and you can then find the swagger.json on : "${URL}/v2/swagger.json"

## Pushing to dockerhub

To create a docker image in dockerhub, first run the s2i build and then:
```
docker image build build/ -t syndesisqe/swagger-spring-boot
docker push syndesisqe/swagger-spring-boot
```
