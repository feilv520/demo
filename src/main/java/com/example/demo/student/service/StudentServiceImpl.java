package com.example.demo.student.service;

import com.example.demo.student.domain.Student;
import com.example.demo.student.dal.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

//    @Override
//    public List<Student> getStudents() {
//        Student student = new Student();
//        student.setId(1L);
//        student.setAge(21);
//        student.setEmail("student@gmail.com");
//        student.setName("student");
//        DateTime dirthday = DateUtil.parse("2020-01-01", "yyyy-MM-dd");
//        student.setBirthday(dirthday);
//        return ListUtil.of(student);
//    }

    @Override
    public List<Student> getStudents() {
        return studentMapper.selectList(null);
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        Student s = studentMapper.selectByEmail(student.getEmail());
        if (s != null) {
            throw new IllegalStateException("email 已存在");
        }
        studentMapper.insert(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void updateStudent(Long studentId, Student student) {
        Student s = studentMapper.selectById(studentId);
        if (s == null) {
            throw new IllegalStateException("用户不存在");
        }
        studentMapper.update(student, null);
    }
}
