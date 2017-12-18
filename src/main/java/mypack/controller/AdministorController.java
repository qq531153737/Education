package mypack.controller;


import mypack.Response.Data;
import mypack.Response.ResponsdString;
import mypack.service.AdministorAddService;
import mypack.service.AdministorQueryService;
import mypack.service.NotificationService;
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
    }

//    @RequestMapping("/administor/noticeStudent")
//    @ResponseBody
//    public Data noticeStudent(HttpServletRequest request) {
//        Data data = new Data();
//        String stuID = request.getParameter("stuID");
//        String noticeContext = request.getParameter("noticeContext");
//        if(notificationServiceImpl.noticeStudent(Long.parseLong(stuID), noticeContext))
//            data.setData(1);
//        else
//            data.setData(2);
//        return data;
//    }
//
//    @RequestMapping("/administor/noticeProfessor")
//    @ResponseBody
//    public Data noticeProfessor(HttpServletRequest request) {
//        Data data = new Data();
//        String proID = request.getParameter("proID");
//        String noticeContext = request.getParameter("noticeContext");
//        if(notificationServiceImpl.noticeStudent(Long.parseLong(proID), noticeContext))
//            data.setData(1);
//        else
//            data.setData(2);
//        return data;
//    }
//
//    @RequestMapping("/administor/noticeClazz")
//    @ResponseBody
//    public Data noticeClazz(HttpServletRequest request) {
//        Data data = new Data();
//        String claID = request.getParameter("claID");
//        String noticeContext = request.getParameter("noticeContext");
//        if(notificationServiceImpl.noticeStudent(Long.parseLong(claID), noticeContext))
//            data.setData(1);
//        else
//            data.setData(2);
//        return data;
//    }

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

    @RequestMapping("/administor/addClazz")
    @ResponseBody
    public Data addClazz(HttpServletRequest request) {
        String name = request.getParameter("name");
        String majID = request.getParameter("majID");
        String year = request.getParameter("year");
        String proID = request.getParameter("proID");
        Data data=new Data();
        if(administorAddServiceImpl.addClazz(name, Integer.parseInt(majID), Integer.parseInt(year), Long.parseLong(proID)))
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
}

