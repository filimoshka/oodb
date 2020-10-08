package lab1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Delivery {
    public DeliveryMethod deliveryMethod;
    public String deliveryAddress;
    public Calendar deliveryDate;
    public Product product;

    public Delivery(DeliveryMethod deliveryMethod, String deliveryAddress, Product product) {
        this.deliveryMethod = deliveryMethod;
        this.deliveryAddress = deliveryAddress;
        this.product = product;
    }

    public double getPrice(Product product, Delivery delivery) {
        double price = product.getPrice();
        if (delivery.getDeliveryMethod() == DeliveryMethod.courier) {
            price = price + 300;
        }
        return price;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Calendar getDeliveryDate() {
        deliveryDate = new GregorianCalendar();
        deliveryDate.add(Calendar.DAY_OF_YEAR, 14);
        return deliveryDate;
    }

}
