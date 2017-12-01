package mypack.controller;

import mypack.Response.Data;
import mypack.Response.TeacherInfo;
import mypack.pojo.Professor;
import mypack.pojo.Securitypro;
import mypack.pojo.Securitystu;
import mypack.service.ChangePasswordService;
import mypack.serviceImpl.ProfessorAccountServiceImpl;
import mypack.serviceImpl.TeaFileInfoServiceImpl;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfessorController {
    @Autowired
    @Qualifier("ProfessorAccountServiceImpl")
    private ProfessorAccountServiceImpl professorAccountService;

    @Autowired
    @Qualifier("TeaFileInfoServiceImpl")
    private TeaFileInfoServiceImpl teaFileInfoService;

    @Autowired
    @Qualifier("ProChangePasswordServiceImpl")
    private ChangePasswordService proChangePasswordServiceImpl;
    @RequestMapping("/teacher/login")
    @ResponseBody
    public Data login(HttpServletRequest request) {
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        Data data=new Data();
        if(professorAccountService.login(Long.parseLong(id), password))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }
    @RequestMapping("/teacher/fileInfo")
    @ResponseBody
    public TeacherInfo getProfessprInfo(HttpServletRequest request){
       String id=request.getParameter("id");
       System.out.println(id);
        TeacherInfo teacherInfo=teaFileInfoService.getProfessorInfo(Long.parseLong(id));
        System.out.println(teacherInfo);
        return teacherInfo;
    }
    @RequestMapping("/teacher/setInfo")
    @ResponseBody
    public Data setProfessorInfo(HttpServletRequest request){
        String id= request.getParameter("id");
        String nationality=request.getParameter("nationality");
        int teachingAge=Integer.parseInt(request.getParameter("teachingAge"));
        String educationBackgroud=request.getParameter("educationBackground");
        String politicalStatus=request.getParameter("politicalStatus");
        String areaInterest=request.getParameter("areaInterest");

        System.out.print(id+"--->"+nationality);
        boolean result=teaFileInfoService.setProfessorInfo(Long.parseLong(id),nationality,teachingAge,educationBackgroud,areaInterest,politicalStatus);
        Data data=new Data();
        if(result==true)
            data.setData(1);
        else
            data.setData(0);
        return data;

    }
    @RequestMapping("/teacher/securityQuery")
    @ResponseBody
    public Securitypro getProfessorSecurity(HttpServletRequest request){
        System.out.println("here");

        Securitypro securitypro=new Securitypro();
        return securitypro;
    }

    @RequestMapping("/teacher/setPassword")
    @ResponseBody
    public Data setStudentPassword(HttpServletRequest request){
        System.out.println("进入");
        long id=Long.parseLong(request.getParameter("id"));
        String oldPass=request.getParameter("oldPass");
        String newPass=request.getParameter("newPass");
        Data data=new Data();
        System.out.println(id+">>>"+oldPass);
        boolean flag=proChangePasswordServiceImpl.checkOldPassword(id,oldPass);
        System.out.println(flag);
        if(!flag) {
            data.setData(0);
            return data;
        }
        System.out.println(newPass+"进入修改");
        proChangePasswordServiceImpl.changePassword(id,newPass);
        System.out.println("out");
        data.setData(1);
        return data;
    }


}
