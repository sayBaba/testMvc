package com.hz.testMvc.controller;

import com.hz.testMvc.req.LoginReq;
import com.hz.testMvc.req.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestModuleAndView {

    ModelAndView mv = new ModelAndView();
    @RequestMapping("/testMav")
    public ModelAndView test(){
        mv=new ModelAndView();
        mv.setViewName("welcom"); //返回的文件名

        User user = new User();
        user.setAge(20);
        user.setName("nihao");
        mv.addObject("user",user);

        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("oracle");
        mv.addObject("bookList", list);

        Map<String,String> map = new HashMap<String,String>();
        map.put("zhangsan", "北京");
        map.put("lisi", "上海");
        map.put("wangwu", "深圳");
        mv.addObject("map",map);

        return mv;
    }

    @RequestMapping("/testSer")
    public void  testSer(ServletRequest request, ServletResponse response){

        User user = new User();
        user.setAge(20);
        user.setName("nihao");
//        mv.addObject("user",user);
        request.setAttribute("user",user);

        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("oracle");
        mv.addObject("bookList", list);

        Map<String,String> map = new HashMap<String,String>();
        map.put("zhangsan", "北京");
        map.put("lisi", "上海");
        map.put("wangwu", "深圳");
        mv.addObject("map",map);

        try {
            request.getRequestDispatcher("welcom1.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/item/editItem")
    public String testRerunStr(ModelMap model){
        User user = new User();
        user.setAge(20);
        user.setName("xiaoZhang");
        model.addAttribute("user",user);
        return "item/editItem";
    }

        @RequestMapping("/item/login")
        public void testModel(LoginReq loginReq){
          System.out.println("----================-------"+loginReq.getUserName());
            System.out.println("----================-------"+loginReq.getPrice());
            System.out.println("----================-------"+loginReq.getItem_id());


//        User user = (User) model.asMap().get("user");
//        System.out.println("----"+user.getName());
    }
    @RequestMapping("/rdt")
    public String rdt(){
        return " return \"redirect:/ss\":/ss";
    }

    @RequestMapping("/ss")
    public String ss(){
       return "success";
    }
}
