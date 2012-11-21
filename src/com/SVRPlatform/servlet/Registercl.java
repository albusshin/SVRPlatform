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
		String password=request.getParameter("password"); //��ȡemail��password
		
		int userid=0;//Ĭ��Ϊ0�����ݿ������userid
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String currentdate = simpleDateFormat.format(date);
		int point= 10;								//��ȡ������Ϣ
		
		String sqlstr="SELECT * FROM users";
		 
		System.out.println(email); 
		System.out.println(password); 
		
		 try { 
		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������
		    } 
		    catch (Exception e) { 
		      e.printStackTrace(); 
		    } 
		//�������ݿ�
		try { 
		      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/svrplatform_database","root","101010"); 
		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û��������� 
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
		          //����
		          
		        } 	     
		      
		      System.out.println(flag);
		      
		      if(flag!=false)
		      {
		    	  sqlstr="INSERT INTO users value ('"+userid+"','"+password+"','"+email+"','"+currentdate+"','"+point+"')";
		    	  System.out.println(sqlstr); 
		    	  st.executeUpdate(sqlstr);//ע��ɹ�
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
		{//�ر�����
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
