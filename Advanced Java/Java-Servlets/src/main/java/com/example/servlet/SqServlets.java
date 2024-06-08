package com.example.servlet;

import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlets extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        int k = (int) request.getAttribute("k");
//        response.getWriter().println("Sq Servlet: " + k * k);
//        HttpSession session = request.getSession();
//
//        String new_k = (String) session.getAttribute("new_k");
//        int k = (int) request.getAttribute("k");
        Cookie[] cookie = request.getCookies();
        String token = null;

      for (Cookie value : cookie) {
        if (Objects.equals(value.getName(), "token")) {
          token = value.getValue();
        }
      }
        response.getWriter().println("Found this cookies" + token);
    }
}
