
public class Account {

    private Double balance;
    private boolean frozen;
    private String accountName;

    public boolean switchFrozen() {
        System.out.println(frozen);
        frozen = !frozen;
        System.out.println(frozen);
        return frozen;
    }

    public Account(Double d, boolean b, String s) {
        balance = d;
        frozen = b;
        accountName = s;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setIsFrozen(boolean frozen) {
        this.frozen = frozen;
    }

}
