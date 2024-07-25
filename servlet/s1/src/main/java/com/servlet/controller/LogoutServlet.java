package com.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("/api/login.init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String output = "<h1><a href='http://www.baidu.com'><span>logout</span></a></h1>";
        resp.setContentType("text/html");
        resp.getWriter().println(output);
    }
}