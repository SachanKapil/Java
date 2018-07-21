package DAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import myconnection.*;

public class Function{	
	private Connection con;
	private PreparedStatement pst;
	private String sql;
	public Function()throws ClassNotFoundException,SQLException, FileNotFoundException, IOException
	{		
			
		con=Connectdb.getConnection();
		
	}

public int verify(String uname,String pass) throws SQLException
{
	int b=0;
	sql="select * from admin where uname=? and pass=?";
	pst=con.prepareStatement(sql);
    pst.setString(1,uname);
    pst.setString(2,pass);
    ResultSet rs=pst.executeQuery();
    if(rs.next())
    {
    	
    	b=1;
    }
    else
    {
    	b=0;
    }
    return b;
}
}