package lab5;

import lab5.model.Category;
import lab5.model.Client;
import lab5.model.Order;
import lab5.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    // поиск клиента по имени
    public static Client findClientByName(List<Client> clients, String searchFirstName) {
        Client result = null;

        for (Client client : clients) {
            if (client.getFirstName().equals(searchFirstName)) {
                result = client;
            }
        }

        return result;
    }

    // поиск товаров по категории
    public static List<Product> findProductByCategory(List<Product> products, Category category) {
        List<Product> result = null;

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }

    // поиск заказов по имени клиента
    public static List<Order> findOrdersByClientFirstName(List<Order> orders, String firstName) {

        List<Order> result = null;

        for (Order order : orders) {
            if (order.getClient().getFirstName().equals(firstName)) {
                result.add(order);
            }
        }
        return result;
    }

    // сортировка товаров по цене
    public static List<Product> sortProductByPrice(List<Product> list)
    {

        List<Product> result = list
                .stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
        return result;



    }

}
