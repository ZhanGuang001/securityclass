package cn.com.taiji.security.securityday7.service;

import cn.com.taiji.security.securityday7.domain.UserInfo;

public interface UserInfoService {

    UserInfo findByUsername(String username);
}
