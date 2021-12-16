package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Ping
 * @Date: 2021-12-12 14:51
 * @Description: 自定义Servlet，使用请求路径进行方法分发，替换HttpServlet的根据请求方式进行方法分发
 * 自定义的servlet都继承了HttpServlet，而请求方法都是通过HttpServlet中的service()方法根据请求方式进行分发，所以重写HttpServlet中的service()方法
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径中的方法名
        String requestURI = req.getRequestURI();// /brand-case/brand/selectAll
        int i = requestURI.lastIndexOf('/');
        String methodName = requestURI.substring(i + 1);
        //2.执行调用BaseServlet对象对应的方法,通过this（谁调用该方法，this就是谁）
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class); //获取方法对象
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
