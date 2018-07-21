package mypack;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.Function;

import java.io.*;
import java.sql.*;

public class SaveServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String eno=req.getParameter("eno");
		String ename=req.getParameter("ename");
		String esal=req.getParameter("esal");
		
		try {
			Function se= new Function();
			se.add(eno, ename, esal);
			out.println("<center><h1>Employee Added....</h1></center>");
		    out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
		} 
		catch (ClassNotFoundException | SQLException e)
		{	
			e.printStackTrace();
		}
	}
}
