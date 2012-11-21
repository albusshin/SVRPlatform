package com.SVRPlatform.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registercl
 */
@WebServlet("/Registercl")
public class Registercl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registercl() {
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
		boolean flag=true; 
		
		HttpSession session=request.getSession(true);
		session.setMaxInactiveInterval(20);
		
		String email=request.getParameter("email");
		String password=request.getParameter("password"); //获取email和password
		
		int userid=0;//默认为0，数据库会增加userid
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String currentdate = simpleDateFormat.format(date);
		int point= 10;								//获取其他信息
		
		String sqlstr="SELECT * FROM users";
		 
		System.out.println(email); 
		System.out.println(password); 
		
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
		          System.out.println(rs.getString("email"));
		          
		     	 if(((email==null)||(password==null))||((email.equals(""))||(password.equals(""))))
		         {  
		 	      	  flag=false;
		  	      	  session.setAttribute("Rinfo","blank");
		         }
		     	 
		     	 else if((email.equals(rs.getString("email"))))
		          {  
		        	  flag=false;
		  	      	  session.setAttribute("Rinfo","wrong");
		          }
		          //报错
		          
		        } 	     
		      
		      System.out.println(flag);
		      
		      if(flag!=false)
		      {
		    	  sqlstr="INSERT INTO users value ('"+userid+"','"+password+"','"+email+"','"+currentdate+"','"+point+"')";
		    	  System.out.println(sqlstr); 
		    	  st.executeUpdate(sqlstr);//注册成功
		    	  response.sendRedirect("./Login");
		    	  session.setAttribute("Rinfo","registersucccess");
		      }	      
		      else 
		    	  response.sendRedirect("./Register");
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
