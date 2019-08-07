package cn.com.taiji.security.securityday3.service;

import cn.com.taiji.security.securityday3.domain.UserInfo;

public interface UserInfoService {

    UserInfo findByUsername(String username);
}
