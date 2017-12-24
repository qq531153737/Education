package mypack.dao;

import mypack.Response.ClazzInfo;
import mypack.pojo.Clazz;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface ClazzMapper {
    @Select("select * from clazz where id = #{id}")
    public Clazz findWithID(@Param("id")long id);
    @Select("select clazz.*, department.name as depName, professor.name as proName\n" +
            "from clazz, major, professor,department\n" +
            "where clazz.majID = major.id and major.depID=department.id and clazz.proID = professor.id and clazz.year = #{year} and (major.id div 100) = #{depId}\n")
    ArrayList<ClazzInfo> queryClazz(@Param("depId")int depId, @Param("year")int year);
    @Update("update clazz set quantity = quantity+1 where id = #{id}")
    int autoIncreaseQuantity(long id);
    @Insert("insert into clazz(id, name, quantity, majID, year, proID) " +
            "values (#{id},#{name},0,#{majID},#{year},#{proID})")
    boolean addClazz(@Param("id")long id, @Param("name")String name, @Param("majID")int majID, @Param("year")int year, @Param("proID")long proID);

    @Delete("delete from clazz where id = #{id}")
    boolean deleteClazz(@Param("id")long id);

    @Select("select distinct department.name as depName, clazz.name as name, clazz.year as year\n" +
            "from department, clazz, takes, student\n" +
            "where takes.stuID=student.id and student.claID=clazz.id and (clazz.majID div 100)=department.id and takes.couID=#{couID}\n")
    ArrayList<ClazzInfo> queryClazzOfCourse(@Param("couID")long couID);
}


