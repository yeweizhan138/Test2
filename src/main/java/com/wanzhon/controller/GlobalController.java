package com.wanzhon.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

import com.wanzhon.model.User;


@Controller
@RequestMapping(value = "/global")
public class GlobalController {
    
    @RequestMapping(value="/test", method = {RequestMethod.GET})
    public String test(HttpServletRequest request,Model model){
        if(!model.containsAttribute("contentModel")){
            
            //从后台代码获取国际化信息
            RequestContext requestContext = new RequestContext(request);
            model.addAttribute("username", requestContext.getMessage("username"));
            model.addAttribute("birth", requestContext.getMessage("birth"));

            
            User user = new User();

            user.setUsername("叶伟展");
            user.setBirth(new Date());
       
            model.addAttribute("contentModel", user);
        }
        return "globaltest";
    }
    
}