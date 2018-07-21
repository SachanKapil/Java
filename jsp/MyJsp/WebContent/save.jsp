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
	      m.addEmployee();
	      out.println("<center><h1>Employee Added....</h1></center>");
		  out.println("<a href=\"index.jsp\"><center><h3>HOME</h3></center></a>");
	    }
	    catch(ClassNotFoundException e)
	    {
	    out.println("class not found:"+e);
	    }
	    catch(java.sql.SQLException e)
	    {
	    out.println("connection failed:"+e);
	    }
%>
	    