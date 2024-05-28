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
  
 <!--  <script>
    function shareLocationAndOpenWindow() {
        // Beep for a few seconds
        beep(3); // Beep for 3 seconds

        // Make AJAX request to LocationServlet
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "LocationServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // Handle response from servlet if needed
                console.log("Message sent successfully");
            }
        };
        xhr.send();

        // Send notification to NotifyOtherPageServlet
        var notifyXhr = new XMLHttpRequest();
        notifyXhr.open("POST", "NotifyOtherPageServlet", true);
        notifyXhr.send();

        // Open new window
        /*   let options = 'titlebar=no,statusbar=no,height=300,width=300';
             let ref = window.open('new.jsp', 'fred', options); */

        // Close the window if paragraph in main is clicked
        let p = document.querySelector('main > p');
        p.style.cursor = 'pointer';
        p.addEventListener('click', function (ev) {
            ref.close();
        });
    }

    /* function beep(seconds) {
        var beepAudio = new Audio("assets/img/beep.mp3"); // Replace "beep.mp3" with your audio file
        beepAudio.play();
        setTimeout(function () {
            beepAudio.pause();
        }, seconds * 1000); // Convert seconds to milliseconds
    } */
</script> -->
  
    <!--  <script>
        function shareLocation() {
            // Beep for a few seconds
            beep(3); // Beep for 3 seconds

            // Make AJAX request to LocationServlet
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "LocationServlet", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // Handle response from servlet if needed
                    console.log("Message sent successfully");
                }
            };
            xhr.send();
        } 

      
    </script> -->
     
   <!-- <script>
        function shareLocation() {
            // Play beep sound
            var beep = new Audio('assets/img/beep.mp3');
            beep.play();

            // Get GPS location (Assuming you have a function to get GPS coordinates)
            var location = "Latitude: 123, Longitude: 456"; // Example location

            // Send location to server
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "shareLocationServlet", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // Response from server, if needed
                    console.log(xhr.responseText);
                }
            };
            var data = JSON.stringify({ location: location });
            xhr.send(data);
        }
    </script> -->
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
           <li><a class="nav-link scrollto" href="ShareGPSLocationCitizen.jsp">Share GPS Location</a></li>
            <li class="dropdown"><a><span>Evidence</span> <i class="bi bi-chevron-right"></i></a>
                  <ul>
                    <li><a href="AddEvidence.jsp">Add Evidence</a></li>
                   <li><a href="ViewEvidence1.jsp">View Evidence</a></li>
                  </ul>
                </li> 
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
     <br><br> 
      <div class="container">
        <div class="row">
        <!--   <div class="col-lg-4">
            <div class="section-title" data-aos="fade-right">
              <h2>Services</h2>
              <p>Magnam dolores commodi suscipit nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
            </div>
          </div> -->
          <div class="col-lg-12">
          <br><br> <br>
            <div class="row">
              <div class="col-md-2 d-flex align-items-stretch">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
                  <div class="icon"><i class="bx bxl-dribbble"></i></div>
                  <h4><a href="ViewSafetyTips1.jsp">Safty Tips</a></h4>
                  <p></p>
                </div>
              </div>

              <div class="col-md-2 d-flex align-items-stretch mt-4 mt-lg-0">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="200">
                  <div class="icon"><i class="bx bx-walk"></i></div>
                  <h4><a href="WalkingPartner.jsp">Walking Partner</a></h4>
                  <p></p>
                </div>
              </div>

              <div class="col-md-2 d-flex align-items-stretch mt-4 mt-lg-0">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="300">
                  <div class="icon"><i class="bx bx-tachometer"></i></div>
                  <h4><a href="ViewSpotCrime.jsp">Spot Crime</a></h4>
                  <p></p>
                </div>
              </div>

              <div class="col-md-2 d-flex align-items-stretch mt-4 mt-lg-0">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="400">
                  <div class="icon"><i class="bx bx-world"></i></div>
                 <!--  <h4><a href="#" onclick="shareLocationAndOpenWindow()">GPS Sharing Button</a></h4> -->
                  <!--  <h4><a href="receiver.jsp" target="Fred"><button id="clickButton">GPS Sharing Button</button></a></h4> -->
                <h4 style="font-size: 15px;"><a href="Notification.jsp" target="Fred" onclick="shareLocation"><button id="clickButton" style="background-color:red; color:white;"><b>Emergency Alert</b></button></a></h4>
                 
                  <p></p>
                </div>
              </div>
              
             
               <div class="col-md-2 d-flex align-items-stretch">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
                  <div class="icon"><i class="bx bx-file"></i></div>
                  <h4><a href="https://citizen.mahapolice.gov.in/Citizen/Login.aspx">FIR Register</a></h4>
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
              
             <!--  <div class="col-md-2 d-flex align-items-stretch">
                <div class="icon-box" data-aos="zoom-in" data-aos-delay="100">
                  <div class="icon"><i class="bx bx-detail"></i></div>
                  <h4><a href="AddEvidence.jsp">Add Evidence</a></h4>
                  <p></p>
                </div>
              </div> -->
            </div>
          </div>
        </div>
<br><br><br> <br> 
 
 </div>
    </section><!-- End Services Section -->

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

<script>
    // Function to send notification and open new window
    document.getElementById("clickButton").addEventListener("click", function() {
        // Send notification to NotifyOtherPageServlet
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "NotifyOtherPageServlet", true);
        xhr.send();
        
        

        // Open new window
      /*   let options = 'titlebar=no,statusbar=no,height=300,width=300';
        let ref = window.open('new.jsp', 'fred', options); */

        // Close the window if paragraph in main is clicked
        let h4 = document.querySelector('main > h4');
        h4.style.cursor = 'pointer';
        h4.addEventListener('click', function(ev) {
            ref.close();
        });
    });
    
    function shareLocation() {
        // Beep for a few seconds
        beep(3); // Beep for 3 seconds

        // Make AJAX request to LocationServlet
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "NotifyOtherPageServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // Handle response from servlet if needed
                console.log("Message sent successfully");
            }
        };
        xhr.send();
    } 

</script>
</body>

</html>