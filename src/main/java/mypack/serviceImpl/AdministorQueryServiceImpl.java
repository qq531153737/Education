package mypack.serviceImpl;

import mypack.Response.ClazzInfo;
import mypack.Response.CourseInfo;
import mypack.Response.ProfessorResponse;
import mypack.Response.StudentInfo;
import mypack.dao.*;
import mypack.pojo.Clazz;
import mypack.pojo.Department;
import mypack.pojo.Professor;
import mypack.pojo.Student;
import mypack.service.AdministorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("AdministorQueryServiceImpl")
public class AdministorQueryServiceImpl implements AdministorQueryService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ProfessorMapper professorMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private TakesMapper takesMapper;


    @Override
    public String queryStudent(long claID) {
        System.out.println(claID);
        ArrayList<StudentInfo> studentArrayList = studentMapper.findWithClaID(claID);
        System.out.println(studentArrayList);
        String result="";
        for(int i=0;i<studentArrayList.size();i++){
            if(i==studentArrayList.size()-1)
                result+=studentArrayList.get(i).toString();
            else{
                result+=studentArrayList.get(i).toString()+";";
            }
        }
        System.out.println(result);
        return result;
    }

    @Override
    public String queryProfessor(String depName) {
        System.out.println(depName);

        ArrayList<ProfessorResponse> professorArrayList = professorMapper.queryProfessor(depName);
        System.out.println(professorArrayList);
        String result="";
        for(int i=0;i<professorArrayList.size();i++){
            if(i==professorArrayList.size()-1)
                result+=professorArrayList.get(i).toString();
            else{
                result+=professorArrayList.get(i).toString()+";";
            }
        }
        return result;
    }

    @Override
    public String queryClazz(int year, String depName) {
        Department department = departmentMapper.findWithName(depName);
        System.out.println(department.getId());
        System.out.println(year);
        int depId = department.getId();
        ArrayList<ClazzInfo> clazzArrayList = clazzMapper.queryClazz(depId, year);
        System.out.println(clazzArrayList);
        String result="";
        for(int i=0;i<clazzArrayList.size();i++){
            if(i==clazzArrayList.size()-1)
                result+=clazzArrayList.get(i).toString();
            else{
                result+=clazzArrayList.get(i).toString()+";";
            }
        }
        return result;
    }

    @Override
    public String queryCourse(String year, int term, String depName,int type) {
        Department department = departmentMapper.findWithName(depName);
        year = year.substring(0,4) + year.substring(5,9);
        int depId = department.getId();
        ArrayList<CourseInfo> courseInfoArrayList = courseMapper.queryCourse(depId, term, year,type);
//        System.out.println(courseInfoArrayList);
        String result="";
        for(int i=0;i<courseInfoArrayList.size();i++){
            if(i==courseInfoArrayList.size()-1)
                result+=courseInfoArrayList.get(i).toString2();
            else{
                result+=courseInfoArrayList.get(i).toString2()+";";
            }
        }
        System.out.println(result);
        return result;
    }

    @Override
    public String queryStudentOfCourse(long couID) {
        System.out.println(couID+couID+couID);
        ArrayList<StudentInfo> studentInfoArrayList = studentMapper.queryStudentOfCourse(couID);
        System.out.println(studentInfoArrayList);
        String result="";
        for(int i=0;i<studentInfoArrayList.size();i++){
            if(i==studentInfoArrayList.size()-1)
                result+=studentInfoArrayList.get(i).toString();
            else{
                result+=studentInfoArrayList.get(i).toString()+";";
            }
        }
        System.out.println(result);
        return result;
    }

    @Override
    public String queryStudentOfCourse2(long couID) {
        System.out.println(couID+couID);
        ArrayList<StudentInfo> studentInfoArrayList = studentMapper.queryStudentOfCourse2(couID);
        System.out.println(studentInfoArrayList);
        String result="";
        for(int i=0;i<studentInfoArrayList.size();i++){
            if(i==studentInfoArrayList.size()-1)
                result+=studentInfoArrayList.get(i).toString();
            else{
                result+=studentInfoArrayList.get(i).toString()+";";
            }
        }
        System.out.println(result);
        return result;
    }

    @Override
    public String queryClazzOfCourse(long couID) {
        System.out.println(couID+couID+couID);
        ArrayList<ClazzInfo> clazzInfoArrayList = clazzMapper.queryClazzOfCourse(couID);
        System.out.println(clazzInfoArrayList);
        String result="";
        for(int i=0;i<clazzInfoArrayList.size();i++){
            if(i==clazzInfoArrayList.size()-1)
                result+=clazzInfoArrayList.get(i).toString2();
            else{
                result+=clazzInfoArrayList.get(i).toString2()+";";
            }
        }
        System.out.println(result);
        return result;
    }
}
