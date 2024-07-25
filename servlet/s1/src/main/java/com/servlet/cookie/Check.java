package com.servlet.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/check")
public class Check extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Integer random = -1;
        res.setContentType("text/html;charset=utf-8");
        if(cookies == null){
            res.getWriter().println("未包含任何Cookie数据");
            return;
        }
        for (Cookie c : cookies){
            if(c.getName().equals("random")){
                random = Integer.parseInt(c.getValue());
            }
        }

        res.getWriter().println("name=random的cookie值为:" + random);
    }
}
