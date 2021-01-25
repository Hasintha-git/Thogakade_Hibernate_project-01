package lk.ijse.Thogakade.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Orderr implements SuperEntity {
    @Id
    private String oid;
    private double pay;
    private double total;

    @OneToMany(mappedBy = "orderr" ,cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "CustID")
    private Customer customer;
    public Orderr() {
    }

    public Orderr(String id, double pay, double total, List<OrderDetail> orderDetails, Customer customer) {
        oid = id;
        this.pay = pay;
        this.total = total;
        this.orderDetails = orderDetails;
        this.customer = customer;
    }

    public String getid() {
        return oid;
    }

    public void setid(String orid) {
        oid = orid;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orderr{" +
                "Orid='" + oid + '\'' +
                ", pay=" + pay +
                ", total=" + total +
                ", orderDetails=" + orderDetails +
                ", customer=" + customer +
                '}';
    }
}
