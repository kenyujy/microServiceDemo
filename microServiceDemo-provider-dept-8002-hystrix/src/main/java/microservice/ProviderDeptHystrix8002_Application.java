package microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient   //表明这个是 eureka client
//@EnableDiscoveryClient
@EnableCircuitBreaker //开启熔断机制
@EnableHystrix
public class ProviderDeptHystrix8002_Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDeptHystrix8002_Application.class, args);
    }
}
