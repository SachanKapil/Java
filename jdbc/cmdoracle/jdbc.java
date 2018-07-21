import java.sql.*;
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
String SQL="insert into emp values(101,'kapil',100000)";
Statement st=conn.createStatement();
st.executeUpdate(SQL);
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