package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CitizenBean;
import com.dao.CitizenDao;
import com.model.createotp;

/**
 * Servlet implementation class CitizenLoginController
 */
@WebServlet("/CitizenLoginController")
public class CitizenLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CitizenLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		CitizenDao dao=new CitizenDao();
		CitizenBean user = new CitizenBean();
		user=dao.CheckCitizen(email, password);
		
		if((user.getEmail()!=null && user.getEmail()!="") && (user.getPassword()!=null && user.getPassword()!=""))
		{
			System.out.println("Citizen Status:"+user.getStatus());
			if(user.getStatus().equals("Active"))
			{
				createotp otp1=new createotp();
				String generatedotp=otp1.createotpmethod();
				/*EmailSend e=new EmailSend();
				e.emailotp(email,generatedotp);*/
				if(dao.update1(email,generatedotp))
				{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Enter OTP')");
			out.println("location='userotp.jsp';");
			out.println("</script>");
			out.print("welcome"+email);
			HttpSession session=request.getSession();  
	        session.setAttribute("email",email);
	        session.setAttribute("name",user.getName());
	        session.setAttribute("address",user.getAddress());
	        session.setAttribute("mobileno",user.getMobileno());
	        session.setAttribute("dob",user.getDob());
	        session.setAttribute("mobileno",user.getMobileno());
	        session.setAttribute("status",user.getStatus()); 
		    }
				else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('OTP Failed........')");
					out.println("location='CitizenLogin.jsp';");
					out.println("</script>");
					}
				}
			else {
				request.setAttribute("ErrMsg", "Wait for activation of your account!...");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Wait For Activation')");
				out.println("location='CitizenLogin.jsp';");
				out.println("</script>");
			}
		}
		else
		{
	     out.println("<script type=\"text/javascript\">");
		 out.println("alert('Invalid Login Details')");
		 out.println("location='CitizenLogin.jsp';");
		out.println("</script>");
			
		}
		
	}
		
		
		
		/*response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		CitizenDao dao=new CitizenDao();
		//UserBean user;// = new UserBean();
		CitizenBean user=dao.CheckCitizen(email, password);
		
		if(user == null) {
			out.println("<script type=\"text/javascript\">");
			 out.println("alert('No Such User Present...')");
			 out.println("location='CitizenLogin.jsp';");
			 out.println("</script>");
		}
		else if((user.getEmail()!=null && user.getEmail()!="") && (user.getPassword()!=null && user.getPassword()!=""))
		{
			if(user.getStatus().equals("Active"))
			{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Successful')");
			out.println("location='CitizenHome.jsp';");
			out.println("</script>");
			out.print("welcome"+email);
			HttpSession session=request.getSession();  
	        session.setAttribute("email",user.getEmail());  
	        session.setAttribute("name", user.getName());
	        session.setAttribute("id", user.getId());
	        session.setAttribute("address", user.getAddress());
	        session.setAttribute("mobileno", user.getMobileno());
	        session.setAttribute("dob", user.getDob());
	        
		    }
			else {
				request.setAttribute("ErrMsg", "Wait for activation of your account!...");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Wait For Activation')");
				out.println("location='CitizenLogin.jsp';");
				out.println("</script>");
			}
		}*/
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
