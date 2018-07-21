package mypack;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

public class ValidateServlet extends HttpServlet
{
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException 
  {
	  res.setContentType("text/html");
	  PrintWriter out=res.getWriter();
	  out.println("<h1>Welcome from validate servlet:)</h1>");	  
  }
}
