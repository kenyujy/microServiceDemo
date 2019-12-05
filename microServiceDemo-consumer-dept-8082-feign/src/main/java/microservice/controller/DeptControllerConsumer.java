package microservice.controller;

import microservice.entities.Dept;
import microservice.entities.DeptWithOrg;
import microservice.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptControllerConsumer {

    @Autowired
    DeptClientService deptClientService;

    @GetMapping(value="/consumer/dept/add")  //此处要用Get 浏览器地址栏才能添加成功
    public boolean add(Dept dept){       //传入的参数是Dept 实例
        return deptClientService.addDept(dept);
    }

    @GetMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){
        return deptClientService.findById(id);
    }

    @GetMapping(value="/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.findAll();
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

        return deptClientService.findDept(dept);
        // get template 传入 Dept实例????????
    }
}
