package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Employee;

public class SearchEmployee{	
	private Connection con;
	private PreparedStatement pst;
	private String sql;
	public SearchEmployee()throws ClassNotFoundException,SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	    System.out.println("connect: "+con);
	}
public Employee Search(String eno) throws SQLException,ClassNotFoundException
	   {
		sql="select * from emp where eno=?";
		pst=con.prepareStatement(sql);
	    pst.setInt(1,Integer.parseInt(eno));	    
	    ResultSet rs = pst.executeQuery(); 
	    Employee emp = new Employee();
	   if(rs.next()==true)
	   {	
		   emp.setEno(rs.getInt("eno"));
	    emp.setEname(rs.getString("ename"));
	    emp.setEsal(rs.getString("esal"));	    
	    return emp;		
	    }
	   else {
		   emp.setEname("notfound");
		   return emp;
	        }
	   }
	   

public List<Employee> searchAll() throws SQLException
{
	sql="select * from emp";
	pst=con.prepareStatement(sql);
	ResultSet rs=pst.executeQuery();
	List<Employee> empDetails=new ArrayList<Employee>();
	while(rs.next())
	{   
		Employee emp = new Employee();
		emp.setEno(rs.getInt("eno"));
		emp.setEname(rs.getString("ename"));
		emp.setEsal(rs.getString("esal"));
		empDetails.add(emp);
	}
	return empDetails;	
}
public int delete(String eno) throws SQLException
{
	sql="delete from emp where eno=?";
	pst=con.prepareStatement(sql);
    pst.setInt(1,Integer.parseInt(eno));	    
    int x= pst.executeUpdate();
    return x;
	
}
public void add(String eno,String ename,String esal) throws SQLException
{
	sql= "insert into emp values(?,?,?)";
	pst=con.prepareStatement(sql);
	pst.setInt(1,Integer.parseInt(eno));
	pst.setString(2,ename);
	pst.setString(3,esal);
	pst.executeUpdate();
}
public int update(String eno,String ename,String esal) throws SQLException
{
	sql="update emp set ename=?,esal=? where eno=?";
	pst=con.prepareStatement(sql);
    pst.setInt(3,Integer.parseInt(eno));
    pst.setString(1,ename);
    pst.setString(2,esal);
    int x=pst.executeUpdate();
    return x;	
}
}