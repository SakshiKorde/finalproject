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
 * Servlet implementation class AddPreviousCriminalRecordCon
 */
@MultipartConfig
@WebServlet("/AddPreviousCriminalRecordCon")
public class AddPreviousCriminalRecordCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream image=null;		
	String imageName="";
	String path=null;
	File upload=null; 
	
    public AddPreviousCriminalRecordCon() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String criminalname = request.getParameter("criminalname");		
		String address = request.getParameter("address");		
		String age = request.getParameter("age");
		String crime = request.getParameter("crime");	
		String name = request.getParameter("name");	
		String uniqueid = request.getParameter("uniqueid");
		String nooffir = request.getParameter("nooffir");
		String contact = request.getParameter("contact");
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

        b.setCriminalname(criminalname);
        b.setAddress(address);
		b.setName(name);		
		b.setAge(age);
		b.setCrime(crime);
		b.setUniqueid(uniqueid);
		b.setImage(image);
		b.setImage_name(imageName);
		b.setNooffir(nooffir);
		b.setContact(contact);
		b.setStatus(status);

		

		if (dao.AddPreviousCriminalRecord(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Criminal Record Added Successfully')");
			out.println("location='PoliceHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration UnSuccessful')");
			out.println("location='AddPreviousCriminalRecord.jsp';");
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
