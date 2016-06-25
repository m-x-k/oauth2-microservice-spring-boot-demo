# Spring boot rest microservice with spring cloud security setup as resource server

The intention is to provide a spring boot microservice as an oauth resource server.
Calls to the sample greeting REST endpoint will require standard Bearer Token authorization header.

## Requires

OAuth2 server instance which can be configured in the application.yml file.

## Run

```
gradle clean build bootRun
```

## Test

```
gradle runTests
```

Note: Token value needs to be provided and the means to authenticate this can differ depending on the OAuth2 Authorization Server instance.

