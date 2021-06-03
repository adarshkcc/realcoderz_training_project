

public class Bank {
	private String name;
	private double balance;
	private int pin;
	private String accountHolder;
	private int accountNumber;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Bank() {
		super();
	}

	public Bank(String name, double balance,int pin,String accountHolder)
	{
		this.name=name;
		this.balance=balance;
		this.pin=pin;
		this.accountHolder=accountHolder;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public int getPin() {
		return pin;
	}



	public void setPin(int pin) {
		this.pin = pin;
	}



	public String getAccountHolder() {
		return accountHolder;
	}



	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}



	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
