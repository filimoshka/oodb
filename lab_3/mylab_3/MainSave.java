package mylab_3;


import mylab_3.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Пример, демонстрирующий сохранение (marshalling) объекта в XML документ
 */
public class MainSave {

    public static void main(String[] args) {

        // Создаем объект Магазин
        Shop shop = new Shop();

        // Создаем заказ
        Client client = new Client("Иван","Иванов","","");

        Delivery delivery = new Delivery("...", DeliveryMethod.courier);

        Product product = new Product("#1", Category.citrus, 5000);
        List<Product> products = new ArrayList<>();
        products.add(product);

        Transaction transaction = new Transaction(new Date(), true);

        Order order = new Order(1299876, delivery, products, transaction);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        client.setOrders(orders);

        List<Client> clients = new ArrayList<>();
        clients.add(client);

        shop.setClients(clients);

        // сохраняем объект в в XML документ
        XMLService.saveShopData(shop);
    }
}
