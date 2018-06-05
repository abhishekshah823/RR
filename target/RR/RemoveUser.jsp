<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove User</title>
<meta name="viewport" content="width=device-width,height=device-height initial-scale=1.0">
<link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
      <link rel="manifest" href="./manifest.json"/>
      <meta name="mobile-web-app-capable" content="yes">
       <meta name="apple-mobile-web-app-capable" content="yes">
</head>
<body>
<div class="form">
        <div class="formtext">Select User to remove</div>
       <div class="forminput">
        <form action="RemoveUser" method="post" >
        <div class="options">Username:<select name="uid" autofocus>
		<%
		ResultSet ps = (ResultSet)request.getAttribute("ps");
		while(ps.next())
		{	
		String mngid=ps.getString("usid");

		%>
		<option value="<%= mngid %>"> <%= mngid %></option>
		<% } %>
		</select></div>
		<br>
	    <div class="options"><button id="p01" type="submit" onClick="alert('This will remove all related information and is irreversible!')" value="Send" >GO</button></div>
        </form><br>
       	<form action="AdminOptions.jsp">
<div class="options"><button type="submit" value="Return to previous menu">Return to previous menu</button></div>

</form>
        </div>
    </div>
    
</body>
</html>