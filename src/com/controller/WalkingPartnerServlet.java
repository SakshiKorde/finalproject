package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class WalkingPartnerServlet
 */
@WebServlet("/WalkingPartnerServlet")
public class WalkingPartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private class User {
        String name;
        String preference;
        
        public User(String name, String preference) {
            this.name = name;
            this.preference = preference;
        }
    }
    
    private List<User> users = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        out.println("<html><body>");
	        out.println("<h2>Walking Partner Matching System</h2>");
	        out.println("<form method=\"post\" action=\"WalkingPartnerServlet\">");
	        out.println("Name: <input type=\"text\" name=\"name\"><br>");
	        out.println("Walking partner preference: <input type=\"text\" name=\"preference\"><br>");
	        out.println("<input type=\"submit\" value=\"Register\">");
	        out.println("</form>");
	        out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String preference = request.getParameter("preference");
        
        User newUser = new User(name, preference);
        users.add(newUser);
        
        out.println("<html><body>");
        out.println("<h2>Thank you for registering!</h2>");
        out.println("<p>Your walking partner preference is: " + preference + "</p>");
        out.println("<p>We'll notify you when we find a suitable partner!</p>");
        out.println("</body></html>");
    }
	}


