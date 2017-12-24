package mypack.serviceImpl;

import mypack.Response.NoticeInfo;
import mypack.dao.ClazzMapper;
import mypack.dao.NoticeMapper;
import mypack.dao.StudentMapper;
import mypack.pojo.Clazz;
import mypack.pojo.Student;
import mypack.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service("NotificationServiceImpl")
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String getNotification(Long id, int flag) {
        List<NoticeInfo>notices;
        System.out.println("想得到结果");
        if(flag==1) {
            notices=noticeMapper.getProNotificationList(id);
        }else{
            notices=noticeMapper.getStuNotificationList(id);
        }
        String notifiListString="";
        System.out.println("结果呢");
        System.out.println(notices);
        if(notices!=null) {
            for(int i=0;i<notices.size();i++){
                if(i==notices.size()-1)
                    notifiListString=notifiListString+notices.get(i).toString();
                else
                    notifiListString=notifiListString+notices.get(i).toString()+";";
            }
            System.out.println(notifiListString);

        }
        return notifiListString;
    }

    @Override
    public boolean delNotification(long id) {
        System.out.println(id);
        noticeMapper.deleNotification(id);
        System.out.println(123);
        return true;
    }

    @Override
    public boolean readedNotification(long id) {
        System.out.println(4554);
        noticeMapper.readNotification(id);
        System.out.println(id);
        return true;
    }

    @Override
    public boolean readedNotificationPro(long id) {
        System.out.println(4554);
        noticeMapper.readNotificationPro(id);
        System.out.println(id);
        return true;
    }

    @Override
    public boolean noticeStudent(int admID, long stuID, String noticeContent) {
        Date date = new Date(new java.util.Date().getTime());
        System.out.println(date);
        String[]times=date.toString().split("-");
        Long t = Long.parseLong(times[0]+times[1]+times[2]);
        System.out.println(t);
        int amount = noticeMapper.getAmountOfNotice(t).size() + 1;
        long notID = t*10000 + amount;
        System.out.println(amount);
        System.out.println(notID);
        if(noticeMapper.publicNotice(notID, noticeContent, admID, date)) {
            System.out.println(123);
            if (noticeMapper.noticeStudent(notID, stuID))
                return true;
        }
        return false;
    }

    @Override
    public boolean noticeProfessor(int admID, long proID, String noticeContent) {
        Date date = new Date(new java.util.Date().getTime());
        System.out.println(date);
        String[]times=date.toString().split("-");
        Long t = Long.parseLong(times[0]+times[1]+times[2]);
        int amount = noticeMapper.getAmountOfNotice(t).size() + 1;
        long notID = t*10000 + amount;
        System.out.println(amount);
        System.out.println(notID);
        if(noticeMapper.publicNotice(notID, noticeContent, admID, date))
            if(noticeMapper.noticeProfessor(notID, proID))
                return true;
        return false;
    }

    @Override
    public boolean noticeClazz(int admID, long claID, String noticeContent) {
        Date date = new Date(new java.util.Date().getTime());
        System.out.println(date);
        String[]times=date.toString().split("-");
        Long t = Long.parseLong(times[0]+times[1]+times[2]);
        int amount = noticeMapper.getAmountOfNotice(t).size() + 1;
        long notID = t*10000 + amount;
        System.out.println(amount);
        System.out.println(notID);
        if(noticeMapper.publicNotice(notID, noticeContent, admID, date)) {
            long proID = clazzMapper.findWithID(claID).getProId();
            System.out.println(proID);
            noticeMapper.noticeProfessor(notID, proID);
            ArrayList<Long> stuIDList = studentMapper.findWithClaIDForID(claID);
            for(int i=0;i<stuIDList.size();i++){
                noticeMapper.noticeStudent(notID, stuIDList.get(i));
            }
            return true;
        }
        return false;
    }
}
