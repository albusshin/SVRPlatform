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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pt=response.getWriter();
		
		HttpSession session=request.getSession(true);
		session.setMaxInactiveInterval(20);
		String Rinfo=(String)session.getAttribute("Rinfo"); 
		
		pt.println("<html>");
		pt.println("<head>");
		pt.println("<title>Register information</title>");
		pt.println("</head>");
		pt.println("<body>");
		pt.println("<form action=Registercl method=post>");
		
		if ( (Rinfo!=null) && (Rinfo.equals("blank")) )  //对它进行判断
		{
			pt.println("<h1>BLANK  </h1>");
		}
		
		else if( (Rinfo!=null) && (Rinfo.equals("wrong")) )
		{
			pt.println("<h1>WRONG </h1>");
		}

		pt.println("UEmail<input type=int name=email><br>");
		pt.println("PASSWORD<input type=password name=password><br>");
		pt.println("<input type=submit value=OK");	
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
