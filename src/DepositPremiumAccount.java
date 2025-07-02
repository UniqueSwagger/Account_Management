public class DepositPremiumAccount extends Account{
    private final double rate = 0.07;
    private int depositsMade = 0;
    private final int requiredInstallments = 5;
    public DepositPremiumAccount(String accNumber, String ownerName) {
        super(accNumber, ownerName);
    }
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            depositsMade++;
            applyInterest();
        }
    }
    @Override
    public boolean withdraw(double amount) {
        if (depositsMade >= requiredInstallments) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            } else {
                System.out.println("Not enough balance.");
                return false;
            }
        } else {
            System.out.println("Withdrawal not allowed before completing all " + requiredInstallments + " installments.");
            return false;
        }
    }
    @Override
    public void applyInterest() {
        balance += balance * rate;
    }
    @Override
    public boolean canTransfer() {
        return false;
    }
}
