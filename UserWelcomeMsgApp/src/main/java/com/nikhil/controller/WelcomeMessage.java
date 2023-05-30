package com.nikhil.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/hello")
public class WelcomeMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WelcomeMessage() {
    	System.out.println("This is the welcome app, instantiation....");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Welcome</title></head>");
		out.println("<body>");
		out.println("<h1>Welcome, "+ name + "!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	

}
