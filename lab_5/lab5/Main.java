package lab5;

import lab5.model.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, JAXBException {
        try {
            Shop shop = new Shop("<<< Perfume Online Shop >>>");
            List<Client> clients = new ArrayList();
            List<Product> products = new ArrayList();
            List<Order> orders = new ArrayList();

            Client client1=new Client("Ivan", "Ivanov", "12345", "ivan@mail.ru");
            Client client2=new Client("Olga", "Ivanova", "12345", "olga@mail.ru");

            Product product1 = new Product("perfume_№1", 3800, 1, Category.floral);
            Product product2 = new Product("perfume_№2", 1200, 2, Category.powdery);
            Product product3 = new Product("perfume_№3", 7800, 1, Category.aquatic);
            products.add(product1);
            products.add(product2);
            products.add(product3);

            Order order1 = new Order(client1, products);
            Order order2 = new Order(client2, products);
            orders.add(order1);
            orders.add(order2);

            clients.add(client1);
            clients.add(client2);
            shop.setClients(clients);
            shop.setProduct(products);
            shop.setOrders(orders);

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/oodb_lab5", "postgres", "pst5326gr");

            SaveDB.saveShop(shop.getName(), shop.getClients(), shop.getProducts(), shop.getOrders(), connection);

            System.out.println("--- Clients: ---");
            System.out.println("");

            String str = LoadFromDB.loadClient(connection);
            System.out.println(str);
            str = str.substring(2, str.length()-2);
            client1.setValue(str.split("\"")[0]);

            System.out.println(client1.getFirstName());

            System.out.println("");
            System.out.println("--- Products: ---");
            System.out.println("");

            String s = LoadFromDB.loadProducts(connection);
            System.out.println(s);
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}