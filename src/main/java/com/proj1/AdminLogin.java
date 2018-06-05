package com.proj1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId ="admin";
		String password = request.getParameter("pass");
		password=HashGen.getPass(password);
		
		
		HttpSession session=request.getSession();
	
		
		 Connection conn = null;
		 Statement stmt = null;
		 Properties prop = new Properties();
		    InputStream input = null;
		     try {
		    	 
		    	 String path="/var/lib/tomcat8/webapps/Proj1/WEB-INF/application.properties";
		    	 String path2="C:\\Users\\KIIT\\eclipse-workspace\\Proj1\\WebContent\\WEB-INF\\application.properties";
		    	 
		    	 input=new FileInputStream(path2);
		    	 prop.load(input);
		    	 System.out.println("Linking Driver");
		    	 Class.forName(prop.getProperty("databasedriver"));
		    	 System.out.println("Connecting to database...");
		    	 conn = DriverManager.getConnection(prop.getProperty("databaseurl"),prop.getProperty("databaseuser"),prop.getProperty("databasepass"));		
	    	 stmt = conn.createStatement();
	    	 String sql;
	    	 sql ="select * from userdb";
	    	 ResultSet rs = stmt.executeQuery(sql);
	    	 String id = null;
	    	 
	    	 
	    	 
	    	
	    	 while(rs.next())
	    	 {
	    		id= rs.getString("usid");
	    		
	    		String pas= rs.getString("pass");
	    		
	    		String usertype=rs.getString("usertype");
	    		
	    		if(userId.trim().equals(id)&&(password.equals(pas)))
	    		{
	    			System.out.println("Found User");
	    			session.setAttribute("userId", userId);
	    			session.setAttribute("usertype", usertype);
	    		request.getRequestDispatcher("AdminOptions.jsp").forward(request, response);
	    		return;
	    		}
	    	 }
	    	 
	    	 
	    	 
	    	 if(userId.trim().equals("") )
	    	 {	
	    		 System.out.println("Blank input");
	    		 request.getRequestDispatcher("AdminLogin.jsp").forward(request, response); 
	    		 rs.close();
	    	      stmt.close();
	    	      conn.close();
	    		 return;
	    		
	    	 } 
	    	 else
	    		 {
	    		 System.out.println("Failed to find the user");
	    		request.getRequestDispatcher("Adminfailed.jsp").forward(request, response);
	    		rs.close();
	    	      stmt.close();
	    	      conn.close();
	    		 }
	    	 	 
	    	
	    	 }catch(SQLException se){
	    	      //Handle errors for JDBC
	    	      se.printStackTrace();
	    	   }catch(Exception e){
	    	      //Handle errors for Class.forName
	    	      e.printStackTrace();
	    	   }finally{
	    		      //finally block used to close resources
	    		      try{
	    		         if(stmt!=null)
	    		            stmt.close();
	    		      }catch(SQLException se2){
	    		      }// nothing we can do
	    		      try{
	    		         if(conn!=null)
	    		            conn.close();
	    		      }catch(SQLException se){
	    		         se.printStackTrace();
	    		      }//end finally try
	    		   }//end try
		
	}

}
