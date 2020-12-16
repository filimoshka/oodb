package lab7.model;

import lab7.annotation.Column;
import lab7.annotation.Entity;
import lab7.annotation.Id;
import lab7.annotation.OneToMany;

import java.util.List;

@Entity
public class Order {

    public Order(){
    }

    @Column
    @Id
    public long id;

    @Column
    private Client client;
    @OneToMany
    private List<Product> products;

    public Order(long id, Client client, List<Product> products)
    {
        this.id = id;
        this.client=client;
        this.products=products;
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProductList() {
        return products;
    }


    public void setClient(Client client) {
        this.client = client;
    }

    public void setProductList(List<Product> products) {
        this.products = products;
    }

}
