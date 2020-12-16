package lab_6.model;

import lab_6.annotation.Column;
import lab_6.annotation.Entity;
import lab_6.annotation.OneToMany;

import java.util.List;

@Entity
public class Shop {

    public Shop(){
    }

    @Column
    private String name;
    @OneToMany
    private List<Client> clients;
    @OneToMany
    private List<Product> products;
    @OneToMany
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