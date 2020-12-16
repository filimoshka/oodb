package lab_6.model;

import lab_6.annotation.Column;
import lab_6.annotation.Entity;
import lab_6.annotation.OneToMany;

import java.util.List;

@Entity
public class Order {

    public Order(){
    }

    @Column
    private Client client;
    @OneToMany
    private List<Product> products;

    public Order(Client client, List<Product> products)
    {
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
