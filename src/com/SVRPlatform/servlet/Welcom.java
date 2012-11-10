package com.SVRPlatform.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcom
 */
@WebServlet("/Welcom")
public class Welcom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pt = response.getWriter();
		HttpSession session=request.getSession(true);
		session.setMaxInactiveInterval(20);
		pt.println("<html>");
		pt.println("<head>");
		pt.println("<meta charset=\"UTF-8\">");
		pt.println("<title>LOGIN</title>");
		pt.println("</head>");
		pt.println("<body>");

		String userID=(String)session.getAttribute("userID");
		String email=(String)session.getAttribute("email");
		String date=(String)session.getAttribute("date");
		String point=(String)session.getAttribute("point");
		
		pt.println("userID="+userID);
		pt.println("email="+email);
		pt.println("date="+date);
		pt.println("point="+point);
		
		pt.println("</body>");
		pt.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
