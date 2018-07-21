<%@page import="java.sql.SQLException"%>
<%@page import="DAO.Function"%>
<%     String z=request.getParameter("id");     	    
	    try
	    {
	    	Function se= new Function();
			int x=se.delete(z);     	      
	      if(x==1) {
	      response.sendRedirect("search_all.jsp");
	      }
	      else {
	    	  out.println("<center><h1>Employee not found....</h1></center>");
			    out.println("<a href=\"index.html\"><center><h3>HOME</h3></center></a>");
	      }
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