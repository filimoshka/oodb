package lab5.model;

import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)

public class Order extends PGobject {

    public Order(){
        setType("order");
    }

    private Client client;
    private List<Product> products;

    public Order(Client client, List<Product> products)
    {
        this.client=client;
        this.products=products;
    }

    public void setValue(String value) throws SQLException {
        String str = value.substring(1, value.length()-1);
        PGtokenizer pgt = new PGtokenizer(str, ',');
        client.setValue(pgt.getToken(0));
        String[] array = pgt.getToken(1).substring(1, pgt.getToken(1).length()-1).split(",");
        List<Product> list = new ArrayList<>();
        Product product = new Product();
        for (String i: array)
        {
            product.setValue(i);
            list.add(product);
        }
        products=list;
    }

    public String getValue() {
        String s="{";
        for(Product product: products)
        {
            s=s+product.getValue()+"\",\"";
        }
        s=s.substring(0, s.length()-2);
        s=s+"}";
        return "('" + client.getValue() + "\",\"" + s + "')";
    }

    public static void confirmOrder(Client client, List<Product> products)
    {
        System.out.println(client.toString());
        client.setOrder(products);
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
