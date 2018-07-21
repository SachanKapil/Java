package webpackage;
import javax.servlet.*;
import java.io.*;
public class MyServletClass2 extends GenericServlet
{
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>my dynamic webpage2...</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}


