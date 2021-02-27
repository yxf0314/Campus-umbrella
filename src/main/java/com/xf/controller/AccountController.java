package com.xf.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
    @RequestMapping("/login")
    public String login()
    {
        return "views/user/login";
    }
    @RequestMapping("/reg")
    public String reg()
    {
        return "views/user/reg";
    }
    @PostMapping("/logincheck")
    @ResponseBody
    public String logincheck(@RequestParam("username")String username,
                             @RequestParam("password")String password,
                             Model model)
    {
        System.out.println(username+" "+password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        try {
            System.out.println("准备登录");
            subject.login(usernamePasswordToken);//用token里的username和password登录
            String cur_username = usernamePasswordToken.getUsername();
            model.addAttribute("cur_username",cur_username);

            return "success";
        }catch (UnknownAccountException e){
            System.out.println("未知用户");
            model.addAttribute("msg","未知用户,请注册");
            return "UnknownAccountException";
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
            model.addAttribute("msg","密码错误");
            return "IncorrectCredentialsException";
        }
//        if(username.equals("asd")&&password.equals("123"))
//        {
//            String msg = "登陆成功";
//            model.addAttribute("msg",msg);
//            return "success";
//        }
//        else {
//            String msg = "用户名或密码错误";
//            model.addAttribute("msg",msg);
//            return "fail";
//        }
    }
}
