package cn.com.taiji.security.securiityday3.config;

import cn.com.taiji.security.securiityday3.domain.Permission;
import cn.com.taiji.security.securiityday3.domain.Roles;
import cn.com.taiji.security.securiityday3.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: securityclass
 * @description: 动态权限
 * @author: qiao zhan guang
 * @create: 2019-08-05 14:28
 */
@Component
public class CustomerAuthService {
    @Autowired
    private PermissionRepository permissionRepository;

    public Boolean canAccess(HttpServletRequest request, Authentication authentication){
           Object principal=authentication.getPrincipal();
        // 动态鉴权逻辑
        // 1. 先判断当前的用户有没有认证过
        // 2. 如果是匿名的角色 ROLE_ANONYMOUS
           if (principal==null||"anonymousUser".equals(principal)){
               return false;
           }
           String url=request.getRequestURI();
        Permission permission=permissionRepository.findByUrl(url);
        // 3. 动态鉴权逻辑
        // UserInfo
        // Role
        // Permission uid，url接口  的对应关系
        if(permission == null || CollectionUtils.isEmpty(permission.getRoles())){
            return false;
        }

        request.getParameterMap();
        for (Roles roles : permission.getRoles()) {
            // 如果authentication当前用户拥有这个role角色，则返回true
            if(CollectionUtils.isEmpty(authentication.getAuthorities())){
                return false ;
            }

            for (GrantedAuthority authority : authentication.getAuthorities()) {
                //如果用户拥有访问某个url的权限的角色，就允许
                if(roles.getRoleName().equals(authority.getAuthority())){
                    return true ;
                }
            }
        }

        return false;
    }
}
