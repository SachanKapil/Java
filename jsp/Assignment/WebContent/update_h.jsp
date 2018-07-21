<%@page import="java.sql.SQLException"%>
<%@page import="DAO.Function"%>
<%@page import="java.io.*"%>
<%@page import="model.Employee"%>
<%       String x=request.getParameter("id");
         application.setAttribute("id",x);
    try {
	Function se= new Function();
	Employee emp=se.Search(x);
%>	

<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<center><h1>UPDATE DETAIL</h1></center>
<form action="update.jsp" method="post">
<table>
<tr><td>Emp No</td><td><input type="text" name="eno" value="<%=emp.getEno()%>"><br></td></tr>
<tr><td>New Name</td><td><input type="text" name="ename"  value="<%=emp.getEname()%>"></td></tr>
<tr><td>New Salery</td><td><input type="text" name="esal"  value="<%=emp.getEsal()%>"><br></td></tr>
<tr><td><input type="submit" value="update"><br></td></tr>
</table>
</form>
</body>
</html>
<%} catch (ClassNotFoundException e) {
        System.out.println(e);
	} catch (SQLException e) {
		 System.out.println(e);			
	}
	%>