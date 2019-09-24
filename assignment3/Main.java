import java.util.*;

class Main {

    public static void main(String[] args) {
        Checkings account = new Checkings(0, "Dillon");
        account.deposit(73.11);
        System.out.println(account.getBalance());
        account.withdraw(100.32);
    }

}
