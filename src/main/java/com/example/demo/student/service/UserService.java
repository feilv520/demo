package com.example.demo.student.service;

import com.example.demo.student.domain.User;
import com.example.demo.student.dto.RegisterDto;
import com.example.demo.student.dto.UserDto;

/**
* @author my
* @description 针对表【user】的数据库操作Service
* @createDate 2025-03-03 16:38:58
*/
public interface UserService {
    void resigter(RegisterDto registerDto);

    UserDto getUserByUserName(String username);
}
