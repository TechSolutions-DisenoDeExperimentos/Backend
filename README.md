# Dependencies

1) mvn@3.9.6

# Maven Build

## Clean 

``` bash
mvn clean
```

## Build 

``` bash
mvn package -D"maven.test.skip"
```

- Export path: "/target/TuCine-0.0.1-SNAPSHOT.jar"

## Tests

``` bash
mvn test
```

## Run

``` bash
java -jar ./target/TuCine-0.0.1-SNAPSHOT.jar
```

# Docker Build

## Build 

``` bash
docker build . -t spring-backend
```

## Run

``` bash
docker run -d -p 9090:9090 spring-backend
```

# Jacoco Report

## Tests Report

``` bash
mvn test
```

- Export paths: "./target/surefire-reports/TEST-**.xml"

## Report

``` bash
mvn jacoco:report
```

- Export path: "./target/site/jacoco/jacoco.xml"

# Sonar

## Deploy sonar admin local server

``` bash
StartSonar
```

## Run/Buid spring project

[Maven Runtime](#maven-build)

## Generate jacoco report

[Jacoco Report](#jacoco-report)

## Configuration

``` bash
sonar.host.url=http://localhost:9000
sonar.login=xxx
sonar.projectKey=com.upc.TuCine:TuCine

sonar.sourceEncoding=UTF-8
sonar.language=java
sonar.java.source=11

sonar.branch.name=local

sonar.sources=src/main/java
sonar.test=src/test
sonar.java.binaries=target/classes
sonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
sonar.coverage.exclusions=**/*Exception.java,**/MySpringBootApplication.java,**/.DS_STORE
sonar.junit.reportPath=target/surefire-reports/TEST-**.xml
```

## Run sonar goal

``` bash
mvn sonar:sonar
```

## Jenkins 

- Configure jenkinsfile

