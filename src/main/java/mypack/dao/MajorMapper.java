package mypack.dao;

import mypack.pojo.Major;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MajorMapper {
    @Select("select * from major where id = #{id}")
    Major findWithID(int id);
    @Update("update major set newStudent = newStudent+1 where id = #{id}")
    int autoIncreaseNewStudent(int id);
    @Update("update clazz set newClazz = newClazz+1 where id = #{id}")
    int autoIncreaseNewClazz(int id);
}
