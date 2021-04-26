package lab12.domain;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Order {


    @Id
    @SequenceGenerator(name="Order", sequenceName="order_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Order")
    public int id;

    @ManyToOne
    private Client client;

    @OneToMany
    private Collection<Product> productList;

    public Order(Client client, Collection<Product> productList)
    {
        this.client = client;
        this.productList = productList;
    }


    public Client getClient() {
        return client;
    }

    public Collection<Product> getProductList() {
        return productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProductList(Collection<Product> productList) {
        this.productList = productList;
    }

}
