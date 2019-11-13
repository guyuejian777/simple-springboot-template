package com.dajian.interceptor;

import com.dajian.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 86156
 * @date 2019/7/21
 */
@Component
@Aspect
public class MyInterceptor {
    @Pointcut("within (com.dajian.controller..*) && !within(com.dajian.controller.admin.LoginController)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object trackInfo(ProceedingJoinPoint joinPoint) throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            System.out.println("----用户名未登录----");
            //跳转 到/login映射路径
            attributes.getResponse().sendRedirect("/login");
        }
        System.out.println("-----用户已登录-----");
        /*
        必须返回指定的Object返回值，若AOP拦截的Controller  return了一个视图地址，
        那么本来Controller应该跳转到这个视图地址的，但是被AOP拦截了，那么
        原来Controller仍会执行return， 但是视图地址却找不到404了
         */
        //切记一定要调用process()方法
        // process():执行被通知的方法， 如不调用将会阻止被调用的方法的调用，也就导致Controller中的renturn会404
        return joinPoint.proceed();
    }

}
