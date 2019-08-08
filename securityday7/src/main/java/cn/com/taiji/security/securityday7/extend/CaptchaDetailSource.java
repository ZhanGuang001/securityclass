package cn.com.taiji.security.securityday7.extend;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: securityclass
 * @description: 数据源
 * @author: qiao zhan guang
 * @create: 2019-08-07 23:11
 */
public class CaptchaDetailSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new CaptchaAuthenticationDetails(context);
    }
}
