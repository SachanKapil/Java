 <%@page import="java.sql.SQLException"%>
<%
        String eno=request.getParameter("eno");
		String ename=request.getParameter("ename");
	    String esal=request.getParameter("esal");
	    
	    try
	    {
	      model.Employee m=new model.Employee();
	      m.setEname(ename);
	      m.setEno(eno);
	      m.setEsal(esal);
	      int x=m.updateEmployee();
	      if(x==1) {
	      out.println("<center><h1>Employee updated....</h1></center>");
	      }
	      else
	      {
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