package mypack.serviceImpl;

import mypack.Response.CourseInfo;
import mypack.Response.ScoreInfo;
import mypack.dao.CourseMapper;
import mypack.dao.TakesMapper;
import mypack.service.ProScoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("ProScoreRecordServiceImpl")
public class ProScoreRecordServiceImpl implements ProScoreRecordService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private TakesMapper takesMapper;
    @Override
    public String scoreQuery(long id, String year, int term, int type) {
        System.out.println("想得到结果");
        List<CourseInfo> courseInfos=courseMapper.procoursequery(id,year,term,type);
        System.out.println(courseInfos);
        String result="";
        if(courseInfos!=null){
            System.out.println("进来了");
            for(int i=0;i<courseInfos.size();i++){
                if(i==courseInfos.size()-1)
                    result+=courseInfos.get(i).toAllString();
                else
                    result+=courseInfos.get(i).toAllString()+";";
            }
        }
        System.out.println(result);
        return result;
    }

    @Override
    public boolean singleScore(long cid, String sid, String score) {
        Long id;
        System.out.println("11");
        float grade=0;
        if(isNumeric(sid))
            id=Long.parseLong(sid);
        else
            return false;
        grade=Float.parseFloat(score);
        System.out.println("21");
        takesMapper.updateSingleScore(cid,id,grade);
        System.out.println("15");
        return true;

    }



    private boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
