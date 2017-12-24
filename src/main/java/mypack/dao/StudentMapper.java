package mypack.dao;

import mypack.Response.SelectCourseInfo;
import mypack.Response.StudentDepartResponse;
import mypack.Response.StudentInfo;
import mypack.pojo.Securitystu;
import mypack.pojo.Selects;
import mypack.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.ArrayList;

public interface StudentMapper {
    @Select("select * from student where id=#{id} and password=#{password}")
    Student findWithIdAndPassword(@Param("id") long id, @Param("password") String password);

    @Select("select student.*,major.name as majName,department.name as depName,clazz.name as claName\n" +
            "from student, major, department, clazz, takes\n" +
            "where takes.stuID=student.id and student.majID=major.id and major.depID=department.id and student.claID=clazz.id and takes.couID=#{couID}\n")
    ArrayList<StudentInfo> queryStudentOfCourse(@Param("couID") long couID);

    @Select("select student.*,major.name as majName,department.name as depName,clazz.name as claName\n" +
            "from student, major, department, clazz, selects\n" +
            "where selects.stuID=student.id and student.majID=major.id and major.depID=department.id and student.claID=clazz.id and selects.couID=#{couID} and selects.selected=1\n")
    ArrayList<StudentInfo> queryStudentOfCourse2(@Param("couID") long couID);

    @Select("\n" +
            "select student.*,major.name as majName,department.name as depName,clazz.name as claName\n" +
            "from student, major, department,clazz\n" +
            "where student.majID=major.id and major.depID=department.id and student.claID=clazz.id and student.claID=#{claID}")
    ArrayList<StudentInfo> findWithClaID(@Param("claID") long claID);

    @Select("select id\n" +
            "from student\n" +
            "where claID = #{claID}\n")
    ArrayList<Long> findWithClaIDForID(@Param("claID")long claID);

    @Select("\n" +
            "select student.*,major.name as majName,department.name as depName,clazz.name as claName from student,major,department,clazz where student.majID=major.id and student.claID =clazz.id and major.depID=department.id and student.id=#{id}")
    StudentInfo getStudentInfo(@Param("id") long id);

    @Update("UPDATE student\n" +
            "set areaInterest=#{areaInterest},nationality=#{nationality},\n" +
            "  nativePlace=#{nativePlace},politicalStatus=#{politicalStatus},\n" +
            "  sex=#{sex},title=#{title},healthState=#{healthState},timeEnrollment=#{enrollTime},\n" +
            "  timeGraduation=#{graduateTime},birthday=#{birthday}\n" +
            "where student.id=#{id}")
    boolean setStudentInfo(@Param("id") long id, @Param("nationality") String nationality, @Param("nativePlace") String nativePlace,
                           @Param("politicalStatus") String politicalStatus, @Param("sex") int sex,
                           @Param("areaInterest") String areaInterest, @Param("title") String title,
                           @Param("healthState") String health, @Param("enrollTime") Date enrollTime,
                           @Param("graduateTime") Date graduateTime, @Param("birthday") Date birthday
    );

    @Select("select * from student where id=#{id} and password=#{password}")
    Student checkStudentPassword(@Param("id") long id, @Param("password") String password);

    @Select("UPDATE student SET password=#{password} WHERE id=#{id}")
    void changeStudentPassword(@Param("id") long id, @Param("password") String password);

    @Select("update securitystu\n" +
            "set queone=#{queone},quetwo=#{quetwo},quethree=#{quethree},ansone=#{ansone},anstwo=#{anstwo},ansthree=#{ansthree}" +
            "where stuID=#{id}")
    void resetSecurityQuestion(@Param("id") long id, @Param("queone") String queone, @Param("quetwo") String quetwo,
                               @Param("quethree") String quethree, @Param("ansone") String ansone,
                               @Param("anstwo") String anstwo, @Param("ansthree") String ansthree);

    @Select("SELECT * from securitystu WHERE stuID=#{id}")
    Securitystu securityQuestionQuery(@Param("id") long id);

    @Select("select * from securitystu where stuID=#{id}")
    Securitystu checkAnswer(@Param("id") long id);

    @Select("SELECT student.id as stuId,major.depID as depId\n" +
            "from student,major\n" +
            "where student.id=#{id} and student.majID=major.id")
    StudentDepartResponse getDepartId(@Param("id") long id);


    @Select("select course.*,timeslot.startWeek,timeslot.endWeek,professor.name as teaName,department.name as depName\n" +
            "from course,timeslot,professor,department\n" +
            "WHERE course.timeSlotID=timeslot.id and course.depID=department.id and course.proID=professor.id and course.opening=1 and course.type=#{type} and course.depID=#{id}")
    ArrayList<SelectCourseInfo> getSelectScourse(@Param("id") int id, @Param("type") int type);

    @Select({"<script>select couId,stuId\n" +
            "from selects\n" +
            "where selects.couId=#{couId} and selects.stuId=#{stuId} <when test='select!=-1'>and selects.selected=#{select}</when></script>"})
    Selects checkSelectOrNot(@Param("couId") long id, @Param("stuId") long stuId, @Param("select") int select);

    @Insert("insert into student(id, password, name, majID, claID, year) values (#{id},123456,#{name},#{majID},#{claID},#{year})")
    boolean addStudent(@Param("id") long id, @Param("name") String name, @Param("majID") int majID, @Param("claID") long claID, @Param("year") int year);

    @Delete("delete from student where id = #{id}")
    boolean deleteStudent(@Param("id") long id);
}
