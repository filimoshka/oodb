package mylab_3.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Client extends Person {

    public Client(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public Client() {
    }

    private List<Order> orders;

    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CLIENT: " + getFirstName() + " " + getLastName() +
                ", orders = " + orders +
                '\n';
    }
}