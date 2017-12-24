package mypack.controller;


import mypack.Response.Data;
import mypack.Response.ResponsdString;
import mypack.service.*;
import mypack.serviceImpl.AdministorAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;


@Controller
public class AdministorController {
    @Autowired
    @Qualifier("AdministorAccountServiceImpl")
    private AdministorAccountServiceImpl administorAccountService;

    @Autowired
    @Qualifier("NotificationServiceImpl")
    private NotificationService notificationServiceImpl;

    @Autowired
    @Qualifier("AdministorAddServiceImpl")
    private AdministorAddService administorAddServiceImpl;

    @Autowired
    @Qualifier("AdministorQueryServiceImpl")
    private AdministorQueryService administorQueryServiceImpl;

    @Autowired
    @Qualifier("AdministorDeleteServiceImpl")
    private AdministorDeleteService administorDeleteServiceImpl;

    @Autowired
    @Qualifier("PublicAndStopServiceImpl")
    private PublicAndStopService publicAndStopServiceImpl;




    @RequestMapping("/administor/login")
    @ResponseBody
    public Data login(HttpServletRequest request) {
        String id=request.getParameter("id");
        System.out.println(id);
        String password=request.getParameter("password");
        System.out.println(password);
        Data data=new Data();
        if(administorAccountService.login(Long.parseLong(id), password))
            data.setData(1);
        else
            data.setData(2);
        return data;
//        return new Data(1);
    }

    @RequestMapping("/administor/noticeStudent")
    @ResponseBody
    public Data noticeStudent(HttpServletRequest request) {
        Data data = new Data();
        String admID = request.getParameter("admID");
        String stuID = request.getParameter("stuID");
        String noticeContext = request.getParameter("noticeContext");
        System.out.println(admID+">"+stuID+">"+noticeContext);
        if(notificationServiceImpl.noticeStudent(Integer.parseInt(admID), Long.parseLong(stuID), noticeContext))
            data.setData(1);
        else
            data.setData(2);
        System.out.println(admID+">>"+stuID+">>"+noticeContext);
        return data;
    }

    @RequestMapping("/administor/noticeProfessor")
    @ResponseBody
    public Data noticeProfessor(HttpServletRequest request) {
        Data data = new Data();
        String admID = request.getParameter("admID");
        String proID = request.getParameter("proID");
        String noticeContext = request.getParameter("noticeContext");
        System.out.println(admID+">"+proID+">"+noticeContext);
        if(notificationServiceImpl.noticeProfessor(Integer.parseInt(admID), Long.parseLong(proID), noticeContext))
            data.setData(1);
        else
            data.setData(2);
        System.out.println(admID+">"+proID+">"+noticeContext);
        return data;
    }

    @RequestMapping("/administor/noticeClazz")
    @ResponseBody
    public Data noticeClazz(HttpServletRequest request) {
        Data data = new Data();
        String admID = request.getParameter("admID");
        String claID = request.getParameter("claID");
        String noticeContext = request.getParameter("noticeContext");
        System.out.println(admID+">"+claID+">"+noticeContext);
        if(notificationServiceImpl.noticeClazz(Integer.parseInt(admID), Long.parseLong(claID), noticeContext))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }

