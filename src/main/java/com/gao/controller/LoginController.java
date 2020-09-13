package com.gao.controller;

import com.gao.entity.User;
import com.gao.service.UserSvc;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource
    private UserSvc userSvc;

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/loginCheck")
    public  String loginCheck(User user, HttpSession session, Model model){
        User user1 = userSvc.queryUser(user.getUsername());
        if (user1==null){
            model.addAttribute("msg","用户不存在,请先注册");
            System.out.println("2的user:"+user);
            return "login";
        }
        if (user1.getPassword().equals(user.getPassword())){
            session.setAttribute("user",user);
            return  "redirect:/studentMgr";
        }else {
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
}
