package lab1;

public class Transaction {
    boolean success;
    long card_number;
    int card_month;
    int card_year;
    int cvv;
    double price;
    public Product product;
    public Delivery delivery;

    public Transaction(Product product, Delivery delivery, boolean success, long card_number, int card_month, int card_year, int cvv, double price) {
        this.product = product;
        this.delivery = delivery;
        this.success = success;
        this.card_number = card_number;
        this.card_month = card_month;
        this.card_year = card_year;
        this.cvv = cvv;
        this.price = price;
    }

    public long getCard_number() {
        return card_number;
    }

    public int getCard_month() {
        return card_month;
    }

    public int getCard_year() {
        return card_year;
    }

    public int getCvv() {
        return cvv;
    }
}
