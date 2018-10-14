
public abstract class Account {
	public int accountNumber;
	public String name;
	public int amount;
	public Account(int an,String n, int a) {
		accountNumber=an;
		name=n;
		amount=a;
		
		}
	
	public void deposit(int depositAmount)
	{
		amount=amount +depositAmount;
	}

	
	public void withdraw(int withdrawAmount) {
			amount=amount - withdrawAmount;
		
		
	}

}
