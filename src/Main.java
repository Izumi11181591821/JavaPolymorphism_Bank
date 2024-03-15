// Main.java
public class Main {
    public static void main(String[] args) {
        BankAccount savingsAccount = new SavingsAccount(2000000, 100000, 200); // (initialBalance, withdrawalLimit, withdrawalFee)
        BankAccount checkingAccount = new CheckingAccount(500000, 40); // (initialBalance, overdraftFee)

        withdrawFromAccount(savingsAccount, 80000);
        withdrawFromAccount(checkingAccount, 300000);

        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Checking Account Balance: " + checkingAccount.getBalance());
    }

    public static void withdrawFromAccount(BankAccount account, double amount) {
        account.withdraw(amount);
    }
}
