package mypack.serviceImpl;

import mypack.dao.*;
import mypack.pojo.Department;
import mypack.pojo.Major;
import mypack.service.AdministorAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

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
        majorMapper.autoIncreaseNewClazz(majID); ///!!!
        int newClazz = major.getNewClazz();
        long id = (long)year*1000000 + majID*100 + newClazz;
        if(clazzMapper.addClazz(id, name, majID, year, proID))
            return true;
        else
            return false;
    }
}
