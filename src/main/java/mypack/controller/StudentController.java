package mypack.controller;

import mypack.Response.Data;
import mypack.Response.StudentInfo;
import mypack.pojo.Securitystu;
import mypack.pojo.Student;
import mypack.service.ChangePasswordService;
import mypack.serviceImpl.AdministorAccountServiceImpl;
import mypack.serviceImpl.StuFileInfoServiceImpl;
import mypack.serviceImpl.StudentAccountServiceImpl;
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

        Securitystu securitystu=new Securitystu();
        return securitystu;
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

}
