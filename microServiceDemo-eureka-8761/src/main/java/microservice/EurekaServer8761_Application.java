package microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //标注这个包是 Eureka Server 启动类
public class EurekaServer8761_Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer8761_Application.class, args);
    }
}
