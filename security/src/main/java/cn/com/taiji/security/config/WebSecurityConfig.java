package cn.com.taiji.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @program: security
 * @description: webSecurityConfig
 * @author: qiao zhan guang
 * @create: 2019-08-01 11:11
 */
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private Logger logger= LoggerFactory.getLogger(WebSecurityConfig.class);
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("my config");

        http.authorizeRequests()
                .antMatchers("/css/**","/error").permitAll()//对静态资源css通过验证
                .antMatchers("/user").hasRole("User")//对user授权
                .antMatchers("/admin").hasRole("admin")//对admin授权
                .anyRequest().authenticated()//对所有请求都进行验证
                .and()//结束一种配置
                .formLogin()//进行表单登录验证
                .loginPage("/login")//进入自定义登录界面
                .successHandler(new ForwardAuthenticationSuccessHandler("/index"))//登录成功则跳转该页面

                /*.successHandler((httpServletRequest, httpServletResponse, authentication) -> {//登录成功则提示成功信息
                    httpServletResponse.setContentType("application/json;character=UTF-8");
                    httpServletResponse.getWriter().write("{登录成功}");*/
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {//登录失败后进入失败的界面
                    httpServletResponse.setContentType("application/json;charset=UTF-8");
                    httpServletResponse.setStatus(401);
                    httpServletResponse.getWriter().write("{用户名或密码错误}"); })
                .permitAll()
                .passwordParameter("password");//设置密码传参时的key值
              //.httpBasic();//进行basic登录
                http.csrf().disable();//登录
    }

    @Bean
    //设置用户名和密码
    public UserDetailsService userDetailsService(){
        String password=passwordEncoder().encode("1");
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("u")
                .password(password)
                .roles("User")
                .build());
        manager.createUser(User.withUsername("a")
                .password(password)
                .roles("admin")
                .build());
        return manager;
    }

    @Bean
    //编译后的密码
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();//密码算法类型
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//        web.ignoring().antMatchers("/css/**");//配置静态资源常规方法
//    }
}
