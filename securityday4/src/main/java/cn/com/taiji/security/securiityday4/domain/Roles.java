package cn.com.taiji.security.securiityday4.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: securityclass
 * @description: role
 * @author: qiao zhan guang
 * @create: 2019-08-05 09:48
 */
@Entity
public class Roles {
        @Id
        @GeneratedValue
        private long rid;//主键.
        private String roleName;//角色名称.
        private String description;//角色描述.

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
