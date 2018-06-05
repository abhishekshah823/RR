<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,height=device-height initial-scale=1.0">
<link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
      <link rel="manifest" href="./manifest.json"/>
      <meta name="mobile-web-app-capable" content="yes">
       <meta name="apple-mobile-web-app-capable" content="yes">
<title>Modify User</title>
</head>
<body>
    
    
    	<div class="any" style="max-width:60%">
	     <div class="form">
        <div class="formtext">Modify User Account</div>
       <div class="forminput">
        <form action="EditUser" method="post">
		<div class="options">Enter Username:<input type="text" name="uid" value="<%= (String)session.getAttribute("sel_usid")%>" autofocus required></div><br>
		<div class="options">Enter password:<input type="password" name="pass"  required ></div><br>
		<div class="options">Enter Usertype:<br><select  name= "Usertype">
		<option value="normal">General</option>
		<option value="hr">HR</option>
		</select></div><br>
		<div class="options">Select Manager:<br><select name="mngid" >
		<option selected="<%= (String)session.getAttribute("sel_mngid") %>"><%= (String)session.getAttribute("sel_mngid")%></option>
		<%
		ResultSet ps = (ResultSet)request.getAttribute("ps");
		while(ps.next())
		{	
		String mngid=ps.getString("usid");
		if(!mngid.equals((String)session.getAttribute("sel_mngid"))&&!mngid.equals((String)session.getAttribute("sel_usid"))){
		%>
		<option value="<%= mngid %>"> <%= mngid %></option>
		<% }
		} %>
		</select></div>
		<br>
	    <div class="options"><button id="p01" type="submit" value="Send" >Submit</button></div>
        </form><br>
       	<form action="ModifyUser">
<div class="options"><button type="submit" value="Return to previous menu">Return to previous menu</button></div>

</form>
        </div>
    </div>
    </div>
    
</body>
</html>