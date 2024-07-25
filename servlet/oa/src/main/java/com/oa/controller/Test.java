package com.oa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String output = "<h1><a href='http://www.baidu.com'><span>test</span></a></h1>";
        resp.setContentType("text/html");
        resp.getWriter().println(output);
    }
}
