package cn.com.taiji.security.securiityday3.extend;

import cn.com.taiji.security.securiityday3.domain.Roles;
import cn.com.taiji.security.securiityday3.domain.UserInfo;
import cn.com.taiji.security.securiityday3.repository.UserInfoRepository;
import cn.com.taiji.security.securiityday3.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: securityclass
 * @description: UserDetailsService
 * @author: qiao zhan guang
 * @create: 2019-08-02 16:44
 */
@Component
public class UserDetail implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("UserDetail.loadUserByUsername()");
        //通过username获取用户信息
        UserInfo userInfo =userInfoService.findByUsername(s);
        if(userInfo == null) {
            throw new UsernameNotFoundException("not found");
        }
        //定义权限列表.
        List<GrantedAuthority> authorities = new ArrayList<>();
       //用户可以访问的资源名称（权限）注意：必须"ROLE_"开头
        for(Roles roles: userInfo.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
        }
        User userDetails = new User(userInfo.getUsername(),userInfo.getPassword(),authorities);
        return userDetails;
    }
}
