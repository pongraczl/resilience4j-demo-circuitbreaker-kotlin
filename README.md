# Resilience4j CircuitBreaker Demo - Kotlin 

A Spring Boot demo application demonstrating the work of Resilience4j CircuitBreaker.

## What does it do?
A "client service" calls a fake "remote service" that responds with success (once of three) or failure. The client service resolves this situation using a circuit breaker design pattern (with Resilience4j annotations).

## What is a CircuitBreaker?
It is a design pattern that encapsulates the logic of detecting a recurring error (typically an external system failure), and of reducing its impact on the application, or at least handling it more gracefully.

*See also:*
 - https://resilience4j.readme.io/docs/circuitbreaker
 - https://martinfowler.com/bliki/CircuitBreaker.html
 - https://en.wikipedia.org/wiki/Circuit_breaker_design_pattern

## Usage
 - Start the standalone Spring Boot application with the entry point of: com.github.pongraczl.exercises.resilience4jdemo2.Resilience4jDemo2Application
 - Call the following URL (for e.g., in a browser): http://localhost:8081/ManyFailing2in3ResponseClientController

## CircuitBreaker settings

### Settings used

*See*: [src/main/resources/application.yml](https://github.com/pongraczl/resilience4j-demo-circuitbreaker-kotlin/blob/master/src/main/resources/application.yml)
 - ***minimumNumberOfCalls***: the minimum number of calls below which the circuit breaker will not operate
 - ***slidingWindowSize***: the number of calls used to examine the outcomes
- ***failureRateThreshold***: the rate of calls from which the CircuitBreaker transitions to open state and start short-circuiting calls
 - ***waitDurationInOpenState***: time that the CircuitBreaker should wait before it allows calls again (in half-open state)
 
### Other possible settings
*See*: https://resilience4j.readme.io/docs/circuitbreaker#create-and-configure-a-circuitbreaker

## More on Resilience4j with Spring Boot

 - https://resilience4j.readme.io/docs/getting-started-3
 - https://github.com/resilience4j/resilience4j-spring-boot2-demo
   - Using annotations: [BackendAService](https://github.com/resilience4j/resilience4j-spring-boot2-demo/blob/master/src/main/java/io/github/robwin/service/BackendAService.java)
   - Using functional style and Spring Reactor operators: [BackendBService](https://github.com/resilience4j/resilience4j-spring-boot2-demo/blob/master/src/main/java/io/github/robwin/service/BackendBService.java)
 - https://www.baeldung.com/resilience4j

