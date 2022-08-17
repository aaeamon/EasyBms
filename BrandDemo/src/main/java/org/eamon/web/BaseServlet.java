package org.eamon.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 这是一个给子类用的基石父类简称基类，帮子类把doGet和doPost做完
 *
 * @author Eamon
 */

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //先拿到短的地址
        String requestUri = req.getRequestURI();
        //把最后一个/后面的地址找到
        String methodName = requestUri.substring(requestUri.lastIndexOf("/") + 1);
        //利用反射获取类本身的方法
        try {
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            //由于没有找到方法则打印一句话
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("Have no method！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}
