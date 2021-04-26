package lab12.domain;


import javax.persistence.*;

@Entity
public class Product {

    @Id
    @SequenceGenerator(name="Product", sequenceName="product_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Product")
    public int id;

    @Column
    private int price;

    @Column
    private int quantity;

    @Column
    private String name;

    public Product(int price, int quantity, String name)
    {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getId(){return id; }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
