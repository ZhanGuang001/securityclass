package cn.com.taiji.security.securiityday3.repository;

import cn.com.taiji.security.securiityday3.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    //@Query("select u from UserInfo u where username=:username")
    UserInfo findByUsername(String username);
}
