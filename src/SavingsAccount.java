public class SavingsAccount extends Account{
    private final double rate = 0.025;
    public SavingsAccount(String accNumber, String ownerName) {
        super(accNumber, ownerName);
    }
    @Override
    public boolean withdraw(double amount){
        if(balance-amount>=1000){
            balance-=amount;
            return true;
        }
        return false;
    }

    @Override
    public void applyInterest() {
        balance += balance * rate;
    }

    @Override
    public boolean canTransfer() {
        return true;
    }
}
