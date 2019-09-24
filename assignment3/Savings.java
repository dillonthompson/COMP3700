public class Savings extends Account {
    double monthlyMin = 50;
    double monthlyTotal = 0;
    int timeswithdrawn = 0;
    int monthlyFee = 50;
    public Savings(double mbalance, String mowner) {
        super(mbalance, mowner);
        this.balance = mbalance;
        this.owner = mowner;
    }

    /**
     * this the deposit function for savings accounts.
     * 
     * @param amount is the amount that will be deposited into the account
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("amount cannot be negative");
        }
        else {
            this.balance += amount;
            monthlyTotal += amount;
        }
    }

    /**
     * this is the withdraw function for savings accounts
     * 
     * @param amount is the amount withdrawn from the account
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("cannot be a negative number");
        }
        else if (timeswithdrawn >= 5) {
            System.out.println("You have already withdrawn 5 times this month.");
        }
        else {
            this.balance -= amount;
            timeswithdrawn++;
        }
    }

    public void monthlyCheck() {
        if (monthlyTotal < monthlyMin) {
            System.out.println("You did not deposit enough money this month and are being charge a $50 fee.");
            this.balance -= monthlyFee;
            System.out.println("Here is your new balance: " + this.getBalance());
        }
        else {
            System.out.println("You have deposited more than the minimum and you will not be charged.");
        }
    }
}