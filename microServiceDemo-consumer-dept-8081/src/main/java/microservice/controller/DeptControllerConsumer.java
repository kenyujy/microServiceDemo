package microservice.controller;

import microservice.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptControllerConsumer {

    private static final String REST_PROVIDER_URL_PREFIX="http://MICRO-SERVICE-DEPT-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/consumer/dept/add")  //此处要用Get 浏览器地址栏才能添加成功
    public boolean add(Dept dept){       //传入的参数是Dept 实例
        return restTemplate.postForObject(REST_PROVIDER_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @GetMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){
        return restTemplate.getForObject(REST_PROVIDER_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    @GetMapping(value="/consumer/dept/list")
    public List<Dept> list(){

        return restTemplate.getForObject(REST_PROVIDER_URL_PREFIX+"/dept/list", List.class);
    }

    @GetMapping(value="/consumer/dept/find")
    public List<Dept> findDept(@RequestParam(value="name",required=false) String name,
                               @RequestParam(value="location",required=false) String location){

        String str="?1=1";
        if (null!=name && ""!=name){
            str+="&name="+name;
        }
        if (null!=location && ""!=location){
            str+="&location="+location;
        }


        Dept dept= new Dept();
        if (null!=name && ""!=name)
            dept.setName(name);
        if (null!=location && ""!=location)
            dept.setLocation(location);

        System.out.println(dept);

        return restTemplate.postForObject(REST_PROVIDER_URL_PREFIX+"/dept/find", dept, List.class);
        // get template 传入 Dept实例????????
    }
}
