package com.hz.testMvc.service.impl;

import com.hz.testMvc.controller.TestController;
import com.hz.testMvc.dao.TestMapper;
import com.hz.testMvc.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
     private TestMapper testMapper;

    private final static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);


    @Override
    public String getUserInfo() {
        logger.info("-------TestServiceImplz执行----getUserInfo---");
        return testMapper.testQuery();
    }

    @Override
    public String getUser() {
        return "";
    }
}
