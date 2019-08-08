package cn.com.taiji.security.securityday7.extend;

import org.springframework.security.core.AuthenticationException;

/**
 * @program: securityclass
 * @description: 验证码校验
 * @author: qiao zhan guang
 * @create: 2019-08-07 23:07
 */
public class VerificationCodeException extends AuthenticationException {
    public VerificationCodeException() {
        super("图形验证码校验失败");
    }
}
