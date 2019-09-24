public class Account {
    double balance;
    String owner;

    public Account(double mbalance, String mowner) {
        balance = mbalance;
        owner = mowner;
    }

    public Account() {
        this.balance = getBalance();
        this.owner = getOwner();
    }

    /**
     *
     * @return the balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * deposit function
     * 
     * @param amount is the amount that will be put into the account balance
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("cannot be a negative value");
        } else {
            balance += amount;
        }
    }

    /**
     * withdraw function
     * 
     * @param amount takes money out of account and subtracts from balance
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("cannot be a negative value");
        } else {
            balance -= amount;
        }
    }

    /**
     * getowner function
     * 
     * @return the owner of the account
     */
    public String getOwner() {
        return owner;
    }
}
