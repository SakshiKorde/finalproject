<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
<html lang="en">

<head>
  <!-- All your existing head content -->
  
  <script>
    function shareLocationAndBeep() {
        // Play beep sound
        var beepAudio = new Audio("assets/img/beep.mp3");
        beepAudio.play();

        // Send request to server-side endpoint on police homepage
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "policehomepage.jsp", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // Handle response if needed
                console.log("Beep signal sent to police homepage");
            }
        };
        xhr.send();
    }
  </script>
</head>

<body>

  <!-- All your existing body content -->

  <div class="col-md-2 d-flex align-items-stretch mt-4 mt-lg-0">
    <div class="icon-box" data-aos="zoom-in" data-aos-delay="400">
      <div class="icon"><i class="bx bx-world"></i></div>
      <h4><a href="#" onclick="shareLocationAndBeep()">GPS Sharing Button</a></h4>
      <p></p>
    </div>
  </div>

  <!-- All your existing body content -->

</body>

</html>
