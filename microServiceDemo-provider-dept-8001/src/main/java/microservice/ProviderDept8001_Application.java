package microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //表明这个是 eureka client
//@EnableDiscoveryClient
public class ProviderDept8001_Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDept8001_Application.class, args);
    }
}
