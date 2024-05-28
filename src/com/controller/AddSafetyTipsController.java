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
import com.dao.CitizenDao;
import com.dao.PoliceDao;

/**
 * Servlet implementation class AddSaftyTipsController
 */
@WebServlet("/AddSafetyTipsController")
public class AddSafetyTipsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSafetyTipsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String safetytips = request.getParameter("safetytips");		
		String video  = request.getParameter("video");	
		
		PoliceBean b = new PoliceBean();
		

		b.setSafetytips(safetytips);
		b.setVideo(video);
		
		PoliceDao dao = new PoliceDao();

		if (dao.AddSaftyTips(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Saftey Tip Added Successfully')");
			out.println("location='PoliceHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert(' UnSuccessful')");
			out.println("location='AddSafetyTips.jsp';");
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
