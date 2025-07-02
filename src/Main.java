import java.util.*;
public class Main {
    static ArrayList<Account> accounts=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Account Management Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Show Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> transfer();
                case 5 -> showAccount();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static Account findAccount(String accNum) {
        for (Account acc : accounts) {
            if (acc.accNumber.equals(accNum)) {
                return acc;
            }
        }
        return null;
    }

    static void createAccount() {
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();

        if (findAccount(accNum) != null) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter owner name: ");
        String name = sc.nextLine();

        System.out.println("Choose account type:");
        System.out.println("1. Current Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Deposit Premium Account");
        int type = sc.nextInt();
        sc.nextLine();

        Account acc = null;
        switch (type) {
            case 1 -> acc = new CurrentAccount(accNum, name);
            case 2 -> acc = new SavingsAccount(accNum, name);
            case 3 -> acc = new DepositPremiumAccount(accNum, name);
            default -> {
                System.out.println("Invalid account type.");
                return;
            }
        }
        accounts.add(acc);
        System.out.println("Account created successfully.");
    }
    static void deposit() {
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();
        Account acc = findAccount(accNum);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        acc.deposit(amt);
        System.out.println("Deposit successful.");
    }
    static void withdraw() {
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();
        Account acc = findAccount(accNum);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        if (acc.withdraw(amt))
            System.out.println("Withdrawal successful.");
        else
            System.out.println("Withdrawal failed.");
    }
    static void transfer() {
        System.out.print("Enter sender account number: ");
        String from = sc.nextLine();
        Account a1 = findAccount(from);
        if (a1 == null) {
            System.out.println("Sender account not found.");
            return;
        }
        System.out.print("Enter receiver account number: ");
        String to = sc.nextLine();
        Account a2 = findAccount(to);
        if (a2 == null) {
            System.out.println("Receiver account not found.");
            return;
        }
        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        if (a1.transfer(a2, amt))
            System.out.println("Transfer successful.");
        else
            System.out.println("Transfer failed.");
    }
    static void showAccount() {
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();
        Account acc = findAccount(accNum);
        if (acc != null)
            acc.printDetails();
        else
            System.out.println("Account not found.");
    }
}
