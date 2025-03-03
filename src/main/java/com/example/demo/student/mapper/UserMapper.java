package com.example.demo.student.mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.student.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author my
* @description 针对表【user】的数据库操作Mapper
* @createDate 2025-03-03 16:38:58
* @Entity com.example.demo.student.domain.User
*/
public interface UserMapper extends BaseMapper<User> {
    User findOneByUsername(@Param("username") String username);
}




