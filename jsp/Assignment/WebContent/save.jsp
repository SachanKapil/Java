<%@page import="java.sql.SQLException"%>
<%@page import="DAO.Function"%>
<%
        String eno=request.getParameter("eno");
		String ename=request.getParameter("ename");
		String esal=request.getParameter("esal");
		
		try {
			Function se= new Function();
			se.add(eno, ename, esal);
			out.println("<center><h1>Employee Added....</h1></center>");
		    out.println("<a href=\"index.jsp\"><center><h3>HOME</h3></center></a>");
		} 
		catch (ClassNotFoundException | SQLException e)
		{	
			e.printStackTrace();
		}
%>