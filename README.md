# springboot-actuator
"Production Ready Endpoints To Monitor Your Application"

<img width="1146" alt="Screen Shot 2019-07-25 at 07 10 57" src="https://user-images.githubusercontent.com/30971809/61847600-8d03fc00-aeab-11e9-836b-32f60c78e6c9.png">

# What is Spring Boot Actuator ?
Spring Boot provides actuator to monitor and manage our application. Actuator is a tool which has HTTP endpoints. when application is pushed to production, you can choose to manage and monitor your application using HTTP endpoints.

# How to enable Actuator in Spring Boot Application ?

To get production-ready features, we should use spring-boot-actuator module. We can enable this feature by adding it to the pom.xml file.

```
<dependencies>  
    <dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-actuator</artifactId>  
    </dependency>  
</dependencies>  
```

# Actuator Endpoints:

Actuator endpoints allow us to monitor and interact with our Spring Boot application. Spring Boot includes number of built-in endpoints and we can also add custom.

The following table contains the available endpoints.

<img width="1163" alt="Screen Shot 2019-07-23 at 06 12 42" src="https://user-images.githubusercontent.com/30971809/61682192-f56aa600-ad10-11e9-807f-3512a1a6d906.png">

# How to enable / disable Spring Boot Actuator endpoints ?
By default, all endpoints except for shutdown are enabled. To configure the enablement of an endpoint, use its management.endpoint.<id>.enabled property. The following example enables the shutdown endpoint:

```
management.endpoint.shutdown.enabled=true    
```
If you prefer endpoint enablement to be opt-in rather than opt-out, set the management.endpoints.enabled-by-default property to false and use individual endpoint enabled properties to opt back in. The following example enables the info endpoint and disables all other endpoints:

```
management.endpoints.enabled-by-default=false
management.endpoint.info.enabled=true
```

Actually the spring boot application endpoints may provide sensitive information, so careful consideration should be given before enabling it.

```
management.endpoint.health.show-details=always or never
info.app.java.source=11
info.app.java.target=11
info.app.encoding=UTF-8
info.name.of.app=Actuator Demo Application

management.endpoint.<id>.enabled => can be used to enable/disable the feature
management.endpoint.enable-by-default=false

management.endpoint.web.exposure.include=health,info
management.endpoint.web.exposure.include=* (also)
management.endpoint.web.exposure.exclude=beans,metrics
```

# Why Spring Boot Actuator ? Its Benefits ?

1. It allows us to monitor our application
2. To gather the application’s metrics
3. Understand the real traffic
4. We can get the production grade tools via the HTTP end points and get the application metrics.
5. we are also free to configure and extend these features in many ways.
6. Easy to implement the custom metrics for an application and expose as an HTTP endpoints.
7. The actuator endpoints are secured, hence application's sensitive information are protected.

more details : 
https://docs.spring.io/spring-boot/docs/2.2.0.BUILD-SNAPSHOT/reference/html/production-ready-features.html
https://dzone.com/articles/spring-boot-autoscaler
http://www.codebelay.com/blog/2009/08/02/how-to-load-balance-and-auto-scale-with-amazons-ec2/

# How to write custom endpoints ?

Spring also provides adding custom endpoints if you have any application specific feature that you want to exapose and monitor. Just add a @Bean annotated with @Endpoint, In this class any methods annotated with @ReadOperation, @WriteOperation, or @DeleteOperation are automatically exposed over JMX and, in a web application, over HTTP as well. Endpoints can be exposed over HTTP using Jersey, Spring MVC, or Spring WebFlux.

```
@Component
@Endpoint(id = "customFeatures")
public class CustomFeatureEndpoint {

    private Map<String, Object> features = new ConcurrentHashMap<>();

    @ReadOperation
    public Map<String, Object> customFeatues(){
        features.put("customFeature", "example - customer bought the product using premium account.");
        return features;
    }
}
```

# Using a different management port for actuator : 

http://localhost:9000/actuator/health

```
management.server.port=9000
```
