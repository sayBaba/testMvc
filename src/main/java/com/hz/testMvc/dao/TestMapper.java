package com.hz.testMvc.dao;

import com.hz.testMvc.model.UserBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {

    //条件查询

    public List<UserBean> queryLike(@Param("name") String name );

    //分页查询
    @Select("select USER_ID AS userId,\n" +
            "        LOGIN_NAME AS loginName,\n" +
            "        LOGIN_PWD AS loginPwd,\n" +
            "        USER_NAME AS userName,\n" +
            "        STATUS AS STATUS,\n" +
            "        EMAIL AS email,\n" +
            "        ADDRESS AS address,\n" +
            "        REMARK AS remark from sys_user limit ${currentPage},${limit}" )
    public List<UserBean> queryLimit(@Param("currentPage") Integer currentPage,@Param("limit") Integer limit);

    //删除一行
    @Delete("delete from sys_user where id = ${id}")
    public  int deleteOne(@Param("id")Integer id);

    //增加一行
    @Insert("insert into sys_user(LOGIN_NAME,LOGIN_PWD"+
                    "USER_NAME,STATUS,EMAIL,ADDRESS,REMARK) values(" +
                    "${loginName},${loginPwd},${userName},${status}," +
                    "${email},${address},${remark},)")
    public int insertOne(UserBean userBean);

    //修改数据
    @Update("update sys_user set "+
            "LOGIN_NAME=${loginName},LOGIN_PWD=${loginPwd},USER_NAME=${userName},STATUS=${status}," +
            "EMAIL=${email},ADDRESS=${address},REMARK=${remark},)")
    public int updateOne(UserBean userBean);

    @Delete("delete from sys_user where id = ")
    public int deleteSome(Integer[] ids);
}
