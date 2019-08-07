package cn.com.taiji.security.securityday6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @program: securityclass
 * @description: oauth2的测试
 * @author: qiao zhan guang
 * @create: 2019-08-07 15:23
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(Principal principal) {
        return "hello，" + principal.getName();
    }

    @GetMapping("/")
    public String a(Principal principal) {
        return "hello，" + principal.getName();
    }
}
