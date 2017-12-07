package mypack.serviceImpl;

import mypack.Response.ScoreInfo;
import mypack.dao.TakesMapper;
import mypack.service.StuQueryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentQueryManagementServiceImpl")
public class StudentQueryManagementServiceImpl implements StuQueryManagementService{
    @Autowired
    private TakesMapper takesMapper;

    @Override
    public String scoreQuery(long id, String learnYear, int learnTerms, int courseType) {
        System.out.println("想得到结果");
        List<ScoreInfo> scoreInfos=takesMapper.getScoreList(id,learnYear,learnTerms,courseType);
        System.out.println(scoreInfos);
        String result="";
        if(scoreInfos!=null){
            System.out.println("进来了");
            for(int i=0;i<scoreInfos.size();i++){
                if(i==scoreInfos.size()-1)
                    result+=scoreInfos.get(i).toString();
                else
                    result+=scoreInfos.get(i).toString()+";";
            }
        }
        System.out.println("结果");
        return result;
    }
}
