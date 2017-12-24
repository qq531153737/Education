package mypack.dao;

import mypack.Response.CourseInfo;
import mypack.Response.SelectCourseInfo;
import mypack.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface CourseMapper {

    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "WHERE course.type=#{type} and course.timeSlotID=timeslot.id and course.depID=department.id and course.proID=professor.id and department.id=#{id} and course.learnYear=#{learnYear} and course.learnTerm=#{learnTerm}")
    ArrayList<CourseInfo> queryCourse(@Param("id")long id, @Param("learnTerm") int learnTerm, @Param("learnYear")String learnYear,@Param("type")int type);


    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "WHERE course.timeSlotID=timeslot.id and course.depID=department.id and course.proID=professor.id and course.proID=#{id} and course.learnYear=#{learnYear} and course.learnTerm=#{learnTerm}")
    ArrayList<CourseInfo> getProfessorClassTable(@Param("id")long id, @Param("learnTerm") int learnTerm, @Param("learnYear")String learnYear);

    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName,department.name as depName\n" +
            "from takes,course,timeslot,professor,department\n" +
            "WHERE takes.stuID=#{id} and takes.couID=course.id and course.depID=department.id and course.proID=professor.id and course.timeSlotID=timeslot.id  and course.learnYear=#{learnYear} and course.learnTerm=#{learnTerm}")
    ArrayList<CourseInfo> getStudentClassTable(@Param("id")long id, @Param("learnTerm")int learnTerm, @Param("learnYear")String learnYear);

    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "where course.id=#{id} and  course.depID=department.id and course.timeSlotID=timeslot.id and course.proID =professor.id")
    ArrayList<CourseInfo> courseQuerybyID(@Param("id") long id);

    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "where course.name like CONCAT('%', #{name}, '%') and course.depID=department.id and course.timeSlotID=timeslot.id and course.proID =professor.id")
    ArrayList<CourseInfo> courseQuerybyName(@Param("name")String name);

    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "where course.timeSlotID=timeslot.id and course.proID =professor.id and course.depID=department.id and department.name LIKE CONCAT('%',#{depName},'%')\n")
    ArrayList<CourseInfo> courseQuerybyDepart(@Param("depName")String depName);

    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "where course.timeSlotID=timeslot.id and course.depID=department.id and course.proID =professor.id and professor.name like CONCAT('%', #{proName}, '%')\n")
    ArrayList<CourseInfo> courseQuerybyProfessor(@Param("proName")String proName);

    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "where course.timeSlotID=timeslot.id and course.depID=department.id and course.proID =professor.id and course.type=#{type}\n")
    ArrayList<CourseInfo> courseQuerybyType(@Param("type")int type);

    @Select({"<script> select course.*,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "where course.timeSlotID=timeslot.id and course.depID=department.id and course.proID =professor.id and course.proID=#{id} and course.learnYear=#{learnYear} and course.learnTerm=#{learnTerm} <when test='type!=0'> and course.type=#{type}</when></script>"})
    ArrayList<CourseInfo> procoursequery(@Param("id")long id,@Param("learnYear")String learnYear,@Param("learnTerm")int learnTerm,@Param("type")int type);

    @Insert("insert into selects values (#{couId},#{stuId},#{select})")
    boolean submitCourses(@Param("couId")long cid,@Param("stuId")long sid,@Param("select")int select);

    @Update("update selects\n" +
            "set selected=#{select}\n" +
            "where stuId=#{stuId} and couId=#{couId}")
    boolean updataSubmitCourse(@Param("couId")long cid,@Param("stuId")long sid,@Param("select")int select);

    @Update("update course\n" +
            "set stuNumber= (\n" +
            "  SELECT count(stuId)\n" +
            "  FROM (SELECT *\n" +
            "        FROM selects\n" +
            "        WHERE selected = 1 and couId=#{couId}) AS takess\n" +
            ")\n" +
            "where id=#{couId} and opening=1")
    boolean updateStudentNums(@Param("couId")long cid);

    @Select("SELECT course.*,takes.completed as completed,timeslot.startWeek,timeslot.endWeek,timeslot.times,professor.name as teaName,department.name as depName\n" +
            "from takes,course,timeslot,professor,department\n" +
            "where takes.stuID=#{id} and takes.couID=course.id and timeslot.id=course.timeSlotID and course.proID=professor.id and department.id=course.depID\n")
    ArrayList<SelectCourseInfo> getStuMyCourse(@Param("id")long id);

    @Insert("INSERT INTO `course`(id,name,type,credict,totalTime,learnTerm,learnYear,opening,classroom,depID,timeSlotID,proID,admID,stuNumber,quantity)\n" +
            "VALUES (#{id},#{name},#{type},#{credict},#{totalTime},#{learnTerm},#{learnYear},0,#{classroom},#{depID},#{timeSlotID},#{proID},#{admID},0,#{quantity})")
    boolean addCourse(@Param("id")long id, @Param("name")String name, @Param("type")int type, @Param("credict")int credict, @Param("totalTime")int totalTime, @Param("learnTerm")int learnTerm, @Param("learnYear")String learnYear, @Param("classroom")String classroom, @Param("depID")int depID, @Param("timeSlotID")int timeSlotID, @Param("proID")long proID, @Param("admID")int admID, @Param("quantity")int quantity);

    @Delete("delete from course\n" +
            "where id=#{id}")
    boolean deleteCourse(@Param("id")long id);

    @Update("update course set opening = #{opening}\n" +
            "where id=#{id}")
    int changeOpening(@Param("id")long id, @Param("opening")int opening);
}
