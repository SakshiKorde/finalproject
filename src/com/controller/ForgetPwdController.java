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
 * Servlet implementation class ForgetPwdController
 */
@WebServlet("/ForgetPwdController")
public class ForgetPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPwdController() {
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
		
		CitizenDao dao=new CitizenDao();
		CitizenBean user = new CitizenBean();
		user=dao.CheckEmail(email);
		
		if((user.getEmail()!=null && user.getEmail()!=""))
		{
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Valid Citizen')");
			out.println("location='ChangePwd.jsp';");
			out.println("</script>");
			
				}
		else
		{
	     out.println("<script type=\"text/javascript\">");
		 out.println("alert('Invalid Citizen')");
		 out.println("location='CitizenLogin.jsp';");
		out.println("</script>");
			
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
