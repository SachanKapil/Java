 <%@page import="java.sql.SQLException"%>
<%        String eno=request.getParameter("eno");    
	
		try {
			 model.Employee m = new model.Employee();
			 m.setEno(eno);
			 model.Employee emp =m.searchEmployee();
				if(emp.getEname()!="notfound")
				{
			    out.println("Name is: "+emp.getEname());
			    out.println("<br>");
			    out.println("Salery is: "+emp.getEsal());
			    out.println("<br>");			    
				}
				else {
					 out.println("<center><h1>Employee not found....</h1></center>");
				}
				out.println("<a href=\"index.jsp\"><center><h3>HOME</h3></center></a>");
			
		} catch (ClassNotFoundException e) {
	          System.out.println(e);
		} catch (SQLException e) {
			 System.out.println(e);			
		}
		%>