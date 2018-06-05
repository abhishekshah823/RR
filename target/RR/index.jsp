<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
<head>
<title>Login Portal</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,height=device-height initial-scale=1.0">
<link rel="stylesheet" href="./CSS/styleindex.css" type="text/css" />
      <link rel="manifest" href="./manifest.json"/>
      <meta name="mobile-web-app-capable" content="yes">
       <meta name="apple-mobile-web-app-capable" content="yes">
<script>
if ('serviceWorker' in navigator) {
	  window.addEventListener('load', function() {
	    navigator.serviceWorker.register('app.js').then(function(registration) {
	      // Registration was successful
	      console.log('ServiceWorker registration successful with scope: ', registration.scope);
	    }, function(err) {
	      // registration failed :(
	      console.log('ServiceWorker registration failed: ', err);
	    });
	  });
	}

</script>      
</head>
    
    
<body>
    
    <header>
        HR Management Portal
        
        </header>
    	
		 <div class="options" >
        <div class="form">
        <div class="formtext">SIGN IN</div>
       <div class="forminput">
        <form action="LoginServlet" method="post">
		<input type="text" name="uid" placeholder="username" autofocus required><br><br>
		<input type="password" name="pass" placeholder="password" required ><br><br>
	            <button id="p01" type="submit" value="Send" >Send</button>
        </form>
       		<form action="AdminLogin.jsp">
                <button type="submit" value="AdminLogin">Administrator Login</button>
        </form>
        </div>
    </div>
    </div>
    
</body>
</html>