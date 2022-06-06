Spring Cloud
---------------------------------------------------------
 
It gives you many different libraries for implementing micro services using Spring
--------------------------------------------------------------------------------------------
1) OpenFeign
 
   It is used to make REST calls.

   Steps to use OpenFeign

   I) Add dependency in pom.xml

   II) Create an interface with method matching signature of remote method

   III) Enable feign client

  --------------------------------------------------------------------------------------------

  We want to assign unique name to every microservice and use that name to refer that microservice.
  It is by using  

 2) Eureka : It service registry and discovery server.
             Every microservice registers itself with Eureka.
             Eureka server typically runs on port 8761

 ----------------------------------------------------------------------------------------------

 3) API gateway
     This is used to navigate calls to microservices.
     All calls are first made to api gateway and then api gateway will route call to repsective microservice.



 ---------------------------------------------------------------------------------------------------------
 4) Circuit breaker
 
 	Circuit breaker is used in microservices to handle failure of services.
 	It is implemented using a library given by spring cloud are known as resilience4j.
 	
 	
 5) Cloud config server
 
 It is a centralized application that manages all the application related properties.
 
 1]Run Eureka server- (8761)
2]Run config server- (8888)
3]Run zipkin server- (9411)
4]Run API gateway -(9090)
5]Run bussiness microservices.

@EnableEurekaClient --> It is a optional annotation