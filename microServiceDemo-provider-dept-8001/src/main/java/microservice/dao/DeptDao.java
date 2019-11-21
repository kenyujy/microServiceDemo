package microservice.dao;

import microservice.entities.Dept;
import microservice.entities.DeptWithOrg;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Mapper
@Component
public interface DeptDao {

    @Insert("insert into dept (name, location, db_source) values (#{name}, #{location}, database())")
    boolean addDept(Dept dept);

    @Select("SELECT * FROM dept WHERE id= #{id}")
    @Results({   //result map, 查询结果column 映射到对象的属性
            @Result(id=true, column="id", property="id"),
            @Result(column="name", property="name"),
            @Result(column="location", property="location"),
            @Result(column="organization_id", property="organizationId"),
            @Result(column="db_source", property="dbSource")
    })
    Dept findById(long id);

    @Select({"<script>",
            "<bind name='pattern' value=\"'%'+name+'%'\" />",
            "select * from dept where name like #{pattern}", //这里拼串只能用${}
            "</script>"})
    List<Dept> findByName(@Param("name") String name);

    //@Select("select * from dept")
    List<Dept> findAll();


    @Select({"<script>",
            "select * from dept where 1=1 ",
            "<bind name='pattern' value=\"'%'+dept.name+'%'\" />",   //这里要注意啊！！！
            "<if test='dept.name != null'> and name like #{pattern} </if>",    //这里拼串只能用${}
            "<if test='dept.location != null'> and location= #{dept.location} </if>", //可以取出，没问题
            "</script>"})
    List<Dept> findDept(@Param("dept") Dept dept);

    //接受一个String List参数，并按where like查询
    /*
    @Select({"<script>",
            "select * from dept where 1=1 ",
            //用open ，separator =and name like 构建查询字符串, collection赋值要用传入的
            "<foreach item=\"item\" index=\"index\" collection=\"queryList\" open=\" and name like \" " +
                    "separator=\" and name like \" close=\"\">#{item}</foreach>",
            "</script>"})
     */
    List<Dept> findDeptByMultiString(@Param("queryList") List<String> queryList);


    @Select({"<script>",
            "SELECT * FROM dept WHERE location IN ",
            " (SELECT location FROM dept AS locations GROUP BY location HAVING count(*)>1)",
            " ORDER BY location DESC, id ASC",
            "</script>"})
    List<Dept> findLocationWithMore2Dept();


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
    boolean updateDeptWithMaxLocation(@Param("db_source") String db_source);

    List<DeptWithOrg> findDeptOrgResult();
}
