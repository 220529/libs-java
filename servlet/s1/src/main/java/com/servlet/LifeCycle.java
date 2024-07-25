package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycle extends HttpServlet {
    public LifeCycle() {
        System.out.println("LifeCycle constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifeCycle init");
    }

    @Override
    public void destroy() {
        System.out.println("LifeCycle destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求和响应的字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 获取请求参数
        String name = req.getParameter("name");

        // 创建响应 HTML 内容
        String html = "<span style='color:red'>hi，life_cycle，" + name + "!</span><hr/>";

        // 输出响应到控制台
        System.out.println("返回给浏览器的响应为:" + html);

        // 获取 PrintWriter 对象并写入响应
        PrintWriter out = resp.getWriter();
        out.println(html);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
