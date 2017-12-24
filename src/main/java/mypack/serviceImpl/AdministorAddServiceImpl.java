package mypack.serviceImpl;

import mypack.dao.*;
import mypack.pojo.Department;
import mypack.pojo.Major;
import mypack.pojo.Takes;
import mypack.service.AdministorAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Service("AdministorAddServiceImpl")
public class AdministorAddServiceImpl implements AdministorAddService{

    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ProfessorMapper professorMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private TakesMapper takesMapper;

    @Override
    public boolean addStudent(String name, int majID, long claID, int year) {
        System.out.println("123");
        Major major = majorMapper.findWithID(majID);
        System.out.println("222");
        int newStudent = major.getNewStudent();
        long id = (long) year * 100000000 + majID * 1000 + newStudent+1;
        System.out.println(id);
        if (studentMapper.addStudent(id, name, majID, claID, year)) {
            System.out.println("456");
            majorMapper.autoIncreaseNewStudent(majID); ///!!!
            System.out.println("111");
            clazzMapper.autoIncreaseQuantity(claID);   ///!!
            System.out.println(newStudent);
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }

    @Override
    public boolean addProfessor(String name, int depID, int year) {
        Department department = departmentMapper.findWithID(depID);
        System.out.println(depID);
        int newProfessor = department.getNewProfessor();
        long id = (long)year*10000000 + depID*10000 + newProfessor+1;
        if(professorMapper.addProfessor(id, name, depID, year)) {
            System.out.println("123123");
            departmentMapper.autoIncreaseNewProfessor(depID); ///!!!
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean addClazz(String name, int majID, int year, long proID) {
        Major major = majorMapper.findWithID(majID);
        int newClazz = major.getNewClazz();
        long id = (long)year*1000000 + majID*100 + newClazz+1;
        System.out.println(id);
        if(clazzMapper.addClazz(id, name, majID, year, proID)) {
            System.out.println("123");
            majorMapper.autoIncreaseNewClazz(majID); ///!!!
            System.out.println("122");
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean addCourse(String name, int type, int credict, int totalTime, int learnTerm, String learnYear, String classroom, int depID, int timeSlotID, long proID, int admID, int quantity) {
        System.out.println(name+name+name);
        Department department = departmentMapper.findWithID(depID);

        int year = Integer.parseInt(learnYear.substring(0,4));
        int newCourse = department.getNewCourse();
        long id = year*1000000 + depID*10000 + newCourse+1;
        System.out.println(id);
        if(courseMapper.addCourse(id, name, type, credict, totalTime, learnTerm, learnYear, classroom, depID, timeSlotID, proID, admID, quantity)) {
            departmentMapper.autoIncreaseNewCourse(depID); ///!!!
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean addStudentOfCourse(long stuID, long couID) {
        if(takesMapper.addStudentOfCourse(stuID, couID)) {
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean addClazzOfCourse(long claID, long couID) {
        ArrayList<Long> stuIDList = studentMapper.findWithClaIDForID(claID);
        for(int i=0;i<stuIDList.size();i++){
            if(!takesMapper.addStudentOfCourse(stuIDList.get(i), couID))
                return false;
            System.out.print(i);
        }
        return true;
    }
}
