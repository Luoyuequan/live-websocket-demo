package cn.luoyuequan.websocketdemo.interception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p></p>
 *
 * @author luoyuequan
 * @date 2020/04/01
 * @time 11:19
 */
@Configuration
@EnableWebMvc
public class InterceptionConfig implements WebMvcConfigurer {
    private final IdentityCheckerIntercept identityCheckerIntercept;

    public InterceptionConfig(IdentityCheckerIntercept identityCheckerIntercept) {
        this.identityCheckerIntercept = identityCheckerIntercept;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(identityCheckerIntercept).addPathPatterns("/user/**");
    }
}
