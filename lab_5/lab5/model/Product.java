package lab5.model;

import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;
import java.sql.SQLException;

public class Product extends PGobject {

    public Product(){
        setType("product");
    }

    private String name;
    private int price;
    private int quantity;
    private Category category;

    public Product(String name, int price, int quantity, Category category)
    {
        this.name = name;
        this.price=price;
        this.quantity=quantity;
        this.category=category;
    }

    public void setValue(String value) throws SQLException {
        String str = value.substring(1, value.length()-1);
        PGtokenizer pgt = new PGtokenizer(str, ',');
        name = pgt.getToken(0).substring(1, pgt.getToken(0).length()-1);
        price = Integer.parseInt(pgt.getToken(1).substring(1, pgt.getToken(1).length()-1));
        quantity = Integer.parseInt(pgt.getToken(2).substring(1, pgt.getToken(2).length()-1));
        category = Category.valueOf(pgt.getToken(3).substring(1, pgt.getToken(3).length()-1));
    }

    public String getValue() {
        return "('" + name + "'," + price + "," + quantity + "," + category.toString() + ")";
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
