<%@page import="java.io.*" %>

<%@page contentType="text/html" %>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
    <title>Dashboard</title>
 </head>
 <body>
	<h1>Admin Dashboard Page</h1>
	<br><hr><br><br>
	<h4>Aadhar Numbers of Fraud People(Rigging):</h4>
	<%String std=(String)request.getAttribute("data"); %>

	
	
	<%=std%>

	
	
	

 </body>
</html>
