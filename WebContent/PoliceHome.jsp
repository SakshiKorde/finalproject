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
             <li><a class="nav-link scrollto" href="ViewGPSShare.jsp">GPS Sharing</a></li>
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
     <br><br> <br><br> <center> 
      <div class="container">
      
           
          <div class="col-lg-12">
          <br>
            <div class="row">
              <div class="col-md-2 d-flex align-items-stretch">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
                  <div class="icon"><i class="bx bxl-dribbble"></i></div>
                  <h4>Safty Tips</h4>
                  <p> <b> <a href="AddSafetyTips.jsp">Add</a>
                  <br>
                  <a href="ViewSafetyTips.jsp">View </a></b></p>
                </div>
              </div>

               <div class="col-md-2 d-flex align-items-stretch mt-4 mt-lg-0">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="200">
                  <div class="icon"><i class="bx bx-walk"></i></div>
                  <h4><a href="ViewEvidence.jsp">View Evidance</a></h4>
                  <p></p>
                </div>
              </div> 

              <div class="col-md-2 d-flex align-items-stretch mt-4 mt-lg-0">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="300">
                  <div class="icon"><i class="bx bx-tachometer"></i></div>
                   <h4>Spot Crime</h4>
                  <p> <b> <a href="AddSpotCrime.jsp">Add</a>
                  <br>
                  <a href="ViewSpotCrime1.jsp">View</a></b></p>
                  <p></p>
                </div>
              </div>

               <div class="col-md-2 d-flex align-items-stretch">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
                  <div class="icon"><i class="bx bxl-dribbble"></i></div>
                  <h4>Criminal Section</h4>
                  <p> <b> <a href="AddPreviousCriminalRecord.jsp">Add</a>
                  <br>
                  <a href="ViewPreviousCriminalRecord.jsp">View </a></b></p>
                </div>
              </div>
              
             
               <div class="col-md-2 d-flex align-items-stretch">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
                  <div class="icon"><i class="bx bx-file"></i></div>
                  <h4><a href="https://citizen.mahapolice.gov.in/Citizen/MH/PublishedFIRs.aspx">View Register FIR</a></h4>
                  <p></p>
                </div>
              </div>

              <div class="col-md-2 d-flex align-items-stretch">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
                  <div class="icon"><i class="bx bx-detail"></i></div>
                  <h4><a href="AddFeedback.jsp">Add Feedback</a></h4>
                  <p></p>
                </div>
              </div>
            </div>
          </div>
      
        
<br><br> <br><br> 
      </div> </center>
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