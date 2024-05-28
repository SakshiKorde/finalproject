<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Receiver Page</title>
</head>
<body>
    <script>
        function playBeep() {
            var beep = new Audio('assets/img/beep.mp3'); // You'll need an actual sound file
            beep.play();
        }

        function listenForNotification() {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                    playBeep();
                }
            };
            xhr.open("GET", "ListenForNotificationServlet", true);
            xhr.send();
        }

        listenForNotification();
    </script>
</body>
</html>
 
 
 