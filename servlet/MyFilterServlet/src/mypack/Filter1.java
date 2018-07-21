package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class Filter1 implements Filter
{	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h3>Filter-1 In</h3>");
		fc.doFilter(req, res);
		out.println("<h3>Filter-1 Out</h3>");		
	}

}
