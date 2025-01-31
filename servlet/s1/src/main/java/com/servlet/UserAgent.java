package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ua")
public class UserAgent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String ua = request.getHeader("User-Agent");
        if(ua == null){
            response.getWriter().println("User-Agent请求头不存在");
            return;
        }
        String output = "";
        if(ua.toLowerCase().indexOf("windows nt") != -1){
            output = "<h1>这是PC端页面</h1>";
        }else if(ua.toLowerCase().indexOf("iphone") != -1 || ua.toLowerCase().indexOf("android") != -1){
            output = "<h1>这是移动端页面</h1>";
        }

        response.getWriter().println(output);
    }
}