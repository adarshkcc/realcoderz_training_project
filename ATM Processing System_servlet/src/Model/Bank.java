package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
	private static String bankName;
	private static double balance;
	private  static String accountHolder;
	private static long accountNumber;
	
public static List<Double> store=new ArrayList<Double>();
public static List<Double> remainingBalance=new ArrayList<Double>();
public static List<Character>ch=new ArrayList<Character>();

public static boolean flag;

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

}
