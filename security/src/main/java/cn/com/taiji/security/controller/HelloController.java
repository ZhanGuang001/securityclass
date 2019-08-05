package cn.com.taiji.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: security
 * @description: security
 * @author: qiao zhan guang
 * @create: 2019-08-01 10:27
 */
@Controller
public class HelloController {

    @PostMapping("/index")
    @ResponseBody
    public String index(){
        return "hello world";
    }

    @GetMapping("/login")
    public String hello(){
        return "login";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(){
        return "user";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin";
    }


    // http method,url path
    // 1 = get /login , 2=post,login
    // Restfulg规范
}
