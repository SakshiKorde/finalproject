package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PoliceBean;
import com.dao.PoliceDao;

/**
 * Servlet implementation class ShareGPSLocationCitizenController
 */
@WebServlet("/ShareGPSLocationCitizenController")
public class ShareGPSLocationCitizenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareGPSLocationCitizenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");		
		String email = request.getParameter("email");			
		String location = request.getParameter("location");

		PoliceBean b = new PoliceBean();
		

		b.setName(name);		
		b.setEmail(email);
		b.setLocation(location);

		PoliceDao dao = new PoliceDao();

		if (dao.InsertLocationData(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Location Send Successfully...')");
			out.println("location='CitizenHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('UnSuccessful')");
			out.println("location='CitizenHome.jsp';");
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
