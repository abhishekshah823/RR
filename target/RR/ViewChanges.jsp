<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Request History</title>
<link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
</head>
<body>
<header>
		The Audit Trail
        
        </header>
    	
<div style="overflow-x:auto;">
<table border="0">
<tr>
<th>Request_ID</th>
<th>Requesting User</th>
<th>Original Date</th>
<th>Description</th>
<th>Department</th>
<th>Experience</th>
<th>Expertise</th>
<th>Previous State</th>
<th>New State</th>
<th>Changed By</th>
<th>Change Date</th>
</tr>
<% 

ResultSet rs = (ResultSet)request.getAttribute("rs");
while(rs.next())
	    	 {
	    		String req_id= rs.getString("req_id");
	    		String req_date= rs.getString("req_date");
	    		String req_description= rs.getString("req_description");
	    		String department= rs.getString("department");
	    		String experience = rs.getString("experience");
	    		String expertise = rs.getString("expertise");
	    		String app1=rs.getString("old_state");
	    		String app2=rs.getString("new_state");
	    		String chby=rs.getString("changed_by");
	    		String chtime=rs.getString("change_time");
	    		String userId= rs.getString("USID");
	    		
	    		
	    		
	    		%>
	    	
<tr>
<td><%= req_id%></td>
<td><%=userId%></td>
<td><%= req_date%></td>
<td><%= req_description%></td>
<td><%= department%></td>
<td><%= experience%></td>
<td><%= expertise%></td>
<td><%= app1%></td>
<td><%= app2%></td>
<td><%= chby%></td>
<td><%= chtime%></td>

</tr>
	  	
<% } %>
</table>
</div>
<br>
<div class="options">
 <form action="options.jsp">
 <button type="submit" value="Return to Previous Menu">Return to Previous Menu</button>
</div>
 </form>
</body>
</html>