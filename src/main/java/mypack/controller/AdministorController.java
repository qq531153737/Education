package mypack.controller;


import mypack.serviceImpl.AdministorAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;



@Controller
public class AdministorController {
    @Autowired
    @Qualifier("AdministorAccountServiceImpl")
    private AdministorAccountServiceImpl administorAccountService;


    @RequestMapping("/administor/login")
    @ResponseBody
    public int login(HttpServletRequest request) {
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        if(administorAccountService.login(Long.parseLong(id), password))
            return 1;
        return 0;
    }
}
