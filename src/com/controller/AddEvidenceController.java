package com.controller;

import java.io.File;
import java.io.FileWriter;
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

import com.algo.Encryptor;
import com.algo.MD5;
import com.bean.CitizenBean;
import com.dao.CitizenDao;

/**
 * Servlet implementation class AddEvidenceController
 */
@MultipartConfig
@WebServlet("/AddEvidenceController")
public class AddEvidenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	InputStream image=null;		
	String imageName="";
	String path=null;
	File upload=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEvidenceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");			
		String evdesc = request.getParameter("evdesc");			
		
		CitizenBean b = new CitizenBean();
	
		CitizenDao dao=new CitizenDao();
		
		Part part=request.getPart("file");
		
		if(part!=null)
		{
			image=part.getInputStream();
			System.out.println("is size:"+image.available());
			
			imageName=dao.extractFileName(part);
			System.out.println("name:"+imageName);
		}
		

		
		b.setName(name);
		b.setEvdesc(evdesc);
		b.setImage(image);		
		b.setImage_name(imageName);
		

		/*MD5 md5=new MD5();
		String hashvalue=md5.generate(name);
		String filename=name+".txt";
	      File myObj = new File("C:\\Users\\sbkor\\OneDrive\\Documents\\Nodes\\Citizen\\"+filename+hashvalue);
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	      
	      FileWriter myWriter = new FileWriter("C:\\Nodes\\Citizen\\"+filename+hashvalue);
	      myWriter.write("Citizen Details-"+"name:"+name+","+"evdesc:"+evdesc+",imageName:"+imageName+"");
	      myWriter.close();
	      
	      Encryptor bfe=new Encryptor();
			
			try {
				
				bfe.encrypt("C:\\Nodes\\Citizen\\"+filename+hashvalue);
				
				  
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}*/
		
		if (dao.AddEvidence(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Add evidence successfully')");
			out.println("location='AddEvidence.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Not send..Try Again')");
			out.println("location='AddEvidence.jsp';");
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
