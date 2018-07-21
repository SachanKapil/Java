<%@page import="java.sql.SQLException"%>
<%@page import="DAO.Function"%>
<%@page import="java.io.*"%>
<%@page import="model.Employee"%>
<%@page import="java.util.*"%>
<%
try {
			Function se= new Function();
			List<Employee> ee=se.searchAll();
			Iterator<Employee> it = ee.iterator();
			out.println("<table width='100%' border='1'>");
			out.println("<tr>");
			out.println("<th>Id</th>");
			out.println("<th>Emp No</th>");
			out.println("<th>Emp Name</th>");
			out.println("<th>Emp Sal </th>");
			out.println("<th>Edit Detail </th>");
			out.println("<th>Delete Emp </th>");
			out.println("</tr>");
			if(it.hasNext()) {
			while(it.hasNext())
			{
				Employee emp=it.next();
				out.println("<tr>");
				out.println("<td>"+emp.getId()+"</td>");
				out.println("<td>"+emp.getEno()+"</td>");
			    out.println("<td>"+emp.getEname()+"</td>");
			    out.println("<td>"+emp.getEsal()+"</td>");%>
			    <td><a href="update_h.jsp?id=<%=emp.getId()%>">Edit</a></td>
			    <td><a href="delete.jsp?id=<%=emp.getId()%>">Delete</a></td>
			    <% 
			    out.println("</tr>");
			}
			 out.println("</table>");			
			}
			else {
				out.println("<center><h1>No Employee found....</h1></center>");
			}
			out.println("<a href=\"index.jsp\"><center><h3>HOME</h3></center></a>");
		} catch (ClassNotFoundException e) {
	          System.out.println(e);
		} catch (SQLException e) {
			 System.out.println(e);			
		}
		%>