package lab4.model;

public class Product {
    public String name;
    public Category category;
    public int price;

    public Product(String name, Category category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ", " + category + ", " + price;
    }
}
