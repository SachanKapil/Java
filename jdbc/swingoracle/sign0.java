import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class sign0 extends JFrame implements ActionListener{
    JButton btn1,btn2;
	JLabel L1;
    sign0()
     {
       
        setTitle("FORM");
        L1 = new JLabel("Form");
        L1.setFont(new Font("Serif", Font.BOLD, 30));

        btn1 = new JButton("SIGN UP");
        btn2 = new JButton("SIGN IN");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        L1.setBounds(180, 20, 400, 30);
        btn1.setBounds(170, 80, 100, 30);
        btn2.setBounds(170, 120, 100, 30);
       
        add(btn1);
        add(btn2);
        add(L1);

        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
   public void actionPerformed(ActionEvent e)
   {            
            
       if(e.getSource()==btn1) 
     {
          new sign1();
    }
     if(e.getSource()==btn2) 
     {
          new sign2();
    }
}
    public static void main(String args[])    
    {
      new sign0();
    }
}


