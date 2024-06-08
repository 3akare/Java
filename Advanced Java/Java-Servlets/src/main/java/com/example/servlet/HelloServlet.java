package com.example.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int i = Integer.parseInt(request.getParameter("num1"));
        int j = Integer.parseInt(request.getParameter("num2"));
        int k = i + j;

//        response.setContentType("text/html");
//        response.getWriter().print("Result: " + k);

        //Session management

        request.setAttribute("k", k);
        RequestDispatcher rd = request.getRequestDispatcher("sq");
        rd.forward(request, response);
        //Request Dispatcher, and Redirect
    }
}
