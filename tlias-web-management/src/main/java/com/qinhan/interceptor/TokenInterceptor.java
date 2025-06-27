package com.qinhan.interceptor;

import com.qinhan.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 令牌教研拦截器
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //// 1.获取请求路径
        //String requestURI = request.getRequestURI();
        //// 2.判断是否是登录请求
        //if (requestURI.contains("/login")) {
        //    log.info("登录请求，放行");
        //    return true;
        //}
        // 3.获取请求头中的token
        String token = request.getHeader("token");
        // 4.判断token是否存在
        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // 5.校验令牌
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // 6.校验通过
        log.info("令牌合法，放行");
        return true;


    }
}
