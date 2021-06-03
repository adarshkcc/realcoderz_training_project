package practice;
import java.sql.*;
public class Practice {

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//com.mysql.cj.jdbc.Driver.class
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from bank");
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getDouble(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
		}
st.close();
con.close();
	}

}
