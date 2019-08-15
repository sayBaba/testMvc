package com.hz.testMvc.controller;

import com.hz.testMvc.req.User;
import com.hz.testMvc.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("/testSsm")
    @ResponseBody
    public User testSsm(){
        logger.info("接受到test请求..........");
        User user = new  User();
        try {
            String xx = testService.getUserInfo();
            logger.info("xx的值:{}",xx);
            user.setName(xx);
        }catch (Exception e){
            logger.error("Exception",e);
        }
        return user;
    }
}
