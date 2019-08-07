package cn.com.taiji.security.securityday5.service.Impl;

import cn.com.taiji.security.securityday5.domain.UserInfo;
import cn.com.taiji.security.securityday5.repository.UserInfoRepository;
import cn.com.taiji.security.securityday5.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: securityclass
 * @description: userInfoServiceImpl
 * @author: qiao zhan guang
 * @create: 2019-08-05 10:55
 */
@Service
public class USerInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
}
