package microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient   //表明这个是 eureka client
//@EnableDiscoveryClient
//@EnableCircuitBreaker //开启熔断机制
@EnableZuulProxy  //路由功能？
public class Zuul_9527_Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_Application.class, args);
    }
}
