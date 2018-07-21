package mypack;
import javax.servlet.*;
import javax.servlet.http.*;

import model.Employee;

import java.io.*;
import java.sql.*;
public class UpdateServlet extends HttpServlet
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
	      int x=m.updateEmployee();
	      if(x==1) {
	      out.println("<center><h1>Employee updated....</h1></center>");
		    out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
	      }
	      else
	      {
	    	  out.println("<center><h1>Employee not found....</h1></center>");
			    out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
	    	  
	      }
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

