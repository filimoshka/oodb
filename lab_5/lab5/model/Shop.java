package lab5.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "shop")
public class Shop {

    public Shop(){
    }

    private String name;
    private List<Client> clients;
    private List<Product> products;
    private List<Order> orders;

    public Shop(String name)
    {
        this.name=name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order)
    {
        this.orders.add(order);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}