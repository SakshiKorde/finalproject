package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.PoliceBean;
import com.dao.PoliceDao;

/**
 * Servlet implementation class NotifyOtherPageServlet
 */
@SuppressWarnings("serial")
@WebServlet("/NotifyOtherPageServlet")
public class NotifyOtherPageServlet extends HttpServlet {
	     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            
           /* response.sendRedirect("receiver.jsp");*/
            
            PrintWriter out = response.getWriter();
	       /* HttpSession session = request.getSession();*/

	        // Retrieve the name attribute from the session
	        String name = (String) session.getAttribute("name");
	        String email = (String) session.getAttribute("email");
	        session.setAttribute("notification", true);
	        if (name == null) {
	            // If name is not found in the session, retrieve it from request parameters
	            name = request.getParameter("name");
	            email = request.getParameter("email");

	            // Set the name attribute in the session
	            session.setAttribute("name", name);
	            session.setAttribute("email", email);
	        }

	        // Continue with your remaining logic...
	        /*String email = "amol@gmail.com";*/
	        String msg = "Help me"; 

	        PoliceBean b = new PoliceBean();
	        
	        b.setEmail(email);
	        b.setName(name);
	        b.setMsg(msg);
	        
	        PoliceDao dao = new PoliceDao();
	       
	        if (dao.InsertAlertData(b)) {
	            out.println("<script type=\"text/javascript\">");
	            out.println("alert('Successfully sent alert')");
	            out.println("location='Notification.jsp';");
	            out.println("</script>");
	        } else {
	            out.println("<script type=\"text/javascript\">");
	            out.println("alert('Unsuccessful')");
	            out.println("location='CitizenHome.jsp';");
	            out.println("</script>");
	        }
	    }
            
        }
    
