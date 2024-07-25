package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ct")
public class ContentType extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String output = "<h1><a href='http://www.baidu.com'><span>百度</span></a></h1>";
        response.setContentType("text/html");
//        response.setContentType("text/plain;charset=utf-8");
//        response.setContentType("application/octet-stream");
//        response.setContentType("application/json");
        response.getWriter().println(output);
    }
}