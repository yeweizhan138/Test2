package com.wanzhon.controller;



import java.util.Map;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wanzhon.model.User;
//表单的验证控制器
@Controller
@RequestMapping("/form")
public class ValidationController {
    @RequestMapping(value="/add",method=RequestMethod.POST)    
    public String add(@Valid User u,BindingResult br){
        if(br.getErrorCount()>0){            
            return "hello";
        }
        return "showUser";
    }
     
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String add(Map<String,Object> map){
        map.put("user",new User());
        return "addUser";
    }
}