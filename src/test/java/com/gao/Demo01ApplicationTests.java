package com.gao;

import com.gao.entity.Student;
import com.gao.entity.User;
import com.gao.mapper.UserMapper;
import com.gao.service.StudentSvc;
import com.gao.service.UserSvc;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Demo01ApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Resource
    private StudentSvc studentSvc;

    @Resource
    private  UserSvc userSvc;
    @Test
    void contextLoads() {
        User user = userMapper.selectUser("b");
        System.out.println(user);
    }
    @Test
    void  test1(){
        Student student = new Student();
        student.setSno("pl");
        student.setSname("盘");

        studentSvc.updateStudent(student);

    }

    @Test
    void  test2(){
        User user = new User();
        user.setUsername("高举");
        user.setPassword("123456");
        userSvc.modifyUser(user);
    }

    @Test
    void  test3(){
        Student student = new Student();
        student.setSno("l");
        student.setSname("哦");
        List<Student> studentList = studentSvc.findStudentList(student);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }

    }

}

