package lab1;

public class Product {
    String name;
    String description;
    public Category category;
    int price;

    public Product(String name, String description, Category category, int price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}
