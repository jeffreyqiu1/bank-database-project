
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;

public class Customer {

    private String filename;
    private String name;
    private int PIN;
    private LocalDate birthDate;
    private Account CheqAcc, SaveAcc, CreditCard;
    private Customer previous, next;
    private Double creditLimit;
    ArrayList<Transaction> transactionList;

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Account getCheqAcc() {
        return CheqAcc;
    }

    public void setCheqAcc(Account CheqAcc) {
        this.CheqAcc = CheqAcc;
    }

    public Account getSaveAcc() {
        return SaveAcc;
    }

    public void setSaveAcc(Account SaveAcc) {
        this.SaveAcc = SaveAcc;
    }

    public Account getCreditCard() {
        return CreditCard;
    }

    public void setCreditCard(Account CreditCard) {
        this.CreditCard = CreditCard;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Customer getPrevious() {
        return previous;
    }

    public void setPrevious(Customer previous) {
        this.previous = previous;
    }

    public Customer getNext() {
        return next;
    }

    public void setNext(Customer next) {
        this.next = next;
    }

    public Boolean tooYoung() {
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthDate, today);

        if (age.getYears() < 18) {
            return true;
        } else {
            return false;
        }
    }

    public Customer(Customer c) {
        //used to transfer data when sorting customers
        //the indices/pointers don't change positions but the info in them does
        name = c.getName();
        PIN = c.getPIN();
        filename = c.getFilename();
        birthDate = c.getBirthDate();
        CheqAcc = c.getCheqAcc();
        SaveAcc = c.getSaveAcc();
        CreditCard = c.getCreditCard();
        creditLimit = c.getCreditLimit();
    }

    public Customer(String n, int i, String f, LocalDate d, double ca, Boolean caf, double sa, Boolean saf, double cc, Boolean ccf, double cclimit) {
        name = n;
        PIN = i;
        filename = f;
        birthDate = d;
        CheqAcc = new Account(ca, caf, "Chequing");
        SaveAcc = new Account(sa, saf, "Savings");
        CreditCard = new Account(cc, ccf, "Credit");
        creditLimit = cclimit;
        transactionList = new ArrayList<Transaction>();

        //create file for customer
        try {
            File file = new File(f);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                filename = f;
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

        ///write to file
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(name);
            myWriter.write("\n");
            myWriter.write("" + PIN);
            myWriter.write("\n");
            myWriter.write("" + birthDate);
            myWriter.write("\n");
            myWriter.write("" + CheqAcc.getBalance());
            myWriter.write("\n");
            myWriter.write("" + caf);
            myWriter.write("\n");
            myWriter.write("" + SaveAcc.getBalance());
            myWriter.write("\n");
            myWriter.write("" + saf);
            myWriter.write("\n");
            myWriter.write("" + CreditCard.getBalance());
            myWriter.write("\n");
            myWriter.write("" + ccf);
            myWriter.write("\n");
            myWriter.write("" + cclimit);
//            for (int k = 0; k < transactionList.size(); k++) {
//                Transaction t = transactionList.get(k);
//                myWriter.write("\n");
//                myWriter.write("" + t.getAccountName() + " " + t.getAmount() + " " + t.getRemainder());
//            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void updateFile(Customer c) {
        try {
            FileWriter myWriter = new FileWriter(c.filename);
            myWriter.write(c.name);
            myWriter.write("\n");
            myWriter.write("" + c.PIN); //" casts all int to string
            myWriter.write("\n");
            myWriter.write("" + c.birthDate);
            myWriter.write("\n");
            myWriter.write("" + c.CheqAcc.getBalance());
            myWriter.write("\n");
            myWriter.write("" + c.CheqAcc.isFrozen());
            myWriter.write("\n");
            myWriter.write("" + c.SaveAcc.getBalance());
            myWriter.write("\n");
            myWriter.write("" + c.SaveAcc.isFrozen());
            myWriter.write("\n");
            myWriter.write("" + c.CreditCard.getBalance());
            myWriter.write("\n");
            myWriter.write("" + c.CreditCard.isFrozen());
            myWriter.write("\n");
            myWriter.write("" + c.creditLimit);

            for (int k = 0; k < transactionList.size(); k++) {
                if (k == 5) {
                    break;
                }
                Transaction t = c.transactionList.get(k);
                myWriter.write("\n");
                myWriter.write("" + t.getAccountName() + " " + t.getAmount() + " " + t.getRemainder());
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void setName(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public void setPIN(int i) {
        PIN = i;
    }

    public int getPIN() {
        return PIN;
    }

    public void setFilename(String s) {
        filename = s;
    }

    public String getFilename() {
        return filename;
    }

}
