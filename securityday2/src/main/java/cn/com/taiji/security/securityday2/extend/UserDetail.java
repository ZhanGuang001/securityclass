package cn.com.taiji.security.securityday2.extend;

import cn.com.taiji.security.securityday2.domain.UserDomain;
import cn.com.taiji.security.securityday2.service.UserDomainService;
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
    private UserDomainService userDomainService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("UserDetail.loadUserByUsername()");
        //通过username获取用户信息
        UserDomain userDomain = userDomainService.findByUsername(s);
        if(userDomain == null) {
            throw new UsernameNotFoundException("not found");
        }
        //定义权限列表.
        List<GrantedAuthority> authorities = new ArrayList<>();
        //用户可以访问的资源名称（或者说用户所拥有的权限)注意：必须"ROLE_"开头
        authorities.add(new SimpleGrantedAuthority(userDomain.getRole().name()));
        User userDetails = new User(userDomain.getUsername(),passwordEncoder.encode(userDomain.getPassword()),authorities);
        return userDetails;
    }
}
