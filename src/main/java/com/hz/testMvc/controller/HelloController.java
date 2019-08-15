package com.hz.testMvc.controller;

import com.hz.testMvc.req.ListData;
import com.hz.testMvc.req.LoginReq;
import com.hz.testMvc.resp.LoginResp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/say")
public class HelloController {

    /**
     * hello
     */
//    @RequestMapping("hello")
    @RequestMapping(value="/item")
    public ModelAndView hello(){
        System.out.println("收到hello请求.......");
        ModelAndView view = new ModelAndView();
        view.addObject("helloMsg","hello SpringMvc");
        view.setViewName("show");
        return view;
    }

    @RequestMapping("/editItem")
    public String editItem(@RequestParam(value="item_id",required=true) String id) {
        System.out.println("---------------------id---"+ id);
        int a = 100/0;
        return id;
    }
//    /viewItems/111/222
    @RequestMapping("/viewItems/{id}/{id1}")
    public void viewItems(@PathVariable("id") int id,@PathVariable("id1") int id1, Model model) throws Exception{
        System.out.println("=========viewItems id===="+ id);
    }


    @RequestMapping("/hello1")
    public void hello1(@RequestBody(required=false) LoginReq data){
        System.out.println("收到hello1请求......."+ data);
    }


    @ResponseBody
    @RequestMapping("/reqBody")
    public LoginResp testReqBody(){
        LoginResp  loginResp = new LoginResp();
        loginResp.setName("xiaozhang");
        loginResp.setUserId("789808080");
        return  loginResp;
    }
}
