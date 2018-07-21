import java.sql.*;
import java.util.*;
class Demo
{
public static void main(String kapil[])
{
try
{
  Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("load driver");
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
System.out.println("connect");
Scanner input=new Scanner(System.in);
int eno,esal;
String ename;
System.out.println("enter the eno:");
eno=input.nextInt();
System.out.println("enter the ename:");
ename=input.next();
System.out.println("enter esal:");
esal=input.nextInt();
String SQL="insert into emp values(?,?,?)";
PreparedStatement pst=conn.prepareStatement(SQL);
pst.setInt(1,eno);
pst.setString(2,ename);
pst.setInt(3,esal);
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