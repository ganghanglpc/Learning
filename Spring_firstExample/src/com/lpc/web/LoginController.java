package com.lpc.web;

import com.lpc.domain.User;
import com.lpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller //标注成为一个Spring MVC的Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
        if(!isValidUser){
            return new ModelAndView("login","error","用户名或密码错误");
        }else {
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getRemoteAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }
}
