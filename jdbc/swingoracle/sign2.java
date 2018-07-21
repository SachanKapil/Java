import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class sign2 extends JFrame implements ActionListener{
    JLabel L1, L2, L3;
    JTextField tf2;
    JButton btn;
    JPasswordField p;
	
    sign2()
     {
       
        setTitle("Log In Form");

        L1 = new JLabel("ENTER DETAIL");
        L1.setFont(new Font("Serif", Font.BOLD, 25));
        L2 = new JLabel("User Name:");
        L2.setFont(new Font("Serif", Font.BOLD, 18));
        L3 = new JLabel("Password:");
        L3.setFont(new Font("Serif", Font.BOLD, 18));

        tf2 = new JTextField();
        p = new JPasswordField();

        btn = new JButton("log in");
        btn.addActionListener(this);
        
        L1.setBounds(130, 20, 400, 50);
        L2.setBounds(80, 80, 200, 30);
        L3.setBounds(80, 120, 200, 30);
       
        tf2.setBounds(200, 80, 200, 30);
        p.setBounds(200, 120, 200, 30);

        btn.setBounds(150, 180, 100, 30);
       
 
        add(L1);
        add(L2);
        add(tf2);
        add(L3);
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
            String s2 = new String(p.getPassword()); 
                try
               {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                    PreparedStatement pstmt=con.prepareStatement("select * from data where USERNAME='"+s1+"' and PASSWORD='"+s2+"'");
		  ResultSet rs=pstmt.executeQuery();
                 
                 if(rs.next()==true)
                 {  
                    sign3 x=new sign3(s1,s2);
                 }
                 else
                 {
                    new sign4();
                  }}
                catch (Exception ex) 
                {
                    System.out.println(ex);
                }
    }
}


