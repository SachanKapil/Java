<%@page import="java.sql.*"%>
 <%@page import="model.*"%>
<% 
      try
	    {
	      Employee m=new Employee();     
	      ResultSet rs=m.searchAllEmployee();
	      if(rs.next()==false)
	      {
	    	  out.println("<center><h1>No Employee found....</h1></center>");
			   	    	  
	      }
	      rs.previous();
	      while(rs.next())
		    {
	    	out.println("Employee No is: "+rs.getString(1));
			out.println("<br>");
		    out.println("Name is: "+rs.getString(2));
		    out.println("<br>");
		    out.println("Salery is: "+rs.getString(3));
		    out.println("<br>");
		    out.println("<br>");
		    }
		    out.println("<a href=\"index.jsp\"><center><h3>HOME</h3></center></a>");
	    }
	    catch(ClassNotFoundException e)
	    {
	    out.println("class not found:"+e);
	    }
	    catch(SQLException e)
	    {
	    out.println("connection failed:"+e);
	    }
	    %>