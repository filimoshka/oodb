package lab4.model;

public class Delivery {
    public String deliveryAddress;
    public String deliveryTime;
    public DeliveryMethod deliveryMethod;

    public Delivery(String deliveryAddress, DeliveryMethod deliveryMethod) {
        this.deliveryAddress = deliveryAddress;
        this.deliveryMethod = deliveryMethod;
        this.deliveryTime = "7-14 days";
    }

    public Delivery() {

    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    @Override
    public String toString() {
        return deliveryAddress + ", " + deliveryTime + ", " + deliveryMethod;
    }

}
