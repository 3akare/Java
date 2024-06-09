package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "OutPrint",
    urlPatterns = "/name",
    initParams = {
        @WebInitParam(name = "David", value = "David Bakare"),
        @WebInitParam(name = "param2", value = "value2")
    }
)
public class OutPrint extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String name = null;
    ServletContext ctx = getServletContext();
    ServletConfig config = getServletConfig();
    name = config.getInitParameter("David");
//    ctx.setInitParameter("new_one", name);
    response.getWriter().println("<h1> Welcome, " + name + "</h1><br/><p>" + name + "</p>");
//    response.getWriter().println("<h1> Welcome, " + name + "</h1>");
  }

}
