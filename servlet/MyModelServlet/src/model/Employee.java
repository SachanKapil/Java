package model;
import java.sql.*;
public class Employee
{
	private Connection con;
	private PreparedStatement pst;
	private String sql;
	public Employee()throws ClassNotFoundException,SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	    System.out.println("connect: "+con);
	}
	private String eno;
	private String ename;
	private String esal;
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsal() {
		return esal;
	}
	public void setEsal(String esal) {
		this.esal = esal;
	}
	public void addEmployee() throws SQLException
	{
		sql="insert into emp values(?,?,?)";
		pst=con.prepareStatement(sql);
	    pst.setInt(1,Integer.parseInt(eno));
	    pst.setString(2,ename);
	    pst.setString(3,esal);
	    pst.executeUpdate();
	    con.close();
		
	}
	public int updateEmployee() throws SQLException
	{
		sql="update emp set ename=?,esal=? where eno=?";
		pst=con.prepareStatement(sql);
	    pst.setInt(3,Integer.parseInt(eno));
	    pst.setString(1,ename);
	    pst.setInt(2,Integer.parseInt(esal));
	    int x=pst.executeUpdate();
	    return x;
		
	}
	public int deleteEmployee() throws SQLException
	{
		sql="delete from emp where eno=?";
		pst=con.prepareStatement(sql);
	    pst.setInt(1,Integer.parseInt(eno));	    
	    int x= pst.executeUpdate();
	    return x;
		
	}
	public Employee searchEmployee() throws SQLException, ClassNotFoundException
	{
		sql="select * from emp where eno=?";
		pst=con.prepareStatement(sql);
	    pst.setInt(1,Integer.parseInt(eno));	    
	    ResultSet rs = pst.executeQuery(); 
	    Employee emp = new Employee();
	    if(rs.next()==true)
	    {	    	
		    emp.setEname(rs.getString("ename"));
		    emp.setEsal(rs.getString("esal"));	    
		    return emp;
	    }
	    else {
	    	emp.setEname("notfound");
	    	return emp;
	  	    }
		
	}
	public ResultSet searchAllEmployee() throws SQLException
	{
		sql="select * from emp";
		pst=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	    	    
	    ResultSet rs = pst.executeQuery();    
	    return rs;
		
	}
	
	
	
	
	
}