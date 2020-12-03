package lab5;

import com.google.gson.Gson;
import lab5.model.Client;
import lab5.model.Order;
import lab5.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SaveDB {

    public static void saveClient(Client client, Connection connection) throws SQLException {

        PreparedStatement statement = connection.
                prepareStatement("insert into record (client) values ( cast( ? as client) )");
        System.out.println(client.getValue());
        statement.setString(1, client.getValue());
        int count = statement.executeUpdate();

        System.out.println(count + " records added!");
        statement.close();
    }

    public static void saveShop(String name, List<Client> clients, List<Product> products, List<Order> orders, Connection connection) throws SQLException {

        PreparedStatement statement = connection.
                prepareStatement("insert into shop (name, clients, products) values ((?), cast( ? as client[]), cast( ? as product[]) )");
        String s= "{\"";
        for (Client client: clients) {
            s=s+client.getValue()+"\",\"";
        }
        s=s.substring(0, s.length()-2);
        s=s+"}";

        statement.setString(1, name);
        statement.setString(2, s);
        s="{\"";
        for (Product product: products) {
            s=s+product.getValue()+"\",\"";
        }
        s=s.substring(0, s.length()-2);
        s=s+"}";
        statement.setString(3, s);
        s="{\"";
        for (Order order: orders) {
            s=s+order.getValue()+"\",\"";
        }
        s=s.substring(0, s.length()-2);
        s=s+"}";
        int count = statement.executeUpdate();

        System.out.println(count + " records added!");
        statement.close();

    }
}