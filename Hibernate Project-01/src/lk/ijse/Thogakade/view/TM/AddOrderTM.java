package lk.ijse.Thogakade.view.TM;

public class AddOrderTM {
    private String code;
    private double price;
    private int qty;
    private double tot;

    public AddOrderTM() {
    }

    public AddOrderTM(String code, double price, int qty, double tot) {
        this.code = code;
        this.price = price;
        this.qty = qty;
        this.tot = tot;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

    @Override
    public String toString() {
        return "AddOrderTM{" +
                "code='" + code + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", tot=" + tot +
                '}';
    }
}
