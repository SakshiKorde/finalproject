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
            <li><a class="nav-link scrollto active" href="Home.jsp">Home</a></li>
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
      
        <div class="row">
       
          <div class="col-lg-4" data-aos="fade-right">
            <div class="section-title">
              <h2>Add Spot Crime</h2>
          
            </div>
          </div>

          <div class="col-lg-8" data-aos="fade-up" data-aos-delay="100">
           
            <form action="AddSpotCrimeController" method="post" role="form" class="form1" enctype="multipart/form-data">
              <div class="row">
                <div class="col-md-6 form-group">
                <lable><b>Crime Area</b></lable>
                  <input type="text" name="area" class="form-control" id="area" placeholder="Crime Area" required>
                </div>
                <div class="col-md-6 form-group mt-3 mt-md-0">
                <lable><b>Crime Date</b></lable>
                  <input type="date" class="form-control" name="date" id="date" placeholder="Crime Date" required>
                </div>
                <div class="col-md-6 form-group mt-3 mt-md-0">
                <lable><b>Crime Time</b></lable>
                  <input type="time" class="form-control" name="time" id="time" placeholder="Crime Time" required>
                </div>
                <div class="col-md-6 form-group mt-3 mt-md-0">
                <lable><b>Crime Location</b></lable>
                  <input type="text" class="form-control" name="location" id="location" placeholder="Crime Location" required>
                </div>
                 <div class="col-md-6 form-group mt-3 mt-md-0">
                <lable><b>Crime Type</b></lable>
                  <input type="text" class="form-control" name="type" id="type" placeholder="Crime Type" required>
                </div>
                <div class="col-md-6 form-group mt-3 mt-md-0">
                <lable><b>Added By (Police Officer Name)</b></lable>
                  <input type="text" class="form-control" name="name" id="name" value="${name}" readonly>
                </div>
             
              <div class="col-md-6 form-group mt-3 mt-md-0">
                <lable><b>Crime Image</b></lable>
                  <input type="file" class="form-control" name="file" id="file"  required>
                </div>
              </div>
            
              <br>
              <div class="text-center"><button type="submit" >Add</button>
             
              </div>
            </form>
          </div>
        </div>
<br><br> <br><br> <br><br> <br>
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