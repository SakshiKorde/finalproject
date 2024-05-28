<%@page import="java.io.PrintWriter"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="java.io.IOException"%>
<%
// Handle request from citizen homepage to trigger beep sound
if ("POST".equals(request.getMethod()) && "/policehomepage.jsp".equals(request.getServletPath())) {
    try {
        // Play beep sound
        // Here, you can include the code to play the beep sound on the police homepage
        // For simplicity, let's just return a response indicating that the beep signal was received
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/plain");
        PrintWriter out1 = response.getWriter();
        out1.println("Beep signal received from citizen homepage");
        out1.close();
    } catch (IOException e) {
        // Handle IOException
        e.printStackTrace();
    }
}
%>
