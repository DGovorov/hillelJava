package multithreading;

/**
 * Created by User on 29.04.2016.
 */
public class Bank {

    private long account1 = 10_000_000;
    private long account2 = 10_000_000;

    private final Object lock = new Object();

    public void transfer(boolean direction, int amount) {
        synchronized (lock) {
            if (direction) {
                account1 -= amount;
                account2 += amount;
            } else {
                account2 -= amount;
                account1 += amount;
            }
        }
    }

    public void check() {
        String message = "";
        synchronized (lock) {
            if (account1 + account2 != 20_000_000) {
                message = "Something wrong happened!";
            }
            message += " Account1: " + account1;
            message += " Account2: " + account2;
        }
        System.out.println(message);
    }

}
