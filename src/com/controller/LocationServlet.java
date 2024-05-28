package com.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.PoliceBean;
import com.dao.PoliceDao;

import java.io.PrintWriter;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/LocationServlet")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
				doPost(request, response);
	}
		/* double latitude = 37.7749;
	        double longitude = -122.4194;

	        // Set latitude and longitude attributes for JSP
	        request.setAttribute("latitude", latitude);
	        request.setAttribute("longitude", longitude);

	        // Forward to JSP page to display the location
	        request.getRequestDispatcher("/location.jsp").forward(request, response);

	        // Send location via email
	        String userEmail1 = "anuja.raykar@gmail.com";
	        String userEmail2 = "rudratechanuja@gmail.com";
	        sendEmail(userEmail1, "Current Location", "Latitude: " + latitude + "\nLongitude: " + longitude);
	        sendEmail(userEmail2, "Current Location", "Latitude: " + latitude + "\nLongitude: " + longitude);
	    }

	    private void sendEmail(String to, String subject, String messageBody) {
	        // Your email sending logic here
	        // Use JavaMail API or any other library to send emails
	        // Here's a placeholder method for sending emails using JavaMail API

	        // Sender's email address and password
	        final String username = "anuja.raykar@gmail.com";
	        final String password = "Anusweetu15";

	        // Email server properties
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        // Create session with authentication
	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {
	            // Create email message
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	            message.setSubject(subject);
	            message.setText(messageBody);

	            // Send email
	            Transport.send(message);

	            System.out.println("Email sent successfully to: " + to);
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	    }*/
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession();

	        // Retrieve the name attribute from the session
	        String name = (String) session.getAttribute("name");
	        String email = (String) session.getAttribute("email");

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
	            out.println("location='CitizenHome.jsp';");
	            out.println("</script>");
	        } else {
	            out.println("<script type=\"text/javascript\">");
	            out.println("alert('Unsuccessful')");
	            out.println("location='CitizenHome.jsp';");
	            out.println("</script>");
	        }
	    }
	}