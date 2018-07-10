# Referral

#### How to develop
1. Always create a Feature branch from _DEVELOPMENT_ branch. Name can be logical one.
2. Frequent commits is good. A good commit message is less than 70 Characters
3. Finish your work on the Feature branch and create a PR.
4. A little brief in the PR is always good.

We would like to use this Git Flow (https://nvie.com/posts/a-successful-git-branching-model/)

#### Structure of the project
This project is a Maven multi-module project built with profiles to ease the buid and deployment of the artifacts per environment. For better classification and segregation, various components of the application has been packaged into Maven Modules. The structure is as below:
#### referral-services-api
- referral-services-controller
- referral-services-service
- referral-services-persistence
- referral-services-model
- referral-services-dto

#### API Documentation
The API Documentation has been done using Swagger and is available at http://IP:PORT/referral-services-api/swagger-ui.html

#### Database Stats
The database query stats are collected using Druid. The stats are available on http://IP:PORT/referral-services-api/druid/login.html.
User : druid, Password: druid

#### Application Metrics
Using Spring Boot 2.X Actuator some(loggers, health, info) application metrics have been enabled. The logger metric can also be used to change the level of logs without restarting the application. The below POST request will help to the logging level of our API.
``` 
    curl 'http://IP:PORT/referral-services-api/actuator/loggers/com.referral' -i
    -X POST \
    -H 'Content-Type: application/json' \
    -d '{"configuredLevel":"debug"}'
```
The enabled actuators can be seen on http://IP:PORT/referral-services-api/actuator



