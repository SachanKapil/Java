import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class sign3 extends JFrame
{
   JLabel l1,l0,l2,l3,l4;
   sign3(String a,String b)
   {
     String c=a;
     String d=b;
     setTitle("Record");
     l1=new JLabel();
     l2=new JLabel();
     l3=new JLabel();
     l4=new JLabel();
     l0 = new JLabel("YOUR DETAIL");
     l0.setFont(new Font("Serif", Font.BOLD, 25));
     l1.setBounds(80,80,400,30);
     l0.setBounds(130,20,400,50);
     l2.setBounds(80,100,400,30);
      l3.setBounds(80,120,400,30);
      l4.setBounds(80,140,400,30);
     add(l1);
     add(l0);
     add(l2);
     add(l3);
     add(l4);
   
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

               try
               {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                    PreparedStatement pstmt=con.prepareStatement("select * from data where USERNAME='"+c+"' and PASSWORD='"+d+"'");
		  ResultSet rs=pstmt.executeQuery();
                 rs.next();
                 l1.setText("Your name is:  "+rs.getString(1));
                 l1.setFont(new Font("Serif", Font.BOLD, 18));
                 l2.setText("Your mail is:  "+rs.getString(2));
                l2.setFont(new Font("Serif", Font.BOLD, 18));
                l3.setText("Your username is:  "+rs.getString(2));
                l3.setFont(new Font("Serif", Font.BOLD, 18));
                 l4.setText("Your password is:  "+rs.getString(2));
                l4.setFont(new Font("Serif", Font.BOLD, 18));
               
                }
                catch (Exception ex) 
                {
                    System.out.println(ex);
                }

}
}