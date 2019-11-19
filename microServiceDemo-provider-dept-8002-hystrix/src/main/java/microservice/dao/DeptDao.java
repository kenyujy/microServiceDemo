package microservice.dao;

import microservice.entities.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Mapper
@Component
public interface DeptDao {

    @Insert("insert into dept (name, location, db_source) values (#{name}, #{location}, database())")
    public boolean addDept(Dept dept);

    @Select("select * from dept where id= #{id}")
    public Dept findById(long id);

    @Select("select * from dept where name like '%${name}%'")  //这里拼串只能用${}
    public List<Dept> findByName(@Param("name") String name);

    @Select("select * from dept")
    public List<Dept> findAll();


    @Select({"<script>",
            "select * from dept where 1=1 ",
            "<if test='dept.name != null'> and name like '%${dept.name}%' </if>",    //这里拼串只能用${}
            "<if test='dept.location != null'> and location= #{dept.location} </if>", //可以取出，没问题
            "</script>"})
    public List<Dept> findDept(@Param("dept") Dept dept);

    @Select({"<script>",
            "SELECT * FROM dept WHERE location IN ",
            " (SELECT location FROM dept AS locations GROUP BY location HAVING count(*)>1)",
            " ORDER BY location DESC, id ASC",
            "</script>"})
    public List<Dept> findLocationWithMore2Dept();


    @Update({"<script>",       //update db_source of depts which have the max location count
            "update dept ",
            " <set>",
            " db_source = #{db_source},",
            " </set>",
            " where location in " +
                    "(select location from " +
                    "(select location from dept as locations " +
                    "group by location order by count(*) desc limit 0,1) as locations2)",
            "</script>"})
    public boolean updateDeptWithMaxLocation(@Param("db_source") String db_source);

}
