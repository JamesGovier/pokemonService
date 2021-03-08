# Pokemon Service
A service designed to get details about a given pokemon name  
See swagger/swagger.yaml to see end point interface

## Pre requisite software
Maven : https://maven.apache.org/install.html  
Java 11 : https://www.oracle.com/uk/java/technologies/javase-jdk11-downloads.html  
Lokmbok plugin for your IDE : Intelij https://plugins.jetbrains.com/plugin/6317-lombok or Eclipse
https://www.baeldung.com/lombok-ide  
Docker : https://docs.docker.com/get-docker/

## How to Run 
1) Clone Repo
2) Using Maven run "mvn clean install"  
2.1) Note : will run tests too to confirm build works
3) DockerFile can now be run using docker commands
4) Once application has started (using IDE or docker) hit endpoint for responses

## Areas could improve with more time 
* Currently, the Remote end points use synchronous methods, 
this could be changed to async if more data could be needed.
* If some of these remote end points are going to be reused in other services they could be extracted
 into their own services and Pokemon Service could call them.  
* Currently, Fun Translations has a 5 request / hr limit this handle by returning an error message to the endpoint 
we could however cache results to limit calls or just pay for premium
* Better validation of the pokemon name, 
currently regardless of what is sent to the end point we forward the request onto PokeApi

## Additional features that could be improved upon
* Add the ability to search by ID as that's currently supported by PokeApi.
* Ability to return more than one description, currently we just get the first English description.
* Better filtering / search criteria for pokemon descriptions