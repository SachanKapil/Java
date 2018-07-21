package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class Filter3 implements Filter
{	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		if(uname.equals("kapil") && pass.equals("kapil123"))
		{
			 
		     out.println("<h3>Filter-3 In</h3>");
		     fc.doFilter(req, res);
		     out.println("<h3>Filter-3 Out</h3>");	
		}
		else
		{
			 out.println("<h3>Invalid User</h3>");
			 RequestDispatcher rd=req.getRequestDispatcher("index.html");
			 rd.include(req, res);
			
		}
	}

}
