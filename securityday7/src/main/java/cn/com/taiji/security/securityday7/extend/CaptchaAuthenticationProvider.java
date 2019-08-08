package cn.com.taiji.security.securityday7.extend;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: securityclass
 * @description:自定处理图形验证码
 * @author: qiao zhan guang
 * @create: 2019-08-07 23:18
 */
public class CaptchaAuthenticationProvider extends DaoAuthenticationProvider {
    public CaptchaAuthenticationProvider(UserDetailsService userDetailsService,
                                         PasswordEncoder passwordEncoder) {
        // 把构造方法注入 UserDetailService 和 PasswordEncoder
        this.setUserDetailsService(userDetailsService);
        this.setPasswordEncoder(passwordEncoder);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
            throws AuthenticationException {
        //实现图形验证码的校验逻辑
        CaptchaAuthenticationDetails details =
                (CaptchaAuthenticationDetails) usernamePasswordAuthenticationToken.getDetails();

        // 发现验证码不正确，就立刻抛出相应异常信息
        if (!details.getImageCodeIsRight()) {
            throw new VerificationCodeException();
        }

        // 调用父类方法完成密码验证
        super.additionalAuthenticationChecks(userDetails,
                usernamePasswordAuthenticationToken);
    }
}