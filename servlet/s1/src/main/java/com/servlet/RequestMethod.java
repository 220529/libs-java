package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request_method")
public class RequestMethod extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        PrintWriter out = response.getWriter();
        out.println("<h1>GET:name:" + name + "</h1>");
        out.println("<h1>POST:mobile:" + mobile + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        PrintWriter out = response.getWriter();
        out.println("<h1>POST:name:" + name + "</h1>");
        out.println("<h1>POST:mobile:" + mobile + "</h1>");
    }
}
