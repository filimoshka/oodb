package lab7.model;

import lab7.annotation.Id;
import lab7.annotation.Column;
import lab7.annotation.Entity;

@Entity
public class Product {

    @Column
    @Id
    public long id;
    public Product(){
    }

    @Column
    private String name;
    @Column
    private int price;
    @Column
    private int quantity;
    @Column
    private Category category;

    public Product(long id, String name, int price, int quantity, Category category)
    {
        this.id = id;
        this.name = name;
        this.price=price;
        this.quantity=quantity;
        this.category=category;
    }

    public Integer getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
