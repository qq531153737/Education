package mypack.serviceImpl;

import mypack.Response.StudentDepartResponse;
import mypack.dao.StudentMapper;
import mypack.service.StuSelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StuCourseSelectServiceImpl")
public class StuCourseSelectServiceImpl implements StuSelectCourseService{

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public StudentDepartResponse getStudentDepart(long id) {
        StudentDepartResponse studentDepartResponse=studentMapper.getDepartId(id);
        if(studentDepartResponse!=null)
            return studentDepartResponse;
        return null;
    }
}
