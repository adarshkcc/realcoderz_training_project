package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PinValidation {

	public static boolean validatePin(int pin)
	{
		boolean flag=false;
		Bank b=new Bank();
		String query="Select * from details where pin=?";
		
		Connection con=AtmDAO.getConnection();
		
		
		try {
			PreparedStatement st= con.prepareStatement(query);
			st.setInt(1, pin);
			ResultSet res=st.executeQuery();
			while(res.next())
			{
				flag=true;
				b.setAccountNumber(res.getLong(2));
				
				b.setAccountHolder(res.getString(3));
			
				b.setBalance(res.getDouble(4));
				b.setBankName(res.getString(5));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	
	}
}
