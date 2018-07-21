<%@page import="java.sql.SQLException"%>
<%@page import="DAO.Function"%>
<%        String eno=request.getParameter("eno");		
		String ename=request.getParameter("ename");
	    String esal=request.getParameter("esal");
	    String id=(String)application.getAttribute("id");
	    try
	    {
	    	Function se= new Function();
			int x=se.update(id,eno,ename,esal);     	      
	      if(x==1) {
	      out.println("<center><h1>Employee updated....</h1></center>");
		    out.println("<a href=\"index.jsp\"><center><h3>HOME</h3></center></a>");
	      }
	      else {
	    	  out.println("<center><h1>Employee not found....</h1></center>");
			    out.println("<a href=\"index.jsp\"><center><h3>HOME</h3></center></a>");
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