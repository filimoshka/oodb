package lab4.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Order {

    private long orderID;
    private Delivery delivery;
    private List<Product> products;
    private Transaction transaction;

    public Order(long orderID, Delivery delivery, List<Product> products, Transaction transaction) {
        this.orderID = orderID;
        this.delivery = delivery;
        this.products = products;
        this.transaction = transaction;
    }

    public Order() {
    }

    @XmlElement(name = "orderID")
    long getOrderID() {
        return orderID;
    }

    @XmlElement(name = "delivery")
    Delivery getDelivery() {
        return delivery;
    }

    @XmlElement(name = "transaction")
    Transaction getTransaction() {
        return transaction;
    }

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    List<Product> getProducts() {
        return products;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void setProducts(List<Product> products) {
        this.products= products;
    }

    @Override
    public String toString() {
        return "ORDER:" +
                " orderID = " + orderID +
                "; delivery = " + delivery +
                "; products = " + products +
                "; transaction = " + transaction +
                '\n';
    }
}
