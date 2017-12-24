package mypack.serviceImpl;


import mypack.dao.CourseMapper;
import mypack.dao.TakesMapper;
import mypack.service.PublicAndStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("PublicAndStopServiceImpl")
public class PublicAndStopServiceImpl implements PublicAndStopService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private TakesMapper takesMapper;

    @Override
    public boolean publicCourse(long couID) {
        if(courseMapper.changeOpening(couID, 1) == 1)
            return true;
        return false;
    }

    @Override
    public boolean stopCourse(long couID) {
        if(courseMapper.changeOpening(couID, 0) == 1) {
            ArrayList<Long> longArrayList = takesMapper.findWithCouID(couID);
            for(int i=0;i<longArrayList.size();i++){
                long stuID = longArrayList.get(i);
                takesMapper.addStudentOfCourse(stuID, couID);
                System.out.println(1111111);
                takesMapper.deleteStudentOfCourse3(stuID, couID);
                System.out.println(2222222);
            }
            return true;
        }
        return false;
    }
}
