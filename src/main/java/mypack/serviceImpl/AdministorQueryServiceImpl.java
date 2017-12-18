package mypack.serviceImpl;

import mypack.Response.ProfessorResponse;
import mypack.Response.StudentInfo;
import mypack.dao.ClazzMapper;
import mypack.dao.DepartmentMapper;
import mypack.dao.ProfessorMapper;
import mypack.dao.StudentMapper;
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
        ArrayList<Clazz> clazzArrayList = clazzMapper.queryClazz(depId, year);
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
}
