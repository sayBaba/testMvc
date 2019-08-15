package com.hz.testMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/**
 * 国际化
 */
@Controller
@RequestMapping(value = "/global")
public class GlobalController {

    /**
     *
     * @return
     */
    @RequestMapping(value="/test", method = {RequestMethod.GET})
    public ModelAndView test(@RequestParam(value="langType", defaultValue="zh")String langType,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        if("zh".equals(langType)){
            Locale locale = new Locale("zh", "CN");
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);

        } else if("en".equals(langType)){
            Locale locale = new Locale("en", "US");
            //存放语言到session中
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
        }

       //从后台代码获取国际化信息
        RequestContext requestContext = new RequestContext(request);
        //读取配置
        modelAndView.addObject("money",  requestContext.getMessage("money"));
        modelAndView.addObject("date",  requestContext.getMessage("date"));

        HashMap map = new HashMap();
        map.put("money","666");
        map.put("date",new Date());
        modelAndView.addObject("map",map);
        modelAndView.setViewName("globalTest");
        return modelAndView;
    }


}
