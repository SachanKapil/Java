package webpackage;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
public class MyServletClass3 extends HttpServlet
{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>my dynamic webpage3...</h1>");
		out.println("<a href=\"default.html\">HOME</a>");
		out.println("</body>");
		out.println("</html>");
	}

}



