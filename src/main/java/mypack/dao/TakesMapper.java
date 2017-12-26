package mypack.dao;

import mypack.Response.ScoreInfo;
import mypack.Response.TakesInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

public interface TakesMapper {
    @Select({"<script> select cou.*,takes.grade as score,takes.ranking as ranking,takes.PerformancePoint as point,department.name as depName\n" +
            "from takes,department ,(SELECT * from course WHERE course.learnYear=#{learnYear} <when test='learnTerm!=0'>and course.learnTerm=#{learnTerm} </when> <when test='type!=0'>and course.type=#{type} </when>) as cou\n" +
            "where takes.couID=cou.id and cou.depID=department.id and takes.stuID=#{id}</script>"})
    ArrayList<ScoreInfo> getScoreList(@Param("id")long id, @Param("learnYear")String learnYear, @Param("learnTerm")int learnTerm, @Param("type")int type);

    @Select("update takes set grade=#{grade},completed=1 where couID=#{couID} and stuID=#{stuID}")
    void updateSingleScore(@Param("couID")long couID,@Param("stuID")long stuID,@Param("grade")float grade);

    @Select({"<script>select course.name as couName,student.id as stuID,student.name as stuName,takes.grade as grade \n" +
            "from takes,course,student\n" +
            "where takes.stuID=student.id and course.id=takes.couID <when test='id!=null'>and takes.couID=#{id} </when></script>"})
    ArrayList<TakesInfo> getCourseStudent(@Param("id")long id);

    @Insert("insert into takes(stuID, couID, completed)\n" +
            "    values(#{stuID},#{couID},0)")
    boolean addStudentOfCourse(@Param("stuID")long stuID, @Param("couID")long couID);

    @Update("delete from takes\n" +
            "where stuID=#{stuID} and couID=#{couID}\n")
    boolean deleteStudentOfCourse(@Param("stuID")long stuID, @Param("couID")long couID);

    @Update("update selects set selected = 0\n" +
            "where stuID=#{stuID} and couID=#{couID}\n")
    int deleteStudentOfCourse2(@Param("stuID")long stuID, @Param("couID")long couID);

    @Update("delete from selects\n" +
            "where stuId=#{stuID} and couId=#{couID}\n")
    boolean deleteStudentOfCourse3(@Param("stuID")long stuID, @Param("couID")long couID);

    @Update("delete takes from takes, student, clazz\n" +
            "where takes.stuID=student.id and student.claID=clazz.id and takes.couID=#{couID} and clazz.name=#{claName}")
    boolean deleteClazzOfCourse(@Param("claName")String claName, @Param("couID")long couID);

    @Select("select stuID from selects\n" +
            "where couId=#{couId}")
    ArrayList<Long> findWithCouID(@Param("couId")long couId);
}
