package com.example.demo.student.service;

import com.example.demo.student.domain.Student;

import java.util.List;

public interface StudentService {
    /**
     * 学生信息列表查询
     * @return
     */
    List<Student> getStudents();

    /**
     * 保存学生信息
     * @return
     */
    void saveStudent(Student student);

    /**
     * 删除学生信息
     * @return
     */
    void deleteStudent(Long id);

    /**
     * 更新学生信息
     * @return
     */
    void updateStudent(Long studentId, Student student);
}
