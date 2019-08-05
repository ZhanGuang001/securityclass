package cn.com.taiji.security.securityday2.extend;

import cn.com.taiji.security.securityday2.domain.UserDomain;
import cn.com.taiji.security.securityday2.repository.UserDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @program: securityclass
 * @description: datainit
 * @author: qiao zhan guang
 * @create: 2019-08-02 16:46
 */
/*@Service
public class DataInit {
    @Autowired
    private UserDomainRepository userDomainRepository;

    @PostConstruct
    public void datainit(){
        UserDomain user=new UserDomain();
        user.setUsername("u");
        user.setPassword("1");
        user.setRole(UserDomain.Role.ROLE_USER);
        userDomainRepository.saveAndFlush(user);

        UserDomain admin=new UserDomain();
        admin.setUsername("a");
        admin.setPassword("1");
        admin.setRole(UserDomain.Role.ROLE_ADMIN);
        userDomainRepository.saveAndFlush(admin);
    }


}*/
