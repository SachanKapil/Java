package mypack;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.SearchEmployee;
import model.Employee;

import java.io.*;
import java.sql.*;
import java.util.*;

public class SearchAllServlet extends HttpServlet
{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();    
	
		try {
			SearchEmployee se= new SearchEmployee();
			List<Employee> ee=se.searchAll();
			Iterator<Employee> it = ee.iterator();
			out.println("<table width='100%' border='1'>");
			out.println("<tr>");
			out.println("<th>Emp No</th>");
			out.println("<th>Emp Name</th>");
			out.println("<th>Emp Sal </th>");
			out.println("</tr>");
			if(it.hasNext()) {
			while(it.hasNext())
			{
				Employee emp=it.next();
				out.println("<tr>");
				out.println("<td>"+emp.getEno()+"</td>");
			    out.println("<td>"+emp.getEname()+"</td>");
			    out.println("<td>"+emp.getEsal()+"</td>");
			    out.println("</tr>");
			}
			 out.println("</table>");
			out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
			}
			else {
				out.println("<center><h1>No Employee found....</h1></center>");
			}
			
		} catch (ClassNotFoundException e) {
	          System.out.println(e);
		} catch (SQLException e) {
			 System.out.println(e);			
		}
			     
	      }	    
	    
	}

