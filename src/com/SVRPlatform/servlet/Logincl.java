package com.SVRPlatform.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logincl
 */
@WebServlet("/Logincl")
public class Logincl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connect=null;
		Statement st=null;
		ResultSet rs=null;
		@SuppressWarnings("unused")
		boolean flag=true; 
		
		String userID=null;
  		String date=null;
  		String point=null;
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String DBpassword=null;
		HttpSession session=request.getSession(true);
		session.setMaxInactiveInterval(20);
		String sqlstr="SELECT * FROM users";
		
		 try { 
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序    
		    } 
		    catch (Exception e) { 
		      e.printStackTrace(); 
		    } 
		//连接数据库
		 
			try { 
			      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/svrplatform_database","root","101010"); 
			           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码 
			      st = connect.createStatement(); 
			      rs = st.executeQuery(sqlstr);
			      while (rs.next()) { 
			          if(email.equals(rs.getString("email")) && (email!=null))
			          {
			        	  DBpassword=rs.getString("password");
			        	  
			        	  userID=rs.getString("userID");
			      		  date=rs.getString("date");
			      		  point=rs.getString("point");
			          }
			     }
			      
			      if((email==null)||(DBpassword==null))
			         {  
			 	      	  flag=false;
			 	      	  response.sendRedirect("./Login");
			  	      	  session.setAttribute("Linfo","blank");
			         }
			      else	if(!DBpassword.equals(password))
			      {
			    	  flag=false;	//密码错误
			    	  response.sendRedirect("./Login");
			    	  session.setAttribute("Linfo", "wrong");
			      }
			      else
			      { //登陆成功
			    	  session.setAttribute("userID", userID);
			    	  session.setAttribute("email", email);
			    	  session.setAttribute("password", DBpassword);
			    	  session.setAttribute("date", date);
			    	  session.setAttribute("point", point);
			    	  response.sendRedirect("./Welcom");
			      }
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			finally
			{//关闭连接
				try
				{
					if(rs!=null)
					{
						rs.close();
					}
					if(st!=null)
					{
						st.close();
					}
					if(connect!=null)
					{
						connect.close();
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}      
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
