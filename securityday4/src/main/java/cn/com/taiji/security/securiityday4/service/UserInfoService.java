package cn.com.taiji.security.securiityday4.service;

import cn.com.taiji.security.securiityday4.domain.UserInfo;

public interface UserInfoService {

    UserInfo findByUsername(String username);
}
