
public class Transaction {

    private String accountName;
    private double amount, remainder;

    public Transaction(String accountName, double amount, double remainder) {
        this.accountName = accountName;
        this.amount = amount;
        this.remainder = remainder;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRemainder() {
        return remainder;
    }

    public void setRemainder(double remainder) {
        this.remainder = remainder;
    }

}
