public abstract class Account {
    protected String accNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accNumber,String ownerName){
        this.accNumber=accNumber;
        this.ownerName=ownerName;
        this.balance=0;
    }
    public abstract boolean withdraw(double amount);
    public abstract void applyInterest();
    public abstract boolean canTransfer();

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            applyInterest();
        }
    }

    public boolean transfer(Account to, double amount) {
        if (!this.canTransfer()) {
            System.out.println("Transfer not allowed from this account.");
            return false;
        }
        if (this.withdraw(amount)) {
            to.deposit(amount);
            return true;
        } else {
            System.out.println("Transfer failed: insufficient balance or restrictions.");
            return false;
        }
    }

    public void printDetails() {
        System.out.println("Account Number: " + accNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------------");
    }
}
