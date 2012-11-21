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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String Rinfo=(String)session.getAttribute("Rinfo"); 
		String Linfo=(String)session.getAttribute("Linfo"); 
		
		pt.println("<html>");
		pt.println("<head>");
		pt.println("<meta charset=\"UTF-8\">");
		pt.println("<title>LOGIN</title>");
		pt.println("</head>");
		pt.println("<body>");
		pt.println("<form action=Logincl method=post>");

		
		
		if ((Linfo!=null) && (Linfo.equals("wrong")))   //对它进行判断
		{
			pt.println("<h1>wrong email or password</h1>");
		}
		
		else if ((Linfo!=null) && (Linfo.equals("blank")))   //对它进行判断
		{
			pt.println("<h1>blank</h1>");
		}
		else if ( (Rinfo!=null) && (Rinfo.equals("registersucccess")) )   //对它进行判断
		{
			pt.println("<h1>SUCCESS</h1>");
		}
		pt.println("USEREmail<input type=text name=email><br>");
		pt.println("PASSWORD<input type=password name=password><br>");
		pt.println("<input type=submit value=Login>");	
		pt.println("<a href='Register'>Register</a>");
		
		
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
