package facadePatternTransaction.copy;
import java.util.Map;

import Model.Bank;
public abstract class TransactionHistory extends WithdrawAmount
{

	public boolean transactionHistory()
	{
		if(Bank.store.isEmpty())
		{
			System.out.println("transaction not done");
		return false;
		}
		
		else
		{
			System.out.println("done");
			return true;
		}
	}
}
