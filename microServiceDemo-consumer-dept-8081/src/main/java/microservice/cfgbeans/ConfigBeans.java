package microservice.cfgbeans;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBeans {

    @Bean  //发Rest请求用
    @LoadBalanced  //开启负载均衡
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }

    // 配置Robin 负载均衡算法，覆盖掉默认的轮询算法
    //@Bean
    //public IRule myRule(){
    //    return new BestAvailableRule();
    //}
}
