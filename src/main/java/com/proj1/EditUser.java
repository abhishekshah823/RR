package com.proj1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditUser
 */
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
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
		String userId =null;
		userId=request.getParameter("uid");
		String password = request.getParameter("pass");
		password=HashGen.getPass(password);
		String userType=request.getParameter("Usertype");
		String mngid=request.getParameter("mngid");
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
	    	 sql ="update userdb set usid = '"+userId+"',pass ='"+password+"' ,usertype= '"+userType+"',mngid='"+mngid+"' where usid = '"+(String)session.getAttribute("sel_usid")+"'";
	    	 System.out.println(sql);
	    	 stmt.executeUpdate(sql);
	    	 request.getRequestDispatcher("UserCreationSuccess.jsp").forward(request, response);
	    	
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
	               conn.close();
	         }catch(SQLException se){
	         }// do nothing
	         try{
	            if(conn!=null)
	               conn.close();
	         }catch(SQLException se){
	            se.printStackTrace();
	         }//end finally try
	      }//end try
		
	}

}
