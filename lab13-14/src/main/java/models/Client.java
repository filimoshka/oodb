package models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Client extends Person{

    @Column
    private int discount;

    @OneToMany(mappedBy = "clientid", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList;

    public Client() {}

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}
