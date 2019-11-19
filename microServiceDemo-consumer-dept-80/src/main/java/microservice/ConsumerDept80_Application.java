package microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //注册和发现服务
public class ConsumerDept80_Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept80_Application.class, args);
    }
}
