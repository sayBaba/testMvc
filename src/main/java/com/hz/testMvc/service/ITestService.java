package com.hz.testMvc.service;

import com.hz.testMvc.model.UserBean;

import java.util.List;

public interface ITestService {
    //条件查询
    public List<UserBean> queryLike(String name);

    //分页查询
    public List<UserBean> queryLimit(Integer currentPage, Integer limit);

    //删除一行
    public int deleteOne(Integer id);

    //增加一行
    public int insertOne(UserBean userBean);

    //修改数据
    public int updateOne(UserBean userBean);

    //批量删除
    public int deleteSome(Integer[] ids);
}
