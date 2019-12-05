package microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient  //注册和发现服务
@EnableFeignClients(basePackages = {"microservice"})
public class ConsumerDept8082_Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept8082_Application.class, args);
    }
}
