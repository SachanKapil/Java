package myconnection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connectdb {
	private static Connection con;
	private Connectdb(){};
	public static Connection getConnection() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException
	{
		if(con==null)
		{
			Properties p=new Properties();
			p.load(new FileReader("E:\\java programs\\admin_employee\\src\\database.properties"));
			Class.forName(p.getProperty("dbdriver"));
		    con=DriverManager.getConnection(p.getProperty("dburl"),p.getProperty("dbusername"),p.getProperty("dbpassword"));
		    
		}
		System.out.println("connect: "+con);
		return con;
	}
}
