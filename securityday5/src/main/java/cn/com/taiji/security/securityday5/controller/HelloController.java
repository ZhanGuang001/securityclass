package cn.com.taiji.security.securityday5.controller;

import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @program: security
 * @description: security
 * @author: qiao zhan guang
 * @create: 2019-08-01 10:27
 */
@Controller
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/index")
    public String index(){
        return "logout";
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

    @GetMapping("/a")
    @ResponseBody
    public String a(){
       return restTemplate.getForObject("http://www.baidu.com/",String.class);
    }

    @GetMapping("/b")
    @ResponseBody
    public String b(){
        return "访问成功";}

    @PutMapping("/b")
    @ResponseBody
    public String bb(@RequestParam Map map){
        return "增加成功";}

    // http method,url path
    // 1 = get /login , 2=post,login
    // Restfulg规范
}
