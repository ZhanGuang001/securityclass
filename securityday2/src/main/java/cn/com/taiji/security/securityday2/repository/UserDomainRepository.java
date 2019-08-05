package cn.com.taiji.security.securityday2.repository;

import cn.com.taiji.security.securityday2.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: securityclass
 * @description: userrepository
 * @author: qiao zhan guang
 * @create: 2019-08-02 16:19
 */
public interface UserDomainRepository extends JpaRepository<UserDomain,Long> {
    UserDomain findByUsername(String username);
}
