package com.servlet.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/cookie/create")
public class Create extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Integer random = new Random().nextInt(10000);
        Cookie cookie = new Cookie("random" , String.valueOf(random));
        cookie.setMaxAge(60*60*24);
        res.addCookie(cookie);
        res.setContentType("text/html;charset=utf-8");
        res.getWriter().println("<h2>随机数" +  random+ "已生成</h2>");
    }
}