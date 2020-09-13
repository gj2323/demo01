package com.gao.service;

import com.gao.entity.Student;
import com.gao.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentSvcImpl implements StudentSvc {


    @Resource
    private StudentMapper studentMapper;
    @Override
    public List<Student> selectStudentList() {
        return studentMapper.selectStudentList();
    }

    @Override
    public Student selectStudent(String sno) {
        return studentMapper.selectStudent(sno);
    }

    @Override
    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public void deleteStudent(String sno) {
        studentMapper.deleteStudent(sno);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> findStudentList(Student student) {
        return studentMapper.findStudentList(student);
    }
}
