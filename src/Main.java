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

// BankAccount.java
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

// SavingsAccount.java
class SavingsAccount extends BankAccount {
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

// CheckingAccount.java
class CheckingAccount extends BankAccount {
    private double overdraftFee;

    public CheckingAccount(double initialBalance, double overdraftFee) {
        super(initialBalance);
        this.overdraftFee = overdraftFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            super.withdraw(amount);
        } else {
            System.out.println("Overdraft fee applied.");
            super.withdraw(amount + overdraftFee);
        }
    }
}