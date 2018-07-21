package controller;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.Function;

import java.io.*;
import java.sql.*;

public class VerifyServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");	
		
		try
		{
			 Function f= new Function();
			 int x=f.verify(uname,pass);
			 if(x==1)
			 {
				 res.sendRedirect("welcome");
			 }
			 else
			 {
				 res.sendRedirect("error");
			 }
		} 
		catch (ClassNotFoundException | SQLException e)
		{	
			e.printStackTrace();
		}
	}
}
