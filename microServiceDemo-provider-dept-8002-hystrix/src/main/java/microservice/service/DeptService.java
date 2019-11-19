package microservice.service;

import microservice.dao.DeptDao;
import microservice.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    DeptDao deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept findById(long id) {
        return deptDao.findById(id);
    }

    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    public List<Dept> findByName(String name){
        return deptDao.findByName(name);
    }

    public List<Dept> findDept(Dept dept){

        return deptDao.findDept(dept);
    }

    public List<Dept> findLocationWithMore2Dept(){
        return deptDao.findLocationWithMore2Dept();
    }

    public boolean updateDeptWithMaxLocation(String db_source){
        return deptDao.updateDeptWithMaxLocation(db_source);
    }
}
