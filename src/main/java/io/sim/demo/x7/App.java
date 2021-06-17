package io.sim.demo.x7;


import io.xream.x7.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@EnableReadOnly
@EnableX7L2Caching(timeSeconds = 300)
@EnableX7Repository(mappingPrefix = "t_",mappingSpec = "_")
@EnableReyClient
@EnableTracingServlet
@EnableDateToLongForJackson
@EnableDistributionLock
@EnableFallbackOnly
@EnableCorsConfig("${access.domain}")
@EnableRateLimiter
public class App {

    public static void main( String[] args )
    {
    	SpringApplication.run(App.class);
    }

}