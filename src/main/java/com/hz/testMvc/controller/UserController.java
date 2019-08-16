package com.hz.testMvc.controller;

import com.hz.testMvc.req.PageReq;
import com.hz.testMvc.resp.ResponseData;
import com.hz.testMvc.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户查询控制器
 */
@Controller
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/showUser.do")
    public String showUser(){
        return "UserList";
    }

    @ResponseBody
    @RequestMapping("/findUserListServlet")
    public ResponseData findUserListServlet(@RequestParam(value="page") String page, @RequestParam("limit") String limit){
        logger.info("----接受到-findUserListServlet 请求,page:{},limit:{}",page,limit);

        ResponseData responseData = null;
        try {
            PageReq req = new PageReq();
            req.setPage(page);
            req.setLimit(limit);
            responseData = iUserService.getUserInfo(req);
        } catch (Exception e) {
            logger.error("Exception",e);
            responseData.setMsg("请求超时");
            responseData.setCode("-1"); //代表请求失败
            return responseData;
        }
        return responseData;
    }


}
