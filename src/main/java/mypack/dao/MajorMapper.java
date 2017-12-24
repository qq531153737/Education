package mypack.dao;

import mypack.pojo.Major;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MajorMapper {
    @Select("select * from major where id = #{id}")
    Major findWithID(int id);
    @Update("update major set newStudent = newStudent+1 where id = #{id}")
    int autoIncreaseNewStudent(int id);
    @Update("update major set newClazz = newClazz+1 where id = #{id}")
    int autoIncreaseNewClazz(@Param("id")int id);
}
