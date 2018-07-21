 <%@page import="java.sql.SQLException"%>
 <%@page import="model.*"%>
 <%
     String eno=request.getParameter("eno");
     try
	    {
	      Employee m=new Employee();
	     
	      m.setEno(eno);
	      
	      int x=m.deleteEmployee();
	      if(x==1) {
	      out.println("<center><h1>Employee deleted....</h1></center>");
		   
	      }
	      else {
	    	  out.println("<center><h1>Employee not found....</h1></center>");
			    
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