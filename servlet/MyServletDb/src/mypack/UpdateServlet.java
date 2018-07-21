package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class UpdateServlet extends HttpServlet
{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String eno=req.getParameter("eno");
		String ename=req.getParameter("ename");
	    String esal=req.getParameter("esal");
	    
	    try
	    {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	    String SQL="update emp set ename=?,esal=? where eno=?";
	    PreparedStatement pst=conn.prepareStatement(SQL);
	   
	    pst.setString(1,ename);
	    pst.setInt(2,Integer.parseInt(esal));
	    pst.setInt(3,Integer.parseInt(eno));
	    pst.executeUpdate();
	    conn.close();
	    out.println("<center><h1>Update....</h1></center>");
	    out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
	    }
	    catch(ClassNotFoundException e)
	    {
	    out.println("class not found:"+e);
	    }
	    catch(SQLException e)
	    {
	    out.println("connection failed:"+e);
	    }
	    
	    
	}

}



