package cn.com.taiji.security.securiityday3.config;

import cn.com.taiji.security.securiityday3.extend.UserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;

import javax.sql.DataSource;


/**
 * @program: security
 * @description: webSecurityConfig
 * @author: qiao zhan guang
 * @create: 2019-08-01 11:11
 */
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private Logger logger= LoggerFactory.getLogger(WebSecurityConfig.class);

   @Autowired
   private DataSource dataSource;

   @Autowired
   private UserDetail userDetail;

    @Override
    //设置用户名和密码
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // super.configure(auth);
        /*String password=passwordEncoder().encode("1");
        auth.jdbcAuthentication().dataSource(dataSource)
                .withUser("u").password(password).roles("user")
                .and()
                .withUser("a").password(password).roles("admin");*/
//        auth.jdbcAuthentication().dataSource(dataSource).and()
//                .userDetailsService(userDetail);
        auth.userDetailsService(userDetail).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("my config");

        http.authorizeRequests()
                .antMatchers("/css/**","/error").permitAll()//对静态资源css通过验证
                /*.antMatchers("/user").hasRole("ROLE_USER")//对user授权
                .antMatchers("/admin").hasRole("ROLE_ADMIN")//对admin授权*/
                .anyRequest().access("@customerAuthService.canAccess(request,authentication)")
               /* .anyRequest().authenticated()//对所有请求都进行验证*/
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

    /*@Bean
    //设置用户名和密码
    public UserDetailsService userDetailsService(){
        String password=passwordEncoder().encode("1");
        JdbcUserDetailsManager manager=new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        manager.createUser(UserInfo.withUsername("u")
                .password(password)
                .roles("user")
                .build());
        manager.createUser(UserInfo.withUsername("a")
                .password(password)
                .roles("admin")
                .build());
        return manager;
    }*/

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
