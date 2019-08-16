package com.hz.testMvc.dao;

import com.hz.testMvc.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserMapper {

    /**
     * 分页查询
     * @param page
     * @param limit
     */
    List<SysUser> selectUserInfo(@Param("page") Integer page, @Param("limit")Integer limit);

    /**
     * 统计数量
     */
     int countUserNum();

    
}
