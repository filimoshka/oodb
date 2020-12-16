package lab_6.model;

import lab_6.annotation.Column;
import lab_6.annotation.Entity;

@Entity
public class Product {

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

    public Product(String name, int price, int quantity, Category category)
    {
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
