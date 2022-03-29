package io.sim.demo.x7;


import io.xream.rey.EnableRateLimiter;
import io.xream.rey.EnableReyClient;
import io.xream.x7.EnableCorsConfig;
import io.xream.x7.EnableDateToLongForJackson;
import io.xream.x7.EnableX7L2Caching;
import io.xream.x7.EnableX7Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableX7L2Caching(timeSeconds = 300)
@EnableX7Repository(mappingPrefix = "t_",mappingSpec = "_")
@EnableReyClient
@EnableDateToLongForJackson
@EnableCorsConfig("${access.domain}")
@EnableRateLimiter
public class App {

    public static void main( String[] args ) {
    	SpringApplication.run(App.class);
    }

}