import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class sign4 extends JFrame
{
   JLabel l1;
   sign4()
   {
    l1=new JLabel();
    l1.setText("Your records not found");
    l1.setFont(new Font("Serif", Font.BOLD, 18));
    l1.setBounds(80,80,400,30);
    add(l1);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}