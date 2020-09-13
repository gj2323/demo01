package com.gao.service;

import com.gao.entity.Student;

import java.util.List;

public interface StudentSvc {
    public List<Student> selectStudentList();
    public Student selectStudent(String sno);
    public  void  insertStudent(Student student);
    public  void deleteStudent(String sno);
    public  void  updateStudent(Student student);
    public  List<Student>  findStudentList(Student student);
}
