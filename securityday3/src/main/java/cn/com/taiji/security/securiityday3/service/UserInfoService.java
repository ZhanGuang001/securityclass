package cn.com.taiji.security.securiityday3.service;

import cn.com.taiji.security.securiityday3.domain.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);
}
