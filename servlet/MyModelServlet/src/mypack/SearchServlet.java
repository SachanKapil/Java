package mypack;
import javax.servlet.*;
import javax.servlet.http.*;

import model.Employee;

import java.io.*;
import java.sql.*;
public class SearchServlet extends HttpServlet
{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String eno=req.getParameter("eno");    
	
		try {
			 Employee m = new Employee();
			 m.setEno(eno);
			 Employee emp =m.searchEmployee();
				if(emp.getEname()!="notfound")
				{
			    out.println("Name is: "+emp.getEname());
			    out.println("<br>");
			    out.println("Salery is: "+emp.getEsal());
			    out.println("<br>");			    
				}
				else {
					 out.println("<center><h1>Employee not found....</h1></center>");
				}
				out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
			
		} catch (ClassNotFoundException e) {
	          System.out.println(e);
		} catch (SQLException e) {
			 System.out.println(e);			
		}
			     
	      }	    
	    
	}

