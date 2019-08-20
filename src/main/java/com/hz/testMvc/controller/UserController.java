package com.hz.testMvc.controller;


import com.hz.testMvc.model.UserBean;
import com.hz.testMvc.service.impl.TestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户查询控制器
 */
@Controller
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private TestServiceImpl testServiceImpl;

    @RequestMapping("/toUserList")
    public String toUserList(){
        return "UserList";
    }

    @ResponseBody
    @RequestMapping("/queryLike")
    public List<UserBean> queryLike(String name){
        //接收条件查询
       return testServiceImpl.queryLike(name);
    }

    @ResponseBody
    @RequestMapping("/queryLimit")
    public List<UserBean> queryLimit(@RequestParam("page") Integer page, Integer limit){

        //分页查询
        List<UserBean> listLimit = testServiceImpl.queryLimit(page, limit);
        return listLimit;
    }


    @RequestMapping("/insertOne")
    public String insertOne(UserBean userBean){
        try{
            int count = testServiceImpl.insertOne(userBean);
            if(count<1)
                throw new RuntimeException("增加失败");
        }catch(Exception ex){return "errMsg";}

        return "success";
    }

    @RequestMapping("/deleteOne")
    public String deleteOne(Integer id){
        try{
            int count = testServiceImpl.deleteOne(id);
            if(count<1)
                throw new RuntimeException("增加失败");
        }catch(Exception ex){return "errMsg";}

        return "success";
    }

    @RequestMapping("/updateOne")
    public String updateOne(UserBean userBean){
        try{
            int count = testServiceImpl.updateOne(userBean);
            if(count<1)
                throw new RuntimeException("增加失败");
        }catch(Exception ex){return "errMsg";}

        return "success";
    }


//    public Integer deleteSome(Integer[] ids){
//
//    }
}
