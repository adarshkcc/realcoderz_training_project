package facadePatternTransaction.copy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.AtmDAO;
import Model.Bank;

public abstract class TransferAmount extends TransactionHistory 
{

	public double transferAmount(double amount,long accountNo)
	{
		Bank b=new Bank();
		boolean senderflag =false;
		boolean receiverflag=false;
		Connection con=AtmDAO.getConnection();
		try {

			PreparedStatement st=con.prepareStatement("update details set balance=? where Account_Number=?");//credit
			PreparedStatement select=con.prepareStatement("select * from details where Account_Number=?");

			PreparedStatement st1=con.prepareStatement("update details set balance=? where Account_Number=?");//debit
			PreparedStatement select1=con.prepareStatement("select * from details where Account_Number=?");

			st.setLong(2,accountNo );
			select.setLong(1, accountNo);
			ResultSet res= select.executeQuery();//receiver
		//	receiverflag=res.next();
			//b.flag=receiverflag;
			
				
				while(res.next())
				{
					System.out.println("matched");
					b.flag=true;
					st.setDouble(1, (res.getDouble(4)+amount));//amount get transferd to corresponding account i.e credited
					//	b.setBalance(amount-b.getBalance());     // amount debited
				}
				st.executeUpdate();//receiver balance get updated.
				System.out.println("Amount Transfered Successfully");




				st1.setLong(2, b.getAccountNumber());
				select1.setLong(1, b.getAccountNumber());
				ResultSet res1=select1.executeQuery();//sender
			//	senderflag=res1.next(); 
				while(res1.next())
				{
					System.out.println("Balance updated in while after transfering");
					st1.setDouble(1, (res1.getDouble(4)-amount));//remaining balance after transfering amount.
					

				}
				st1.executeUpdate();//sender balance get updated.	
				
					b.setBalance(b.getBalance()-amount);//updating balance in Bank class.
					Bank.store.add(amount);
					Bank.remainingBalance.add(b.getBalance());
					Bank.ch.add('t');
				

		

		}
		catch(Exception e)
		{

		}

		return amount;
	}
}
