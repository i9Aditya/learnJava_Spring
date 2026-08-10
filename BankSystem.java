import java.util.*;

interface AccountOperations {
    String getName();
    int getAccountNumber();
    double getBalance();
    String getPassword();
    String getAccountType();
}

class BankAccount implements AccountOperations {
    private String name;
    private int accountNumber;
    private double balance;
    private String password;
    private String accountType;
    //private static final String BankName = "MyBank";

    public BankAccount(String name, int accountNumber, double balance, String password, String accountType) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
        this.accountType = accountType;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getAccountType() {
        return accountType;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String name, int accountNumber, double balance, String password) {
        super(name, accountNumber, balance, password, "savings");
    }

    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful. New balance: " + getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String name, int accountNumber, double balance, String password) {
        super(name, accountNumber, balance, password, "current");
    }

    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful. New balance: " + getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}


class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }
    public boolean BankAccountExists(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(BankAccount account) {
        if(BankAccountExists(account.getAccountNumber())) {
            System.out.println("Account with this number already exists.");
            return;
        }
        accounts.add(account);
    }

    public BankAccount getAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public boolean authenticate(int accountNumber, String password) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            return account.getPassword().equals(password);
        }
        return false;
    }

    void deposit(int accountNumber, double amount,String password) {
        if (!authenticate(accountNumber, password)) {
            System.out.println("Authentication failed.");
            return;
        }
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            System.out.println("Deposit successful. New balance: " + newBalance);
        } else {
            System.out.println("Account not found.");
        }
    }

    void withdraw(int accountNumber, double amount, String password) {
         if (!authenticate(accountNumber, password)) {
            System.out.println("Authentication failed.");
            return;
        }
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            if (account.getBalance() >= amount) {
                double newBalance = account.getBalance() - amount;
                account.setBalance(newBalance);
                System.out.println("Withdrawal successful. New balance: " + newBalance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
}

public class BankSystem {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        while(true){
            
            System.out.println("Welcome to the Bank System");
            System.out.println("Please select an option:");
            System.out.println("1. Create a new user");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            int option = scanner.nextInt();

            if(option == 1){
            System.out.println("Enter your name:");
            String name = scanner.next();
            System.out.println("Enter your account number:");
            int accountNumber = scanner.nextInt();
            System.out.println("Enter your initial balance:");
            double balance = scanner.nextDouble();
            System.out.println("Enter your password:");
            String password = scanner.next();
            System.out.println("Enter your account type (savings/current):");
            String accountType = scanner.next();

            BankAccount newAccount = new BankAccount(name, accountNumber, balance, password, accountType);
            //Bank bank = new Bank();
            bank.addAccount(newAccount);
            System.out.println("Account created successfully!");
        }else if(option == 2){
            System.out.println("Enter your account number:");
            int accountNumber = scanner.nextInt();
            System.out.println("Enter the amount to deposit:");
            double amount = scanner.nextDouble();
            System.out.println("Enter your password:");
            String password = scanner.next();

            //Bank bank = new Bank();
            bank.deposit(accountNumber, amount,password);
        }else if(option == 3){
            System.out.println("Enter your account number:");
            int accountNumber = scanner.nextInt();
            System.out.println("Enter the amount to withdraw:");
            double amount = scanner.nextDouble();
            if(!bank.BankAccountExists(accountNumber)) {
                System.out.println("Account with this number does not exist.");
                continue;
            }else if(bank.getAccount(accountNumber).getBalance() < amount) {
                System.out.println("Insufficient balance.");
                continue;
            }
            System.out.println("Enter your password:");
            String password = scanner.next();

            //Bank bank = new Bank();
            bank.withdraw(accountNumber, amount, password);
        }else if(option == 4){
            System.out.println("Enter your account number:");
            int accountNumber = scanner.nextInt();
            System.out.println("Enter your password:");
            String password = scanner.next();
             if (!bank.authenticate(accountNumber, password)) {
            System.out.println("Authentication failed.");
            return;
        }
            BankAccount account = bank.getAccount(accountNumber);
            if(account != null){
                System.out.println("Your balance is: " + account.getBalance());
            }else{
                System.out.println("Account not found.");
            }
        }else if(option == 5){
                System.out.println("Exiting the system. Thank you!");
                break;
        }else{
                System.out.println("Invalid option. Please try again.");
                break;
            }
            
        }
        scanner.close();

    }
}
