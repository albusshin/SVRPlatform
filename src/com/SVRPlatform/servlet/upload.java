package com.SVRPlatform.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		
		String title = request.getParameter("title");
		String level = request.getParameter("level");
		String description = request.getParameter("description");
		String version = request.getParameter("version");
		String software = request.getParameter("software");
		String graph_address = request.getParameter("graph_address");
		String datetime = "";
		int softwareID;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/svrplatform_database","root","302010");
			Statement stmt = conn.createStatement();
			
			//查询softwareID,若没有则插入
			ResultSet rs = stmt.executeQuery("SELECT * FROM svrplatform_database.software WHERE softwareName='"+software+"'");
			if (rs.next()) 
				softwareID = Integer.parseInt(rs.getString("softwareID"));
			else {
				stmt.executeUpdate("INSERT INTO svrplatform_database.software(softwareName) VALUES('"+software+"')");
				rs = stmt.executeQuery("SELECT * FROM svrplatform_database.software ORDER BY softwareID DESC LIMIT 1");
				rs.next();
				softwareID = Integer.parseInt(rs.getString("softwareID"));
			}
			
			//获取当前时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			datetime = sdf.format(new Date());
			
			//插入数据
			stmt.executeUpdate("INSERT INTO svrplatform_database.bugs(level, graph_address, datetime, description, version, softwareID, title) VALUES('"+level+"', '"+graph_address+"', '"+datetime+"', '"+description+"', '"+version+"', '"+softwareID+"', '"+title+"')");
			response.sendRedirect("upload_image.jsp");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
