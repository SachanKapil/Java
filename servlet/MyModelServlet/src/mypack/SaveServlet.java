package mypack;
import javax.servlet.*;
import javax.servlet.http.*;

import model.Employee;

import java.io.*;
import java.sql.*;
public class SaveServlet extends HttpServlet
{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String eno=req.getParameter("eno");
		String ename=req.getParameter("ename");
	    String esal=req.getParameter("esal");
	    
	    try
	    {
	      Employee m=new Employee();
	      m.setEname(ename);
	      m.setEno(eno);
	      m.setEsal(esal);
	      m.addEmployee();
	      out.println("<center><h1>Employee Added....</h1></center>");
		    out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
	    }
	    catch(ClassNotFoundException e)
	    {
	    out.println("class not found:"+e);
	    }
	    catch(SQLException e)
	    {
	    out.println("connection failed:"+e);
	    }
	    
	    
	}

}



