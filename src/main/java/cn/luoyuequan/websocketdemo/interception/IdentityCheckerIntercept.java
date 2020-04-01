package cn.luoyuequan.websocketdemo.interception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 身份检查拦截器
 * </p>
 *
 * @author luoyuequan
 * @date 2020/04/01
 * @time 11:07
 */
@Component
public class IdentityCheckerIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(true);
        Object identity = session.getAttribute("identity");
        // 未登录，重定向与登录界面
        if (identity == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
