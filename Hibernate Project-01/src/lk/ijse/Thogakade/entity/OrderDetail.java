package lk.ijse.Thogakade.entity;

import javax.persistence.*;

@Entity
public class OrderDetail implements SuperEntity{
    @EmbeddedId
    private ForiengKey foriengKey= new ForiengKey();



    @ManyToOne
    @MapsId("orderr")
    @JoinColumn(name = "oid")
    private Orderr orderr;


    @ManyToOne
    @MapsId("item")
    @JoinColumn(name = "Code")
    private Item item;


    private int qty;
    private double price;

    public OrderDetail() {
    }

    public OrderDetail(ForiengKey foriengKey,  Orderr orderr,Item item, int qty, double price) {
        this.foriengKey = foriengKey;
        this.item = item;
        this.orderr = orderr;

        this.qty = qty;
        this.price = price;
    }

    public ForiengKey getForiengKey() {
        return foriengKey;
    }

    public void setForiengKey(ForiengKey foriengKey) {
        this.foriengKey = foriengKey;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Orderr getOrderr() {
        return orderr;
    }

    public void setOrderr(Orderr orderr) {
        this.orderr = orderr;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "foriengKey=" + foriengKey +
                ", orderr=" + orderr +
                ", item=" + item +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
