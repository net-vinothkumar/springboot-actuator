# springboot-actuator
A sample spring boot actuator application

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




