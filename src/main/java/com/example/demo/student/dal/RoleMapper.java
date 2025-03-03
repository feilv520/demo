package com.example.demo.student.dal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.example.demo.student.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author my
* @description 针对表【role】的数据库操作Mapper
* @createDate 2025-03-03 12:49:45
* @Entity com.example.demo.student.domain.Role
*/
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> findAllByIdIn(@Param("idList") Collection<Long> idList);
}




