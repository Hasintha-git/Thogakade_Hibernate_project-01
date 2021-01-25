package lk.ijse.Thogakade.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Customer implements SuperEntity{
    @Id
    private String id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Orderr> order;


    public Customer() {
    }

    public Customer(String id, String name, String address, List<Orderr> order) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.order = order;
    }

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public List<Orderr> getOrder() {
        return order;
    }

    public void setOrder(List<Orderr> order) {
        this.order = order;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", order=" + order +
                '}';
    }
}
