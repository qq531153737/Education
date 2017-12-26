package mypack.serviceImpl;

import mypack.dao.*;
import mypack.pojo.Professor;
import mypack.pojo.Takes;
import mypack.service.AdministorDeleteService;
import mypack.service.AdministorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdministorDeleteServiceImpl")
public class AdministorDeleteServiceImpl implements AdministorDeleteService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ProfessorMapper professorMapper;
    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TakesMapper takesMapper;

    @Override
    public boolean deleteStudent(long id) {
        if(studentMapper.deleteStudent(id))
            return true;
        return false;
    }

    @Override
    public boolean deleteProfessor(long id) {
        if(professorMapper.deleteProfessor(id))
            return true;
        return false;
    }

    @Override
    public boolean deleteClazz(long id) {
        System.out.print(id);
        if(clazzMapper.deleteClazz(id))
            return true;
        return false;
    }

    @Override
    public boolean deleteCourse(long id) {
        System.out.println(id);
        if(courseMapper.deleteCourse(id))
            return true;
        return false;
    }

    @Override
    public boolean deleteStudentOfCourse(long stuID, long couID) {
        if(takesMapper.deleteStudentOfCourse(stuID, couID)) {
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteStudentOfCourse2(long stuID, long couID) {
        if(takesMapper.deleteStudentOfCourse2(stuID, couID) == 1) {
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteClazzOfCourse(String claName, long couID) {
        if(takesMapper.deleteClazzOfCourse(claName, couID)) {
            return true;
        }
        else
            return false;
    }
}
