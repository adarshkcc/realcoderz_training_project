package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AtmDAO {
	public static Connection getConnection()
	{
     Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK","root","root");
			System.out.println("Connection Eastablished Successfully");
			return con;
		} 
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
             e.printStackTrace();
		}
		
		return con;
	}

}
