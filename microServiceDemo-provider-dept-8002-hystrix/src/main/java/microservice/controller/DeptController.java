package microservice.controller;


import microservice.entities.Dept;
import microservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value="/dept/add", method= RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept){   // @RequestBody 请求消息体的数据类型
        return deptService.addDept(dept);
    }

    @RequestMapping(value="/dept/list", method= RequestMethod.GET)
    public List<Dept> findAll(){
        return deptService.findAll();
    }

    @RequestMapping(value="/dept/get/{id}", method= RequestMethod.GET)
    public Dept findById(@PathVariable("id") long id){
        return deptService.findById(id);
    }

    @RequestMapping(value="/dept/find/{name}", method= RequestMethod.GET)
    public List<Dept> findByName(@PathVariable("name") String name){
        return deptService.findByName(name);
    }

    @RequestMapping(value="/dept/find", method= RequestMethod.GET)
    public List<Dept> findDept(Dept dept){   // 参数不用@RequestBody 才行

        return deptService.findDept(dept);
    }

    /*
    @RequestMapping(value="/dept/find", method= RequestMethod.GET)
    public List<Dept> findDept(@RequestBody Dept dept){
        return deptService.findDept(dept);
    }

    /*
    @RequestMapping(value="/dept/discovery", method=RequestMethod.GET)
    public Object discovery(){
        List<String> list= discoveryClient.getServices();
        System.out.println("*********"+list);

        List<ServiceInstance> servList= discoveryClient.getInstances("micro-service-dept-provider-8001");
        for (ServiceInstance element: servList){
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return this.discoveryClient;
    }
    */
}