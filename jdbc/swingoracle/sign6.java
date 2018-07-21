import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class sign6 extends JFrame
{
   JLabel l1;
   sign6()
   {
    l1=new JLabel();
    l1.setText("Registration failed");
    l1.setFont(new Font("Serif", Font.BOLD, 18));
    l1.setBounds(80,80,500,30);
    add(l1);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}