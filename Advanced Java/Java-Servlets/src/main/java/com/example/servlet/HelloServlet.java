package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        int i = Integer.parseInt(request.getParameter("num1"));
//        int j = Integer.parseInt(request.getParameter("num2"));
//        int k = i + j;

        String name = "David";

        PrintWriter out = response.getWriter();
        out.println(name);
//        Cookie cookie = new Cookie("token", "random-cookie-token");
//        response.addCookie(cookie);
//
//        response.setContentType("text/html");
//        response.getWriter().print("Result: " + k + "\n<a href='http://localhost:8080/sq'>Link</a>");

        //Session management

//        request.setAttribute("k", k);
//        RequestDispatcher rd = request.getRequestDispatcher("sq");
//        rd.forward(request, response);
        //Http Cookies and Sessions



        //Session
//        HttpSession session = request.getSession();
//        session.setAttribute("new_k", "This is a new session");

        //Cookies


//        request.setAttribute("k", k);
//        RequestDispatcher rd = request.getRequestDispatcher("sq");
//        rd.forward(request, response);
        //Request Dispatcher, and Redirect
    }
}
