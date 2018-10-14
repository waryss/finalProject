package finalProject.model;

public final class CurrentAccount extends Account {
    private final int minBalance = 1000;

    public CurrentAccount(int an, String n, int a) {
        super(an, n, a);
    }

    @Override
    public void deposit(int depositAmount) {
        amount = amount + depositAmount;
        System.out.println("your balance is now:" + amount);
    }

    @Override
    public void withdraw(int withdrawAmount) {
        if (amount - withdrawAmount > minBalance) {
            amount = amount - withdrawAmount;
            System.out.println("your balance is now:" + amount);
        } else
            System.out.println("Your balance is to low" + amount);


    }
}
