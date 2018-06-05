<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="javax.servlet.http.HttpSession" %>
     <%@ page import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
    <link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
</head>
<body>
<header>    
You have successfully Logged in <br>
Welcome, <%=(String)session.getAttribute("userId")%>
 </header>
 <div class="options">
 <form  action= "NewUser">
    <button type="submit" value="Create a New User">Create a New User</button>
    </form><br>   
 <form  action= "ModifyUser">
    <button type="submit" value="Modify an existing user">Modify an existing user</button>
    </form><br>
    <form  action= "RemoveUser" >
    <button type="submit" value="Remove User">Remove User</button>
    </form><br>
    <form  action= "Logout.jsp">
 <button type="submit" value="Logout">Logout</button></form>
 </div>
  
</body>   
    
    
    
    
    
    
    
    
    
    