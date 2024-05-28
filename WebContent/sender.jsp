 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sender Page</title>
</head>
<body>
   <!--  <button id="clickButton">Click me</button>
<button id="click">Click</button> -->
	<p><a href="receiver.jsp" target="Fred"><button id="clickButton">scacjgcj</button></a></p>

   <!--  <script>
    document.getElementById("clickButton").addEventListener("click", function() {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "NotifyOtherPageServlet", true);
        xhr.send();
        // Redirect to the receiver page after sending notification
       /*  window.location.href = "http://localhost:8080/PoliceCollaborationSystem/receiver.jsp"; */
    });
    
    
      
    </script>

<script>
document.getElementById("click").addEventListener("click", ev()=> {
	let options='titlebar=no,statusbar=no,height=300,width=300';
let ref = window.open('new.jsp','fred',options);
 let p= document.querySelector('main>p'); 
p.style.cursor='pointer';
p.addEventListener('click',(ev)=>	{
	ref.close();
	});
});

</script> -->

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
        let p = document.querySelector('main > p');
        p.style.cursor = 'pointer';
        p.addEventListener('click', function(ev) {
            ref.close();
        });
    });
</script>

</body>
</html>
 
 