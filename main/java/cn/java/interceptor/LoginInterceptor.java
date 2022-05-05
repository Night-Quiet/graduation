package cn.java.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */

//自定义一个拦截器，要继承HandlerInterceptor接口，并重写里面的方法
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //如果是登录页面则放行
        if(requestURI.indexOf("login") >= 0) {
            return true;
        }
        HttpSession session = request.getSession();
        //如果用户已登录也放行
        if (session.getAttribute("activeUser") != null) {
            return true;
        }
        //用户没有登录跳转到登录页面
        request.getRequestDispatcher("login").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
