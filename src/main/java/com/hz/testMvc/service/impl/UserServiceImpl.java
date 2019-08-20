package com.hz.testMvc.service.impl;


import com.hz.testMvc.req.PageReq;
import com.hz.testMvc.resp.ResponseData;
import com.hz.testMvc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 查询用户相关信息接口实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public ResponseData getUserInfo(PageReq req) throws Exception {
        return null;
    }
}
