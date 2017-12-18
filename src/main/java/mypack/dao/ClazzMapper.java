package mypack.dao;

import mypack.pojo.Clazz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

public interface ClazzMapper {
    @Select("select * from clazz where id = #{id}")
    public Clazz findWithID(@Param("id")long id);
    @Select("select *\n" +
            "from clazz\n" +
            "where clazz.year=#{year} and clazz.majID in (\n" +
            "  SELECT major.id AS majId\n" +
            "  FROM major\n" +
            "  WHERE depID = #{depId}\n" +
            ")")
    ArrayList<Clazz> queryClazz(@Param("depId")int depId, @Param("year")int year);
    @Update("update clazz set quantity = quantity+1 where id = #{id}")
    int autoIncreaseQuantity(long id);
    @Insert("insert into clazz(id, name, quantity, majID, year, proID) " +
            "values (#{id},#{name},0,#{majID},#{year},#{proID}")
    boolean addClazz(@Param("id")long id, @Param("name")String name, @Param("majID")int majID, @Param("year")int year, @Param("proID")long proID);
}

