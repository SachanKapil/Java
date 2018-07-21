import java.sql.*;
import java.util.*;
class Demo
{
private static Scanner input;

public static void main(String kapil[])
{
try
{
  Class.forName("com.mysql.jdbc.Driver");
System.out.println("load driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
System.out.println("connect");
input = new Scanner(System.in);
String name,email,username,pass;

System.out.println("enter the name:");
name=input.next();
System.out.println("enter the email:");
email=input.next();
System.out.println("enter username:");
username=input.next();
System.out.println("enter password:");
pass=input.next();
String SQL="insert into data values(?,?,?,?)";
PreparedStatement pst=conn.prepareStatement(SQL);
pst.setString(1,name);
pst.setString(2,email);
pst.setString(3,username);
pst.setString(4,pass);
pst.executeUpdate();
System.out.println("query executed");
conn.close();
System.out.println("connection closed");
}
catch(ClassNotFoundException e)
{
System.out.println("class not found");
}
catch(SQLException e)
{
System.out.println("connection failed:"+e);
}

}}