package facadePatternTransaction.copy;

public interface Transaction 
{
public abstract double withdrawAmount(double amount);
public abstract double checkBalance();
public abstract double transferAmount(double amount,long accountNo);
public abstract boolean transactionHistory();

}
