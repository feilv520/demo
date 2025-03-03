package com.example.demo.student.dal;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.student.domain.Student;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper extends BaseMapper<Student> {

    @Select("select * from student.student where email = #{emil}")
    Student selectByEmail(String email);

    @Select("select * from student.student where id = #{studentId}")
    Student selectById(Long studentId);
}
