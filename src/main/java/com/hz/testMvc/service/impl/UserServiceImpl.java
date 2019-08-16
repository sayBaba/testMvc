package com.hz.testMvc.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.hz.testMvc.dao.IUserMapper;
import com.hz.testMvc.model.SysUser;
import com.hz.testMvc.req.PageReq;
import com.hz.testMvc.resp.ResponseData;
import com.hz.testMvc.resp.UserData;
import com.hz.testMvc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询用户相关信息接口实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    IUserMapper iUserMapper;

    @Override
    public ResponseData getUserInfo(PageReq req)throws Exception {
        Integer page = Integer.parseInt(req.getPage());
        Integer limit = Integer.parseInt(req.getLimit());
        logger.info("请求参数：page:{},limit:{}",page,limit);
        int page1 = (page-1)*limit;
//
        ResponseData responseData = new ResponseData();
        List<SysUser> list = iUserMapper.selectUserInfo(page1,limit);
        if(list.size()<=0){
            return responseData;
        }
//
        List<UserData> dataList = new ArrayList<UserData>();
        for (int i =0 ;i<list.size();i++){
            UserData userData = new UserData();
//            userData.setAddress(list.get(i).getAddress());
//            //复制值给另外一个对象中属性一样的
            BeanUtils.copyProperties(list.get(i),userData);
            dataList.add(userData);
        }
        responseData.setData(dataList); //存放数据
        responseData.setCode("0"); // 0为成功
        responseData.setCount(iUserMapper.countUserNum()); // 设置总数量
        responseData.setMsg("请求成功");
        return responseData;
    }
}
