# spring-cloud-ecoystem
Spring Cloud Ecoystem: Eureka, Gateway(Zuul) , Producer rest, Consumer client, Hystrix monitoring, Cicuit breaker.

 http://localhost:8079/producer/employee = Endpoint of Api gateway
 
 http://localhost:8092/employee = Endpoint of real service


# show the hystrix dashboard

Go to 'http://localhost:9903/hystrix' and paste de url of service configurate with actuator and hystrix 'http://localhost:8092/hystrix.stream' and click on 'monitor stream' button.
