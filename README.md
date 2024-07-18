# cba_api_framework
# Overview
This is a java and [rest-assured](https://rest-assured.io/) based test automation framework for the testing of web api's/microservices.
The build tool is [Maven](https://maven.apache.org/) and the [testng](https://testng.org/doc/) test automation framework is used for specifying, arranging and running the tests.
[Allure](https://docs.qameta.io/allure/) reporting is used to give a detailed overview of test result including steps with attached cURLs and response/request payloads.
This project helps test all GET, POST, PUT and DELETE API calls for teh Swagger Petstore API.

## Prerequisites
1. Java 8 or higher
2. Maven 3.6 or higher
3. An IDE such as IntelliJ or Eclipse

## Setup

## Clone the repository
``````
git clone https://github.com/goelabhinav/cba_api_framework.git
``````
## Add Dependecies
````
    <dependencies>
        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.5.0</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.10.2</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-testng</artifactId>
            <version>2.28.0</version>
        </dependency>

    </dependencies>

````
## Add Plugins
````
    <build>

        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>

            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
                <configuration>
                    <argLine>
                        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/1.9.22.1/aspectjweaver-1.9.22.1.jar"
                    </argLine>
                </configuration>

                <dependencies>
                    <dependency>
                        <groupId>org.aspectj</groupId>
                        <artifactId>aspectjweaver</artifactId>
                        <version>1.9.22.1</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>
````

## Running Tests
You can run your tests using intelliJ straight away.
Or you can run with maven and view the Allure report.
```
mvn clean test
```
If you want to view the Allure report after:

Download allure from github https://github.com/allure-framework/allure2/releases

Copy the allure bin path where you have placed the allure unzipped file. In my case, it’s “D:\Allure\allure-2.17.3\allure-2.17.3\bin”. Select the “PATH” variable from system variables and click on Edit. Click on New in edit environment variables and paste the copied allure bin path. Save the settings.

RUN THE ALLURE REPORTS:
```
allure serve allure-results
```
This will fire up the allure server and open the results in your default browser.

This README provides a comprehensive guide to setting up and using the RestAssured API testing framework.
