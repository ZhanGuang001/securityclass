package cn.com.taiji.security.securityday2.domain;

import javax.persistence.*;

/**
 * @program: securityclass
 * @description: user
 * @author: qiao zhan guang
 * @create: 2019-08-02 16:15
 */
@Entity
public class UserDomain {
    public enum Role{
        ROLE_ADMIN,ROLE_USER
    }
    @Id
    @GeneratedValue
    private long uid;//主键.
    private String username;//用户名.
    private String password;//密码.
    @Enumerated(EnumType.STRING)
    private Role role;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
