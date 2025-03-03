package com.example.demo.student.dal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.example.demo.student.domain.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author my
* @description 针对表【user_role】的数据库操作Mapper
* @createDate 2025-03-03 12:49:45
* @Entity com.example.demo.student.domain.UserRole
*/
public interface UserRoleMapper extends BaseMapper<UserRole> {
    List<UserRole> findAllByUserId(@Param("userId") Long userId);
}




