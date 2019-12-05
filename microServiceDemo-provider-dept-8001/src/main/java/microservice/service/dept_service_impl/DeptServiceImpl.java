package microservice.service.dept_service_impl;

import microservice.entities.Dept;
import microservice.entities.DeptWithOrg;
import microservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptService deptService;

    @Override
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @Override
    public Dept findById(long id) {
        return deptService.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    @Override
    public List<Dept> findByName(String name){
        return deptService.findByName(name);
    }

    @Override
    public List<Dept> findDept(Dept dept){

        return deptService.findDept(dept);
    }

    //接受一个String数组参数，并按where like查询
    @Override
    public List<Dept> findDeptByMultiString(List<String> queryList){
        return deptService.findDeptByMultiString(queryList);
    }

    @Override
    public List<Dept> findLocationWithMore2Dept(){
        return deptService.findLocationWithMore2Dept();
    }

    @Override
    public boolean updateDeptWithMaxLocation(String db_source){
        return deptService.updateDeptWithMaxLocation(db_source);
    }

    @Override
    public List<DeptWithOrg> findDeptOrgResult(){
        return deptService.findDeptOrgResult();
    }

    @Override
    public long updateDeptHqName(String dept_name){
        return deptService.updateDeptHqName(dept_name);
    }
}
