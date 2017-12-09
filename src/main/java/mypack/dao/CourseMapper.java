package mypack.dao;

import mypack.Response.CourseInfo;
import mypack.pojo.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface CourseMapper {

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


}
