public class CurrentAccount extends Account{
    public CurrentAccount(String accNumber,String ownerName){
        super(accNumber,ownerName);
    }

    @Override
    public boolean withdraw(double amount){
        if(amount<=balance){
            balance-=amount;
            return true;
        }
        return false;
    }

    @Override
    public void applyInterest() {

    }

    @Override
    public boolean canTransfer() {
        return true;
    }
}
