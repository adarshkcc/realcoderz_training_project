package facadePatternTransaction.copy;

public class FacadePatternDemo extends CheckBalance
{

	
	public static double checkBalance1() {
		FacadePatternDemo d=new FacadePatternDemo();
	double balance=	d.checkBalance();
		return 0;
	}

	
	public static double transferAmount1(double amount,long accountNo) {
		FacadePatternDemo d=new FacadePatternDemo();
	return	d.transferAmount(amount,accountNo);
	
	}

	
	public static boolean transactionHistory1() {
		
		FacadePatternDemo d=new FacadePatternDemo();
	boolean b=	d.transactionHistory();
		return b;
	}

	
//	public boolean exit() {
//		// TODO Auto-generated method stub
//		return false;
//	}
	// this method will be called from Servlet.
	public static double withdrawAmount1(double amount)
	{
		FacadePatternDemo d=new FacadePatternDemo();

		double Amount=	d.withdrawAmount(amount);
	return Amount;
	}

}
