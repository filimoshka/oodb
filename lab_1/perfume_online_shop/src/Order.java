public class Order {
    public Product product;
    public Client client;
    public Delivery delivery;
    public Transaction transaction;

    public Order(Product product, Client client, Delivery delivery, Transaction transaction) {
        this.product = product;
        this.client = client;
        this.delivery = delivery;
        this.transaction = transaction;
    }

    public void confirm(Order order) {
        System.out.println("-----Заказ сформирован-----" + "\n" +
                            "Парфюм: " + product.getName() + "\n" +
                            "Категория: " + product.getCategory() + "\n" +
                            "Описание: " + product.getDescription() + "\n" +
                            "Сумма заказа: " + delivery.getPrice(product, delivery) + "\n" +
                            "Способ доставки: " + delivery.getDeliveryMethod() + "\n" +
                            "Инфо о клиенте: " + client.getFirstName() + " " + client.getLastName() + ", " + client.getEmail() + "\n" +
                            "Адрес: " + delivery.deliveryAddress + "\n" +
                            "Крайний срок доставки: " + delivery.getDeliveryDate().getTime());
    }
}
