package cn.com.taiji.security.securityday2.service.Impl;

import cn.com.taiji.security.securityday2.domain.UserDomain;
import cn.com.taiji.security.securityday2.repository.UserDomainRepository;
import cn.com.taiji.security.securityday2.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: securityclass
 * @description: Userimpl
 * @author: qiao zhan guang
 * @create: 2019-08-02 16:24
 */
@Service
public class UserDomainServiceImpl  implements UserDomainService {
    @Autowired
    private UserDomainRepository userInfoRepository;
    @Override
    public UserDomain findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
}
