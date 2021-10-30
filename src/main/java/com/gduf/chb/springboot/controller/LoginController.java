package com.gduf.chb.springboot.controller;


import com.gduf.chb.springboot.bean.Login;
import com.gduf.chb.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

//    @RequestMapping(value = "/")
//    public String begin(){
//        return "Login";
//    }

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String login(String id, String password, Model model, HttpSession session) {
        Login login=loginService.logincheck(id,password);
        if (login!=null) {
            switch (login.getRole()){
                case "user":session.setAttribute("Login_SESSION",login);return "userlist";
                case "admin":session.setAttribute("Login_SESSION",login);return "adminlist";
                case "staff":session.setAttribute("Login_SESSION",login);return "stafflist";
                case "reporter":session.setAttribute("Login_SESSION",login);return"reporterlist";
                default:return "Login";
            }
        } else {
            model.addAttribute("msg", "账号或密码错误");
            return "Login";
        }

    }

    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String tologin() {
        return "Login";
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    public String register(String id, String password, String code, Model model) {
        if (!loginService.checkid(id)) {
            if (code != "") {
                if (loginService.checkcode(code)) {
                    loginService.staffregister(id,password,code);
                    model.addAttribute("msg", "医护人员注册成功，可直接登录");
                    return "Login";
                } else {
                    model.addAttribute("msg1", "激活码无效");
                    return "register" ;
                }
            } else {
                loginService.userregister(id, password);
                model.addAttribute("msg", "注册成功，可直接登录");
                return "Login";
            }
        } else {
            model.addAttribute("msg1", "账号已存在");
            return "register";
        }
    }

    @RequestMapping(value = "register.do", method = RequestMethod.GET)
    public String toregister() {
        return "register";
    }

    @RequestMapping(value = "/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login.do";
    }
}
