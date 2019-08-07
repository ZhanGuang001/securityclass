package cn.com.taiji.security.securiityday4.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @program: securityclass
 * @description: user
 * @author: qiao zhan guang
 * @create: 2019-08-05 09:48
 */
@Entity
public class UserInfo {
    @Id
    @GeneratedValue
    private long uid;//主键.
    private String username;//用户名.
    private String password;//密码.
    //用户－－角色：多对多的关系．
    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "UserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "rid") })
    private List<Roles> roles;

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

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
