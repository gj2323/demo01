package com.gao.controller;

import com.gao.entity.Student;
import com.gao.entity.User;
import com.gao.service.StudentSvc;
import com.gao.service.UserSvc;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentMgrController {
    @Resource
    private StudentSvc studentSvc;

    @Resource
    private  UserSvc userSvc;

    @RequestMapping("/studentMgr")
    public String toUserMgr(){

        return "student/studentMgr";
    }

    @RequestMapping("/findAllStudent")
    public String findAllStudent(Model model, @RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo){
        Integer pageSize=5;
        PageHelper.startPage(pageNo,pageSize);
        List<Student> students = studentSvc.selectStudentList();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        model.addAttribute("pageInfo",pageInfo);
        return "student/studentList";
    }

    @RequestMapping("/deleteStudent")
    @ResponseBody
    public Map<String,Object> deleteStudent(String sno){
        System.out.println(sno);
        HashMap<String, Object> map = new HashMap<>();
        try {
            studentSvc.deleteStudent(sno);
            map.put("status",true);
            map.put("msg","删除成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","删除失败");
        }
        return  map;
    }


    @RequestMapping("/addStudent")
    @ResponseBody
   public  Map<String,Object> addStudent(Student student){
        System.out.println("add"+student);
        Map<String, Object> map = new HashMap<>();
        try {
            studentSvc.insertStudent(student);
            map.put("status",true);
            map.put("msg","保存成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","保存失败");
        }
        return  map;
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public  Student findOne(String sno){
        return  studentSvc.selectStudent(sno);
    }


    @RequestMapping("/updateStudent")
    @ResponseBody
    public Map<String,Object> updateStudent(Student student){
        System.out.println(student);
        HashMap<String, Object> map = new HashMap<>();
        try {
            studentSvc.updateStudent(student);
            map.put("status",true);
            map.put("msg","更新用户信息成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","更新用户信息失败");
        }
            return  map;
    }



    @RequestMapping("/updateUser")
    @ResponseBody
    public  Map<String,Object> updateUser(User user){
        HashMap<String, Object> map = new HashMap<>();
        try {
            userSvc.modifyUser(user);

            map.put("status",true);
            map.put("msg","修改密码成功，请重新登录");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",false);
            map.put("msg","修改密码失败");
        }
      return  map;
    }


    @RequestMapping("/findStudentList")
    public String findStudentList(Student student,Model model, @RequestParam(defaultValue = "1",required = true,value = "pageNo") Integer pageNo){
        Integer pageSize=5;
        PageHelper.startPage(pageNo,pageSize);
        List<Student> students = studentSvc.findStudentList(student);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        model.addAttribute("pageInfo",pageInfo);
        return "student/studentList";
    }



}
