package DAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.Employee;
import myconnection.Connectdb;

public class Function{	
	private Connection con;
	private PreparedStatement pst;
	private String sql;
	public Function()throws ClassNotFoundException,SQLException, FileNotFoundException, IOException
	{
		con=Connectdb.getConnection();
	}
public Employee Search(String id) throws SQLException,ClassNotFoundException
	   {
		sql="select * from empjsp where id=?";
		pst=con.prepareStatement(sql);
	    pst.setInt(1,Integer.parseInt(id));	    
	    ResultSet rs = pst.executeQuery(); 
	    Employee emp = new Employee();
	     rs.next();	
		emp.setEno(rs.getInt("eno"));
	    emp.setEname(rs.getString("ename"));
	    emp.setEsal(rs.getString("esal"));	    
	    return emp;			    
	   }
	   

public List<Employee> searchAll() throws SQLException
{
	sql="select * from empjsp";
	pst=con.prepareStatement(sql);
	ResultSet rs=pst.executeQuery();
	List<Employee> empDetails=new ArrayList<Employee>();
	while(rs.next())
	{   
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setEno(rs.getInt("eno"));
		emp.setEname(rs.getString("ename"));
		emp.setEsal(rs.getString("esal"));
		empDetails.add(emp);
	}
	return empDetails;	
}
public int delete(String id) throws SQLException
{
	sql="delete from empjsp where id=?";
	pst=con.prepareStatement(sql);
    pst.setInt(1,Integer.parseInt(id));	    
    int x= pst.executeUpdate();
    return x;
	
}
public void add(String eno,String ename,String esal) throws SQLException
{
	sql= "insert into empjsp values(s.nextval,?,?,?)";
	pst=con.prepareStatement(sql);
	pst.setInt(1,Integer.parseInt(eno));
	pst.setString(2,ename);
	pst.setString(3,esal);
	pst.executeUpdate();
}
public int update(String id,String eno,String ename,String esal) throws SQLException
{
	sql="update empjsp set eno=?,ename=?,esal=? where id=?";
	pst=con.prepareStatement(sql);
    pst.setInt(3,Integer.parseInt(eno));
    pst.setString(2,ename);
    pst.setString(3,esal);
    pst.setString(1,eno);
    pst.setInt(4,Integer.parseInt(id));
    int x=pst.executeUpdate();
    return x;	
}
}