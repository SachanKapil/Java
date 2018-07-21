package mypack;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.Function;
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
			Function se= new Function();
			Employee emp=se.Search(eno);
			if(emp.getEname()!="notfound")
			{
				out.println("<table width='100%' border='1'>");
				out.println("<tr>");
				out.println("<th>Emp No</th>");
				out.println("<th>Emp Name</th>");
				out.println("<th>Emp Sal </th>");
				out.println("</tr>");
				out.println("<tr>");
				 out.println("<td>"+emp.getEno()+"</td>");
			    out.println("<td>"+emp.getEname()+"</td>");
			    out.println("<td>"+emp.getEsal()+"</td>");
			    out.println("</tr>");	
			    out.println("</table>");
			}
			else
			{
				out.println("<center><h1>Employee not found....</h1></center>");
			}
			out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
		} catch (ClassNotFoundException e) {
	          System.out.println(e);
		} catch (SQLException e) {
			 System.out.println(e);			
		}
			     
	}}   

