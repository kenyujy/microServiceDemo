package microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient  //注册和发现服务
@EnableHystrixDashboard  //监控仪表盘
public class ConsumerDept9001_Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept9001_Application.class, args);
    }
}
