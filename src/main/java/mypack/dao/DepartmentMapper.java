package mypack.dao;

import mypack.pojo.Department;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    Department findWithID(int id);
    @Select("select * from department where name = #{name}")
    Department findWithName(String name);
    @Update("update department set newProfessor = newProfessor+1 where id = #{id}")
    int autoIncreaseNewProfessor(int id);
    @Update("update department set newCourse = newCourse+1 where id = #{id}")
    int autoIncreaseNewCourse(int id);
}
