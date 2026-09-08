class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {

    private int accountNumber;
    private double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero"
            );
        }

        balance += amount;
        System.out.println("Deposited: Rs. " + amount);
    }

    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero"
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance"
            );
        }

        balance -= amount;
        System.out.println("Withdrawn: Rs. " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

public class BankingApp {

    static BankAccount findAccount(int number)
            throws AccountNotFoundException {

        if (number != 101) {
            throw new AccountNotFoundException(
                "Account not found"
            );
        }

        return new BankAccount(101, 5000);
    }

    public static void main(String[] args) {

        try {
            BankAccount account = findAccount(101);

            account.deposit(2000);
            account.withdraw(1000);

            System.out.println(
                "Current Balance: Rs. " + account.getBalance()
            );

            account.withdraw(10000);

        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
