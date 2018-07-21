import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class sign1 extends JFrame implements ActionListener{
    JLabel L1, L2, L3, L4, L5;
    JTextField tf2, tf3, tf4;
    JButton btn;
    JPasswordField p;
	
    sign1()
     {
       
        setTitle("Registration Form");

        L1 = new JLabel("Registration Form");
        L1.setFont(new Font("Serif", Font.BOLD, 30));
        L2 = new JLabel("Name:");
        L3 = new JLabel("Email-ID:");
        L4 = new JLabel("User Name:");
        L5 = new JLabel("Password:");

        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        p = new JPasswordField();

        btn = new JButton("Save");
        btn.addActionListener(this);
        
      
 
        L1.setBounds(130, 20, 400, 30);
        L2.setBounds(80, 80, 200, 30);
        L3.setBounds(80, 120, 200, 30);
        L4.setBounds(80, 160, 200, 30);
        L5.setBounds(80, 200, 200, 30);
       
        tf2.setBounds(200, 80, 200, 30);
        tf3.setBounds(200, 120, 200, 30);
        tf4.setBounds(200, 160, 200, 30);
        p.setBounds(200, 200, 200, 30);
        btn.setBounds(150, 250, 100, 30);
       
 
        add(L1);
        add(L2);
        add(tf2);
        add(L3);
        add(tf3);
        add(L4);
        add(tf4);
        add(L5);
        add(p);
        add(btn);

        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
   public void actionPerformed(ActionEvent e)
   {            
            String s1 = tf2.getText();
            String s2 = tf3.getText();
            String s3 = tf4.getText();
            String s4 = new String(p.getPassword()); 
                try
               {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                    PreparedStatement pstmt=con.prepareStatement("select * from data where USERNAME='"+s3+"'");
		    ResultSet rs=pstmt.executeQuery();
                    if(rs.next()==true)
                    { 
                      new sign5();
                     }
                     else
                    {
                    Statement stmt=con.createStatement();
		    int x=stmt.executeUpdate("insert into data values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
                        if(x==1)
                        {
                          new sign2();
                         }else
                         {
                            new sign6();
                          }
                    }}
                catch (Exception ex) 
                {
                    System.out.println(ex);
                }
    }
}


