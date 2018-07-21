package webpackage;
import javax.servlet.*;
import java.io.*;
public class MyServletClass implements Servlet
{
	public void destroy() {}
    public ServletConfig getServletConfig() 
    {
		return null;
	}
	public String getServletInfo()
	{
		return null;
	}
	public void init(ServletConfig sc) throws ServletException {}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>my dynamic webpage1...</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}

