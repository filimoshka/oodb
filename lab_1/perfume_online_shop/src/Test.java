public class Test {
    public static void main(String[] args) {
        Client client = new Client("Александра", "Иванова", "+79871111111", "sasha@gmail.com", "Москва", "...");
        Product product = new Product("№1", "...", Category.citrus, 4500);
        Delivery delivery = new Delivery(DeliveryMethod.courier, "...", product);
        Transaction transaction = new Transaction(product, delivery, true, 0000000000000000, 12, 21, 000, delivery.getPrice(product,delivery));
        Order order = new Order(product, client, delivery, transaction);
        order.confirm(order);
    }
}