    @RequestMapping("/administor/addStudent")
    @ResponseBody
    public Data addStudent(HttpServletRequest request) {
        String name = request.getParameter("name");
        String majID = request.getParameter("majID");
        String claID = request.getParameter("claID");
        String year = request.getParameter("year");
        System.out.println(name+">"+majID+">"+claID+">"+year);

        Data data=new Data();
        if(administorAddServiceImpl.addStudent(name, Integer.parseInt(majID), Long.parseLong(claID), Integer.parseInt(year)))
            data.setData(1);
        else
            data.setData(0);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/administor/addProfessors")
    @ResponseBody
    public Data addProfessor(HttpServletRequest request) {
        String name = request.getParameter("pname");
        String depID = request.getParameter("depID");
        String year = request.getParameter("times");
        System.out.println(name+">"+depID+">"+year);
        Data data=new Data();
        if(administorAddServiceImpl.addProfessor(name, Integer.parseInt(depID), Integer.parseInt(year)))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }

    @RequestMapping("/administor/addClass")
    @ResponseBody
    public Data addClazz(HttpServletRequest request) {
        String name = request.getParameter("name");
        String majID = request.getParameter("majorID");
        String year = request.getParameter("years");
        String proID = request.getParameter("proID");
        System.out.println(name+">"+majID+">"+year+">"+proID);
        Data data=new Data();
        if(administorAddServiceImpl.addClazz(name, Integer.parseInt(majID), Integer.parseInt(year), Long.parseLong(proID)))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }

    @RequestMapping("/administor/addcourse")
    @ResponseBody
    public Data addCourse(HttpServletRequest request) {
        String name = request.getParameter("cname");
        String type = request.getParameter("ctype");
        String tname=request.getParameter("tname");
        String credict = request.getParameter("credict");
        String totalTime = request.getParameter("totalTime");
        String learnTerm = request.getParameter("learnTerm");
        String learnYear = request.getParameter("learnYear");
        String classroom = request.getParameter("classroom");
        String depID = request.getParameter("depID");
        String timeSlotID = request.getParameter("timeSlotID");
        String proID = request.getParameter("proID");
        String admID = request.getParameter("admID");
        String quantity = request.getParameter("quantity");
        System.out.println(name+type+tname+credict+totalTime+learnTerm+learnYear+classroom+depID+timeSlotID+proID+admID+quantity);
        Data data=new Data();
        if(administorAddServiceImpl.addCourse(name, Integer.parseInt(type), Integer.parseInt(credict), Integer.parseInt(totalTime), Integer.parseInt(learnTerm), learnYear, classroom, Integer.parseInt(depID), Integer.parseInt(timeSlotID), Long.parseLong(proID), Integer.parseInt(admID), Integer.parseInt(quantity)))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }

    @RequestMapping("/administor/addbixiucourse")
    @ResponseBody
    public Data addbiCourse(HttpServletRequest request) {
        String name = request.getParameter("cname");
        String type = request.getParameter("ctype");
        String tname=request.getParameter("tname");
        String credict = request.getParameter("credict");
        String totalTime = request.getParameter("totalTime");
        String learnTerm = request.getParameter("learnTerm");
        System.out.println(learnTerm);
        String learnYear = request.getParameter("learnYear");
        String classroom = request.getParameter("classroom");
        String depID = request.getParameter("depID");
        String timeSlotID = request.getParameter("timeSlotID");
        String proID = request.getParameter("proID");
        String admID = request.getParameter("admID");
        String quantity = request.getParameter("quantity");
        System.out.println(name+type+tname+credict+totalTime+learnTerm+learnYear+classroom+depID+timeSlotID+proID+admID+quantity);
        Data data=new Data();
        if(administorAddServiceImpl.addCourse(name, Integer.parseInt(type), Integer.parseInt(credict), Integer.parseInt(totalTime), Integer.parseInt(learnTerm), learnYear, classroom, Integer.parseInt(depID), Integer.parseInt(timeSlotID), Long.parseLong(proID), Integer.parseInt(admID), Integer.parseInt(quantity)))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }

    @RequestMapping("/administor/couaddstudent")
    @ResponseBody
    public Data addStudentOfCourse(HttpServletRequest request) {
        String couId = request.getParameter("couId");
        String stuId = request.getParameter("stuId");
        System.out.println(couId+'>'+stuId);
        Data data=new Data();
        if(administorAddServiceImpl.addStudentOfCourse(Long.parseLong(stuId),Long.parseLong(couId) ))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }

    @RequestMapping("/administor/couaddclass")
    @ResponseBody
    public Data addClazzOfCourse(HttpServletRequest request) {
        String couId = request.getParameter("couId");
        String claId = request.getParameter("classId");
        System.out.println(couId+'>'+claId);
        Data data=new Data();
        if(administorAddServiceImpl.addClazzOfCourse(Long.parseLong(claId),Long.parseLong(couId) ))
            data.setData(1);
        else
            data.setData(0);
        return data;
    }


    @RequestMapping("/administor/studentsquery")
    @ResponseBody
    public ResponsdString queryStudent(HttpServletRequest request) {
        Long claID =Long.parseLong(request.getParameter("claId"));
        System.out.println(claID);
        String response = administorQueryServiceImpl.queryStudent(claID);
        System.out.println(response);
        return new ResponsdString(response);
    }

    @RequestMapping("/administor/teacherquery")
    @ResponseBody
    public ResponsdString queryProfessor(HttpServletRequest request) {
        String depName = request.getParameter("academy");
        System.out.println(depName);
        String response = administorQueryServiceImpl.queryProfessor(depName);
        System.out.println(response);
        return new ResponsdString(response);
    }

    @RequestMapping("/administor/queryClass")
    @ResponseBody
    public ResponsdString queryClazz(HttpServletRequest request) {
        String year = request.getParameter("year");
        String depName = request.getParameter("department");
        System.out.println(depName);
        String response = administorQueryServiceImpl.queryClazz(Integer.parseInt(year), depName);
        System.out.println(response);
        return new ResponsdString(response);
    }

    @RequestMapping("/administor/getCourses")
    @ResponseBody
    public ResponsdString queryCourse(HttpServletRequest request) {
        String year = request.getParameter("years");
        String term = request.getParameter("terms");
        String depName = request.getParameter("department");
        Integer type=Integer.parseInt(request.getParameter("type"));
        System.out.println(year+term+depName+type);
        String response = administorQueryServiceImpl.queryCourse(year, Integer.parseInt(term), depName,type);
        System.out.println(response);
        return new ResponsdString(response);
    }

    @RequestMapping("/administor/getcoustudent")
    @ResponseBody
    public ResponsdString queryStudentOfCourse(HttpServletRequest request) {
        String couId = request.getParameter("couId");
        System.out.println(couId);
        String response = administorQueryServiceImpl.queryStudentOfCourse(Long.parseLong(couId));
        System.out.println(response);
        return new ResponsdString(response);
    }

    @RequestMapping("/administor/coustudent")
    @ResponseBody
    public ResponsdString queryStudentOfCourse2(HttpServletRequest request) {
        String couId = request.getParameter("couId");
        System.out.println(couId);
        String response = administorQueryServiceImpl.queryStudentOfCourse2(Long.parseLong(couId));
        System.out.println(response);
        return new ResponsdString(response);
    }

    @RequestMapping("/administor/getcourseclass")
    @ResponseBody
    public ResponsdString queryClazzOfCourse(HttpServletRequest request) {
        String couId = request.getParameter("couId");
        System.out.println(couId);
        String response = administorQueryServiceImpl.queryClazzOfCourse(Long.parseLong(couId));
        System.out.println(response);
        return new ResponsdString(response);
    }


    @RequestMapping("/administor/deleStudent")
    @ResponseBody
    public Data deleteStudent(HttpServletRequest request) {
        String id=request.getParameter("stuId");
        System.out.println(id);
        Data data=new Data();
        if(administorDeleteServiceImpl.deleteStudent(Long.parseLong(id)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }

    @RequestMapping("/administor/deleTeacher")
    @ResponseBody
    public Data deleteProfessor(HttpServletRequest request) {
        String id=request.getParameter("teaId");
        System.out.println(id);
        Data data=new Data();
        if(administorDeleteServiceImpl.deleteProfessor(Long.parseLong(id)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }

    @RequestMapping("/administor/deleClass")
    @ResponseBody
    public Data deleteClazz(HttpServletRequest request) {
        String id=request.getParameter("claId");
        System.out.println(id);
        Data data=new Data();
        if(administorDeleteServiceImpl.deleteClazz(Long.parseLong(id)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }

    @RequestMapping("/administor/deleCourses")
    @ResponseBody
    public Data deleteCourse(HttpServletRequest request) {
        String id=request.getParameter("couId");
        System.out.println(id);
        Data data=new Data();
        if(administorDeleteServiceImpl.deleteCourse(Long.parseLong(id)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }

    @RequestMapping("/administor/dropcoustudent")
    @ResponseBody
    public Data DeleteStudentOfCourse(HttpServletRequest request) {
        String stuId = request.getParameter("stuId");
        String couId = request.getParameter("couId");
        System.out.println(stuId);
        System.out.println(couId);
        Data data=new Data();
        if(administorDeleteServiceImpl.deleteStudentOfCourse(Long.parseLong(stuId), Long.parseLong(couId)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }
    @RequestMapping("/administor/rejectstudent")
    @ResponseBody
    public Data DeleteStudentOfCourse2(HttpServletRequest request) {
        String stuId = request.getParameter("stuId");
        String couId = request.getParameter("couId");
        System.out.println(stuId);
        System.out.println(couId);
        Data data=new Data();
        if(administorDeleteServiceImpl.deleteStudentOfCourse2(Long.parseLong(stuId), Long.parseLong(couId)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }

    @RequestMapping("/administor/deleClass2")
    @ResponseBody
    public Data DeleteClazzOfCourse(HttpServletRequest request) {
        String claName = request.getParameter("class");
        String couId = request.getParameter("couId");
        System.out.println(claName);
        System.out.println(couId);
        Data data=new Data();
        if(administorDeleteServiceImpl.deleteClazzOfCourse(claName, Long.parseLong(couId)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }

    @RequestMapping("/administor/xuancousepublish")
    @ResponseBody
    public Data publicCourse(HttpServletRequest request) {
        String couId = request.getParameter("couId");
        System.out.println(couId);

        Data data=new Data();
        if(publicAndStopServiceImpl.publicCourse(Long.parseLong(couId)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }

    @RequestMapping("/administor/coursepublish")
    @ResponseBody
    public Data publicCourse2(HttpServletRequest request) {
        String couId = request.getParameter("couId");
        Data data=new Data();
        if(publicAndStopServiceImpl.publicCourse(Long.parseLong(couId)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }


    @RequestMapping("/administor/xuancousestop")
    @ResponseBody
    public Data stopCourse(HttpServletRequest request) {
        String couId = request.getParameter("couId");
        System.out.println(couId);
        Data data=new Data();
        if(publicAndStopServiceImpl.stopCourse(Long.parseLong(couId)))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }


}

