package mypack.controller;

import mypack.Response.Data;
import mypack.Response.ResponsdString;
import mypack.Response.ScoreInfo;
import mypack.Response.StudentInfo;
import mypack.pojo.Securitystu;
import mypack.pojo.Student;
import mypack.service.ChangePasswordService;
import mypack.service.ChangeSecurityQuestionService;
import mypack.serviceImpl.*;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
    @Autowired
    @Qualifier("StudentAccountServiceImpl")
    private StudentAccountServiceImpl studentAccountService;

    @Autowired
    @Qualifier("StuFileInfoServiceImpl")
    private StuFileInfoServiceImpl stuFileInfoService;

    @Autowired
    @Qualifier("StuChangePasswordServiceImpl")
    private ChangePasswordService stuChangePasswordServiceImpl;

    @Autowired
    @Qualifier("StuChangeSecurityQuestionServiceImpl")
    private ChangeSecurityQuestionService stuChangeSecurityQuestionServiceImpl;

    @Autowired
    @Qualifier("NotificationServiceImpl")
    private NotificationServiceImpl notificationServiceImple;

    @Autowired
    @Qualifier("StudentQueryManagementServiceImpl")
    private StudentQueryManagementServiceImpl studentQueryManagementServiceImpl;

    @RequestMapping("/student/login")
    @ResponseBody
    public Data login(HttpServletRequest request) {
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        Data data=new Data();
        if(studentAccountService.login(Long.parseLong(id), password))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }

    @RequestMapping("/student/fileInfo")
    @ResponseBody
    public StudentInfo getStudentInfo(HttpServletRequest request){
        String id=request.getParameter("id");
        System.out.println(id);
        StudentInfo student=stuFileInfoService.getStudentInfo(Long.parseLong(id));
        return student;
    }

    @RequestMapping("/student/setInfo")
    @ResponseBody
    public Data setStudentInfo(HttpServletRequest request){
//        System.out.print("过来了");
        String sid=request.getParameter("id");
        Long id=Long.parseLong(sid);
        String nationality=request.getParameter("nationality");
        String nativePlace=request.getParameter("nativePlace");
        String politicalStatus=request.getParameter("politicalStatus");
        String sex=request.getParameter("sex");
        String areaInterest=request.getParameter("areaInterest");
        String title=request.getParameter("title");
        boolean result=stuFileInfoService.setStudentInfo(id,nationality,nativePlace,politicalStatus,sex,areaInterest,title);
        Data data=new Data();
        if(result==true)
            data.setData(1);
        else
            data.setData(0);
        return data;
    }

    @RequestMapping("/student/securityQuery")
    @ResponseBody
    public Securitystu getStudentSecurity(HttpServletRequest request){
        System.out.println("here");
        Long id=Long.parseLong(request.getParameter("id"));
        Securitystu securitystu=stuChangeSecurityQuestionServiceImpl.securityQuestionQuery(id);
        if(securitystu!=null)
            return securitystu;
        return null;
    }

    @RequestMapping("/student/setPassword")
    @ResponseBody
    public Data setStudentPassword(HttpServletRequest request){
        System.out.println("进入");
        long id=Long.parseLong(request.getParameter("id"));
        String oldPass=request.getParameter("oldPass");
        String newPass=request.getParameter("newPass");
        Data data=new Data();
        System.out.println(id+">>>"+oldPass);
        boolean flag=stuChangePasswordServiceImpl.checkOldPassword(id,oldPass);
        System.out.println(flag);
        if(!flag) {
            data.setData(0);
            return data;
        }
        System.out.println(newPass+"进入修改");
        stuChangePasswordServiceImpl.changePassword(id,newPass);
        System.out.println("out");
        data.setData(1);
        return data;
    }

    @RequestMapping("/student/resetSecurity")
    @ResponseBody
    public Data resetSecurityPassword(HttpServletRequest request){
        Long id =Long.parseLong(request.getParameter("id"));
        String queone=request.getParameter("queone");
        String quetwo=request.getParameter("quetwo");
        String quethree=request.getParameter("quethree");
        String ansone=request.getParameter("ansone");
        String anstwo=request.getParameter("anstwo");
        String ansthree=request.getParameter("ansthree");
        System.out.println(id+"->"+queone+"->"+quetwo+"->"+quethree+"->"+ansone+"->"+anstwo+"->"+ansthree);
        System.out.println("进入插入");
        stuChangeSecurityQuestionServiceImpl.resetSecurityQuestion(id,queone,ansone,quetwo,anstwo,quethree,ansthree);
        System.out.println("结束插入");

        return new Data(1);
    }

    @RequestMapping("/student/checkAnswer")
    @ResponseBody
    public Data checkAnswer(HttpServletRequest request){
        Data data=new Data();
        Long id =Long.parseLong(request.getParameter("id"));
        String queone=request.getParameter("question1");
        String quetwo=request.getParameter("question2");
        String quethree=request.getParameter("question3");
        String ansone=request.getParameter("answer1");
        String anstwo=request.getParameter("answer2");
        String ansthree=request.getParameter("answer3");
        System.out.println(id+"->"+queone+"->"+quetwo+"->"+quethree+"->"+ansone+"->"+anstwo+"->"+ansthree);
        boolean flag=stuChangeSecurityQuestionServiceImpl.checkAnswer(id,queone,ansone,quetwo,anstwo,quethree,ansthree);
        System.out.println(flag);
        if(flag)
            data.setData(1);
        return data;
    }
    @RequestMapping("/student/notificationQuery")
    @ResponseBody
    public ResponsdString getNotification(HttpServletRequest request){
        Long id=Long.parseLong(request.getParameter("id"));
        System.out.println("进入");
        String notify1=notificationServiceImple.getNotification(id,0);
        System.out.println("结束");
        ResponsdString notify=new ResponsdString(notify1);
        return notify;
    }

    @RequestMapping("/student/deleteNotification")
    @ResponseBody
    public Data delNotifications(HttpServletRequest request){
        Data data=new Data();
        Long id=Long.parseLong(request.getParameter("id"));
        if(notificationServiceImple.delNotification(id))
            data.setData(1);
        else data.setData(0);
        return data;
    }

    @RequestMapping("/student/ReadNotification")
    @ResponseBody
    public Data readNotifications(HttpServletRequest request){
        Data data=new Data();
        Long id=Long.parseLong(request.getParameter("id"));
        if(notificationServiceImple.readedNotification(id))
            data.setData(1);
        else data.setData(0);
        return data;
    }

    @RequestMapping("/student/scorequery")
    @ResponseBody
    public ResponsdString scorequery(HttpServletRequest request){

        Long id=Long.parseLong(request.getParameter("id"));
        String learnYear=request.getParameter("selectYear");
        System.out.println(request);
        Integer learnTerm=0;
        if(request.getParameter("selectTerm")!=""){
            System.out.println(11);

            learnTerm=Integer.parseInt(request.getParameter("selectTerm"));
    }
        Integer courseType=0;
        if(request.getParameter("selectType")!="") {
            System.out.println(22);
            courseType = Integer.parseInt(request.getParameter("selectType"));
        }
        System.out.println("开始查询");
        System.out.println(id+">"+learnYear+">"+learnTerm+">"+courseType);
        String result=studentQueryManagementServiceImpl.scoreQuery(id,learnYear,learnTerm,courseType);
        System.out.println("over");
        ResponsdString responsdString=new ResponsdString(result);
        return responsdString;
    }

}
