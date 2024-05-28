package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CitizenDao;

/**
 * Servlet implementation class UserOtpController
 */
@WebServlet("/UserOtpController")
public class UserOtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOtpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hiiii");
		
	     PrintWriter out=response.getWriter();
			HttpSession session=request.getSession();
			String email1=(String)session.getAttribute("email");
			System.out.println(email1);
			String genotp = request.getParameter("genotp");
			System.out.println(genotp);
			CitizenDao userDao=new CitizenDao();
			String sql1 = "SELECT MAX(id) FROM userlogin where  email ='"+email1+"' ";
			System.out.println(sql1);
			String genotp1 = CitizenDao.selectotp(sql1);
			String sql2 = "SELECT otp FROM userlogin where  id ='"+genotp1+"' ";
			String genotp2 = CitizenDao.selectotp1(sql2);
			System.out.println(genotp2);
			if(genotp.equals(genotp2)  ){
		
				 out.println("<script type=\"text/javascript\">");
			       out.println("alert('Login Success');");
			       out.println("location='CitizenHome.jsp';");
			       out.println("</script>");
			}
			else{
				request.setAttribute("sucmsg", "Invalid otp");
				 out.println("<script type=\"text/javascript\">");
			       out.println("alert('Failed Otp');");
			       out.println("location='userotp.jsp';");
			       out.println("</script>");
				
			}
		}

}