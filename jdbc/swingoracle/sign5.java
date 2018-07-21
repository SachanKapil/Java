import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class sign5 extends JFrame
{
   JLabel l1;
   sign5()
   {
    l1=new JLabel();
    l1.setText("Username is already exits");
    l1.setFont(new Font("Serif", Font.BOLD, 18));
    l1.setBounds(80,80,500,30);
    add(l1);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}