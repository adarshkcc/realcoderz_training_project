import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ATM 
{
	/* User validation */
	public static boolean validateBankDetails(Users u,Bank b)throws Exception
	{
		Connection con=AtmDAO.getConnection();
		String query="select * from bank where pin=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, u.getPin());
		ResultSet res=st.executeQuery();

		while(res.next())
		{
			b.setName(res.getString(1));
			b.setBalance(res.getDouble(2));
			b.setPin(res.getInt(3));
			b.setAccountHolder(res.getString(4));
			b.setAccountNumber(res.getInt(5));
			System.out.println("**************************************************************************");
			System.out.println("                              Welcome "+res.getString(4));
			System.out.println("**************************************************************************");

			return true;

		}
		return false;
	}

	/*         Transaction History       */
	public static boolean showTransactionHistory(ArrayList<Double> bl,double balance[],char ch[])
	{
		if(bl.isEmpty())
			System.out.println("you have not done any transaction");
		for(int i=0;i<bl.size();i++)
		{
			if(ch[i]=='w') //if amount is withdrawn then this block will execute
			{
				System.out.println(i+1+": Amount withdrawn :"+bl.get(i));
				System.out.println("   Balance          :"+balance[i]);
			}
			else if(ch[i]=='t')// if amount is transfered
			{
				System.out.println(i+1+":Amount Transferd  :"+bl.get(i));	
				System.out.println("   Balance          :"+balance[i]);
			}
		}

		System.out.println("Do u want to continue 1-Yes 2-No");
		int a=new Scanner(System.in).nextInt();
		if(a==2)
		{
			System.out.println("thanks for your visit 😊😊😊");
			System.exit(0);
		}
		return true;
	}

	public static double withdrawAmount(Bank b) throws Exception
	{
		Connection con=AtmDAO.getConnection();
		PreparedStatement st=con.prepareStatement("update bank set balance=? where account_number=?");
		st.setInt(2, b.getAccountNumber());
		double updatedBalance=0;
		System.out.println("Enter the Amount to Withdraw");
		Scanner s=new Scanner(System.in);
		double newBalance=0;
		double withdraw=s.nextDouble();

		if(b.getBalance()>=withdraw)
		{

			newBalance=b.getBalance()-withdraw;
			System.out.println("your Account is debited by INR "+withdraw+"Rs");
			System.out.println("Remaining balance : "+newBalance+"Rs");

			updatedBalance=newBalance;
			st.setDouble(1, updatedBalance);
			b.setBalance(updatedBalance);
			st.executeUpdate();
		}

		else
			System.out.println("Insufficient balance");
		return updatedBalance;
	}

	public static boolean checkBalance(Bank b)
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Your account balance is : INR "+b.getBalance()+"Rs");
		System.out.println("Do u want to continue 1-Yes 2-No");
		int a=sc.nextInt();
		if(a!=1)
		{
			System.out.println("Thanks for your visit 😊😊");
			System.exit(0);
		}
		return true;


	}

	public static double transferAmount(Bank b)throws Exception
	{
		System.out.println("Enter Account Number You Want To Transfer Amount");
		Scanner sc=new Scanner(System.in);
		int accNo=sc.nextInt();
		System.out.println("Enter the amount You want to transfer");
		double transferAmount=sc.nextDouble();

		
		double newBalance=b.getBalance()-transferAmount;
		
		
		Connection con=AtmDAO.getConnection();

		PreparedStatement st=con.prepareStatement("update bank set balance=? where Account_Number=?");//credit
		PreparedStatement select=con.prepareStatement("select * from bank where Account_Number=?");

		PreparedStatement st1=con.prepareStatement("update bank set balance=? where Account_Number=?");//debit
		PreparedStatement select1=con.prepareStatement("select * from bank where Account_Number=?");

		st.setInt(2,accNo );
		select.setInt(1, accNo);
		ResultSet res= select.executeQuery();//receiver
		while(res.next())
		{
			st.setDouble(1, (res.getDouble(2)+transferAmount));//amount get transferd to corresponding account
		}
		st.executeUpdate();//receiver balance get updated.

		st1.setInt(2, b.getAccountNumber());
		select1.setInt(1, b.getAccountNumber());
		ResultSet res1=select1.executeQuery();//sender
		while(res1.next())
		{
			st1.setDouble(1, (res1.getDouble(2)-transferAmount));//remaining balance after transfering amount.
		}
		st1.executeUpdate();//sender balance get updated.
		while(res1.next())
		{
			b.setBalance(res1.getDouble(2)-transferAmount);//updating balance in Bank class.
		}

		System.out.println("You have Successfully transferd INR "+transferAmount+"Rs");
		System.out.println("Remaining balance : "+newBalance+"Rs");

		//updatedBalance=newBalance;
		st1.setDouble(1, newBalance);
		b.setBalance(newBalance);
		st1.executeUpdate();

		return transferAmount;
	}

	public static void main(String[] args) throws Exception {
//int pin1;
		System.out.println("enter the pin");
		Scanner sc=new Scanner(System.in);
	int pin1=sc.nextInt();
//		try {
//		pin1=sc.nextInt();
//		//Users u=new Users(pin1);
//		}
//		catch(Exception e)
//		{
//			System.out.println("enter the pin in proper format");
//			 pin1=sc.nextInt();
//			//Users u=new Users(pin1);
//		}
		Users u=new Users(pin1);
		boolean a;int count=0;

		ArrayList<Double> bl=new ArrayList<Double>();
		Bank b=new Bank();
		/*           pin validation         */
		a=	ATM.validateBankDetails(u,b);    
		if(a==false)
		{
			System.out.println("enter valid pin");
			System.exit(0);

		}

		boolean c=true;int d,s=0;double originalBalance=b.getBalance();
		double balance[]=new double[10];
		char ch[] = new char[10];
		/* while loop is used because if we continue to perform the operation */
		while(c) {
			System.out.println("_____________________________________");
			System.out.println("What Operation do u want to perform");
			System.out.println("_____________________________________");
			System.out.println();
			System.out.print("1.Show Transaction History");
			System.out.println("                            2.Withdraw");
			System.out.println();
			System.out.print("3.Check Balance");
			System.out.println("                                       4.Transfer Money");
			System.out.println();
			System.out.println("5.Exit");
			int n=sc.nextInt(); double ub=0;

			switch(n)
			{
			//older transaction history;
			case 1:
			{
				c=ATM.showTransactionHistory(bl,balance,ch);
				if(c==true)
					continue;
				break;
			}
			// withdraw function
			case 2:
			{
				ub=ATM.withdrawAmount(b);
				balance[s]=ub;

				double withdrawAmount=originalBalance-ub;
				originalBalance=ub;
				bl.add(withdrawAmount); //Arraylist bl is used to store older transaction amount.

				ch[s]='w';
				s++;
				System.out.println("Do you want continue: 1-yes  2-no");
				d=sc.nextInt();
				if(d==1)
					continue;
				else
				{
					System.out.println("thanks for your visit 😊😊");
					System.exit(0);
				}

				break;
			}
			case 3:
			{
				c=	ATM.checkBalance(b);
				if (c==true)
					continue;
				break;
			}
			case 4:
			{
				double transferedAmount=ATM.transferAmount(b);
				bl.add(transferedAmount);
				balance[s]=b.getBalance();
				ch[s]='t';
				s++;
				System.out.println("Do you want to continue 1-Yes 2-No");
				d=sc.nextInt();
				if(d==1)
					continue;
				else
				{
					System.out.println("Thanks for your visit 😊😊😊😊😊😊");
					System.exit(0);
				}
				break;
			}
			case 5:
			{
				System.out.println("Thanks for your visit 😊😊");
				break;
			}
			default:
			{
				System.out.println("Choose the valid Option");
				break;
			}
			}
			break;
		}

	}
}