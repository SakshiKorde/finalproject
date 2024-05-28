package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CitizenBean;
import com.bean.PoliceBean;
import com.dao.PoliceDao;

/**
 * Servlet implementation class WalkingPartnerController
 */
@WebServlet("/WalkingPartnerController")
public class WalkingPartnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalkingPartnerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");		
		String area = request.getParameter("area");		
		String location = request.getParameter("location");
		String status = "Pending";

		CitizenBean b = new CitizenBean();
		

		b.setName(name);		
		b.setArea(area);
		b.setLocation(location);
		b.setStatus(status);

		PoliceDao dao = new PoliceDao();

		if (dao.AddWalkingPartner(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully added')");
			out.println("location='WalkingPartner.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert(' UnSuccessful')");
			out.println("location='WalkingPartner.jsp';");
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
