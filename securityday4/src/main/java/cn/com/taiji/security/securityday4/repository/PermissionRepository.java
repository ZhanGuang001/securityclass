package cn.com.taiji.security.securityday4.repository;

import cn.com.taiji.security.securityday4.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    Permission findByUrl(String url);
}
