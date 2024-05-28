package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.PoliceBean;
import com.dao.PoliceDao;

/**
 * Servlet implementation class AddSpotCrimeController
 */
@MultipartConfig
@WebServlet("/AddSpotCrimeController")
public class AddSpotCrimeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream image=null;		
	String imageName="";
	String path=null;
	File upload=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSpotCrimeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String area = request.getParameter("area");		
		String date = request.getParameter("date");		
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String name = request.getParameter("name");	
		String type = request.getParameter("type");
		String status = "Active";

		PoliceBean b = new PoliceBean();
		PoliceDao dao = new PoliceDao();

        Part part=request.getPart("file");
		
		if(part!=null)
		{
			image=part.getInputStream();
			System.out.println("is size:"+image.available());
			
			imageName=dao.extractFileName(part);
			System.out.println("name:"+imageName);
		}
		
		b.setName(name);		
		b.setArea(area);
		b.setDate(date);
		b.setTime(time);
		b.setImage(image);
		b.setImage_name(imageName);
		b.setLocation(location);
		b.setStatus(status);
		b.setType(type);

		
		if (dao.AddSpotCrimeData(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Spot Crime Added Successfully')");
			out.println("location='AddSpotCrime.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert(' UnSuccessful')");
			out.println("location='PoliceHome.jsp';");
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
