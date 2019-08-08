package cn.com.taiji.security.securityday7.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @program: securityclass
 * @description: 资源与uid
 * @author: qiao zhan guang
 * @create: 2019-08-05 14:33
 */
@Entity
public class Permission {
    @Id
    @GeneratedValue
    private long pid;
    //权限链接
    private String url;
    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "PermissionRole", joinColumns = { @JoinColumn(name = "pid") }, inverseJoinColumns ={@JoinColumn(name = "rid") })
    private List<Roles> roles;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
