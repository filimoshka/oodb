package lab4.model;

import java.util.Date;

public class Transaction {

    public Date transactionDate;
    public boolean success;

    public Transaction(Date transactionDate, boolean success) {
        this.transactionDate = transactionDate;
        this.success = success;

    }

    public Transaction() {
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return transactionDate + ", " + success;
    }

}

