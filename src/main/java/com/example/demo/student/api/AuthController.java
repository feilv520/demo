package com.example.demo.student.api;

import com.example.demo.student.dal.UserRoleMapper;
import com.example.demo.student.domain.UserRole;
import com.example.demo.student.dto.LoginDto;
import com.example.demo.student.dto.RegisterDto;
import com.example.demo.student.dto.UserDto;
import com.example.demo.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    @Resource
    private UserService userService;

    @Resource
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        UserDto user = userService.getUserByUserName(registerDto.getUsername());
        if (user != null) {
            return new ResponseEntity<>("用户已存在", HttpStatus.BAD_REQUEST);
        }

        userService.resigter(registerDto);
        return new ResponseEntity<>("注册成功", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>(authenticate, HttpStatus.OK);
    }
}
