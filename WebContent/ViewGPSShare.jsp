<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Abhay</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Bethany
  * Updated: Jan 27 2024 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/bethany-free-onepage-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center">
    <div class="container">
      <div class="header-container d-flex align-items-center justify-content-between">
        <div class="logo">
          <h1 class="text-light"><a href="Home.jsp"><span>Abhay</span></a></h1>
          <!-- Uncomment below if you prefer to use an image logo -->
          <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>

        <nav id="navbar" class="navbar">
          <ul>
            <li><a class="nav-link scrollto" href="Home.jsp">Home</a></li>
            <li><a class="nav-link scrollto active" href="ViewGPSShare.jsp">GPS Sharing</a></li>
            <li><a class="nav-link scrollto" href="Notification.jsp">Notification</a></li>
         <!--   <li><a class="nav-link scrollto " href="">Spot Crime</a></li>
           <li><a class="nav-link scrollto " href="">View FIR</a></li>
           
           <li class="dropdown"><a><span>Safety Tips</span> <i class="bi bi-chevron-right"></i></a>
                  <ul>
                    <li><a href="">Add Safety Tips</a></li>
                    <li><a href="">View Safety Tips</a></li>
                   
                  </ul>
                </li> 
                <li class="dropdown"><a><span>Criminal Section</span> <i class="bi bi-chevron-right"></i></a>
                  <ul>
                    <li><a href="">Add Previous Criminal</a></li>
                    <li><a href="">View Previous Criminal</a></li>
                   
                  </ul>
                </li>  -->
            <li class="dropdown"><a><span>Welcome<%response.setContentType("text/html");  
				 HttpSession sessio=request.getSession(true);  
	               if(session!=null){  
	               String name=(String)session.getAttribute("name");  
	                out.print(" "+name+""); }   %></span> <i class="bi bi-chevron-right"></i></a>
                  <ul>
                    <li><a href="LogoutCon">Logout</a></li>
                   
                  </ul>
                </li> 
             
           </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->

      </div><!-- End Header Container -->
    </div>
  </header><!-- End Header -->
 
  <section id="contact" class="contact" style="background:#DAF7A6;">
     <br><br> <br><br>
      <div class="container">
      
         <div class="section-title">
          <h2 style="font-size:22px;"><span>GPS Sharing By Citizen</span>  </h2>
          
        </div>
 <!-- <section id="contact">
			<div class="container">  -->
				<div class="row">
					<div class="col-md-12">
						<!-- <div class="col-lg-12">
							<div class="text-center color-elements">
								<br><br><br>
							<h2><b>View Users Data</b></h2>
						<br><br>
							</div>
						</div> -->
						<div class="col-sm-offset-2 col-lg-12 ">
						 <form class="subscription-form">
                    <div style="margin-left:20px;margin-right:20px">
                    <table class="table table-bordered" style="color:black">
                   
                     <%
                     Connection con=DBConnection.getConnection();
                     Statement st=con.createStatement();
                      ResultSet rs=st.executeQuery("select * from gpslocation"); 
                  /*   ResultSet rs =  st.executeQuery("SELECT students.stud_fname, students.stud_lname, students.city, technologies.technology FROM students INNER JOIN technologies ON students.student_id = technologies.tech_id"); 
                   */   //while(rs.next())
                     if(rs.next() == false) {
                    	%>
                    	<h4 style="text-align:right;margin-right:70px"><b>No Users Present</b></h4>
                    	<%
                     }
                    else{
                    	int count=0;
                    	do{	 
                    	 if(count == 0) {	
                    	 %>
                    	 <tr  class="danger" style="color:black">
		                    
		                   
		                   <!--   <th>Email</th> -->
		                     <th>Name</th>
		                      <th>Email</th>
		                     <th>Location</th>
		                    <!--  <th>password</th> -->
		                   <!--   <th>Status</th> -->
		                     
		                  </tr>
		                  <%}%>
                    	 <TR>
                    	<%-- <td><img alt="Profile Pic" class="img-circle" src="Profilepic.jsp?id=<%=rs.getInt(1) %>"  width="100px" height="80px"/></td>
                    	   --%>
                    	   <td style="color:black"><%=rs.getString(2) %></td> 
                    	  <td style="color:black"><%=rs.getString(3) %></td> 
                    	 <td style="color:black"><a href="<%=rs.getString(4) %>">Click Here</a></td>
                    	
          
                    	
                    	 </TR>                    	 
                    <%count++; }while(rs.next());}%> 
                   
                    </table>     
                  </form>
						</div>
					</div>
				</div>
         
<br><br> <br><br> <br><br> <br><br> <br><br> <br><br> 
      </div>
    </section>
 
 
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>