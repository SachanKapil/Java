package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ErrorServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
	    out.println("<center><h1>Wrong Username/Password</h1></center>");
		out.println("<a href=\"index.html\"><center><h3>Try Again</h3></center></a>");
		
	}
}
