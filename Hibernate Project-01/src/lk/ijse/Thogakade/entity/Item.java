package lk.ijse.Thogakade.entity;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Item implements SuperEntity {
    @Id
    private String Code;
    private String description;
    private double unitPrice;
    private int qty;
    @OneToMany(mappedBy = "item")
    private List<OrderDetail> orderDetails;

    public Item() {
    }

    public Item(String Id, String description, double unitPrice, int qty) {
        this.Code = Id;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public Item(String id, String description, double unitPrice, int qty, List<OrderDetail> orderDetails) {
        Code = id;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.orderDetails = orderDetails;
    }



    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Code='" + Code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
