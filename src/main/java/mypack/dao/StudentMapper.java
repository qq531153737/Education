package mypack.dao;

import mypack.Response.StudentInfo;
import mypack.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    @Select("select * from student where id=#{id} and password=#{password}")
    Student findWithIdAndPassword(@Param("id") long id, @Param("password") String password);

    @Select("\n" +
            "select student.*,major.name as majName,department.name as depName,clazz.name as claName from student,major,department,clazz where student.majID=major.id and student.claID =clazz.id and major.depID=department.id and student.id=#{id}")
    StudentInfo getStudentInfo(@Param("id") long id);

    @Select("UPDATE student set areaInterest=#{areaInterest},nationality=#{nationality},nativePlace=#{nativePlace},politicalStatus=#{politicalStatus},sex=#{sex},title=#{title} where student.id=#{id}")
    void setStudentInfo(@Param("id") long id, @Param("nationality") String nationality, @Param("nativePlace") String nativePlace,
                        @Param("politicalStatus") String politicalStatus, @Param("sex") String sex,
                        @Param("areaInterest") String areaInterest, @Param("title") String title
    );
}