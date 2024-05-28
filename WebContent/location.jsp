<!DOCTYPE html>
<html>
<head>
    <title>Current Location</title>
</head>
<body>
    <h1>Current Location</h1>
    <p>Latitude: <%= request.getAttribute("latitude") %></p>
    <p>Longitude: <%= request.getAttribute("longitude") %></p>
</body>
</html>
