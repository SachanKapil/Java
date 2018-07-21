package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class SearchServlet extends HttpServlet
{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String eno=req.getParameter("eno");	    
	    try
	    {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	    String SQL="select * from emp where eno=?";
	    PreparedStatement pst=conn.prepareStatement(SQL);
	   pst.setInt(1,Integer.parseInt(eno));
	    ResultSet rs=pst.executeQuery();	    
	    while(rs.next())
	    {
	    out.println("<h4>Name is:</h4>"+rs.getString(2));
	    out.println("<h4>Salery is:</h4>"+rs.getString(3));
	    }
	    out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
	    conn.close();
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



