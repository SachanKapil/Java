package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ValidateServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");	
		ServletContext sc=this.getServletContext();
		try
		{
			Class.forName(sc.getInitParameter("Driver"));
		    Connection con=DriverManager.getConnection(sc.getInitParameter("Url"),sc.getInitParameter("Uid"),sc.getInitParameter("Upass"));
		    System.out.println("connect: "+con);
		    String sql="select * from admin where uname=? and pass=?";
		    PreparedStatement pst=con.prepareStatement(sql);
		    pst.setString(1,uname);
		    pst.setString(2,pass);
		    ResultSet rs=pst.executeQuery();		    
			 if(rs.next())
			 {
				 sc.setAttribute("un",uname);
				 res.sendRedirect("welcome");
			 }
			 else
			 {
				 res.sendRedirect("error");
			 }
		} 
		catch (ClassNotFoundException | SQLException e)
		{	
			e.printStackTrace();
		}
	}
}
