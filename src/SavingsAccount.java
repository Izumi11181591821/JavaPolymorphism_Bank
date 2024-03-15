// SavingsAccount.java
public class SavingsAccount extends BankAccount {
    private double withdrawalLimit;
    private double withdrawalFee;

    public SavingsAccount(double initialBalance, double withdrawalLimit, double withdrawalFee) {
        super(initialBalance);
        this.withdrawalLimit = withdrawalLimit;
        this.withdrawalFee = withdrawalFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= withdrawalLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal limit exceeded. Fee applied.");
            super.withdraw(amount + withdrawalFee);
        }
    }
}
