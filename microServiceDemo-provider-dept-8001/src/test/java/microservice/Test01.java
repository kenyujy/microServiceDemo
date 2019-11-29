package microservice;


import microservice.entities.Dept;
import microservice.entities.DeptWithOrg;
import microservice.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RunWith(SpringRunner.class)  //这2个很重要， 否则IOC 容器没有对应的Bean, 报空指针异常
@SpringBootTest
public class Test01 {

    @Autowired
    DeptService deptService;

    @Test
    public void testDynamicSql(){
        //Dept dept=new Dept();
        //dept.setName("部");
        //dept.setLocation("圳");

        //List<Dept> list= deptService.findByName("市");
        //System.out.println(list);

        //List<Dept> list= deptService.findDept(dept);
        String str="  市场  开发 ";
        String[] array= str.split(" ");
        List<String> stringList=new ArrayList<>();
        for (String s: array) {
            s=s.trim();
            if (!s.equals("")) {  //不是空字符串才加
                s = "%" + s + "%";
                stringList.add(s);
            }
        }

        System.out.println(stringList);

        //List<Dept> list= deptService.findDeptByMultiString(stringList);
        //System.out.println(list);
        //String db_source="source_03";
        //deptService.updateDeptWithMaxLocation(db_source);

        /*
        List<Dept> deptList= deptService.findLocationWithMore2Dept();
        for(Dept department: deptList){
            System.out.println(department);
        }
         */
    }

    @Test
    public void test01(){
        Dept dept=deptService.findById(1);
        System.out.println(dept);
    }

    @Test
    public void test02(){
        List<Dept> list= deptService.findAll();
        System.out.println(list);
    }

    @Test
    public void test03(){
        List<DeptWithOrg> list= deptService.findDeptOrgResult();
        System.out.println(list);
    }

    @Test
    public void test04(){
        Long l= deptService.updateDeptHqName("深圳");
        System.out.println(l);
    }
}
