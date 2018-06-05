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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveUser
 */
public class RemoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	    	 sql ="select * from userdb order by usid asc";
	    	 System.out.println(sql);
	    	 ResultSet ps = stmt.executeQuery(sql);
	    	 request.setAttribute("ps", ps);
	    	
	    		RequestDispatcher view = request.getRequestDispatcher("RemoveUser.jsp");  
              view.forward(request,response);
	
	    	 ps.close();
	    	 stmt.close();
	    	 conn.close();
	    		
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
	

	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId =null;
		userId=request.getParameter("uid");
		
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
	    	 sql ="delete  from userdb where usid='"+userId+"'";
	    	 System.out.println(sql);
	    	 stmt.executeUpdate(sql);
	    	 sql ="delete  from request where usid='"+userId+"'";
	    	 System.out.println(sql);
	    	 stmt.executeUpdate(sql);
	    	 RequestDispatcher view = request.getRequestDispatcher("UserRemovedSuccess.jsp");  
             view.forward(request,response);
	    	 stmt.close();
	    	 conn.close();
	    		
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
