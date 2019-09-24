public class Checkings extends Account {
    int overdraftfee = 30;

    public Checkings(double mbalance, String mowner) {
        super(mbalance, mowner);
        this.balance = mbalance;
        this.owner = mowner;
    }

    /**
     * this is for taking money out of the bank
     * 
     * @param amount is the amount that will be withdrawn
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("cannot be a negative value");
        }
        this.balance -= (overdraftfee + amount);
        if (this.getBalance() < 0) {
            System.out.print("You have overdrafted your account and have been charged " + "$30\n" + "Your new balance is: " + this.getBalance());
        }
        else {
            this.balance -= amount;
        }
    }
}
