package microservice.service;

import microservice.entities.Dept;
import microservice.entities.DeptWithOrg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="MICRO-SERVICE-DEPT-PROVIDER") //要访问微服务的名字
public interface DeptClientService {

    @RequestMapping(value="/dept/add", method= RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept);

    @RequestMapping(value="/dept/list", method= RequestMethod.GET)
    public List<Dept> findAll();

    @RequestMapping(value="/dept/get/{id}", method= RequestMethod.GET)
    public Dept findById(@PathVariable("id") long id);

    @RequestMapping(value="/dept/find/{name}", method= RequestMethod.GET)
    public List<Dept> findByName(@PathVariable("name") String name);

    @RequestMapping(value="/dept/find", method= RequestMethod.POST)
    public List<Dept> findDept(@RequestBody Dept dept);  // 参数不用@RequestBody 才行

}
