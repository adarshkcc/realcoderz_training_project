package facadePatternTransaction.copy;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.AtmDAO;
import Model.Bank;
public abstract class WithdrawAmount implements Transaction
{
public double withdrawAmount(double amount)
{
	Bank b=new Bank();
	double newBalance=0;
	Connection con=AtmDAO.getConnection();
	try {
	PreparedStatement st=con.prepareStatement("update details set balance=? where Account_Number=?");
	st.setLong(2, b.getAccountNumber());
	
	if(amount<=b.getBalance())
	{
	 newBalance=b.getBalance()-amount;
	 
	 //adding it to Map and List
	 Bank.store.add(amount);
	 Bank.remainingBalance.add(newBalance);
	 Bank.ch.add('w');
	 
	b.setBalance(newBalance);
	st.setDouble(1, newBalance);
	st.executeUpdate();
	con.close();
	
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return newBalance;
}
}

