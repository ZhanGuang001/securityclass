package cn.com.taiji.security.securityday2.service;

import cn.com.taiji.security.securityday2.domain.UserDomain;

public interface UserDomainService {
    public UserDomain findByUsername(String username);
}
