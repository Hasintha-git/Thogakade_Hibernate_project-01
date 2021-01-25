package lk.ijse.Thogakade.dto;

public class OrderDetailDto {

    private String oid;
    private String code;

    private int qty;
    private double price;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String id, String code, int qty, double price) {
        this.oid = id;
        this.code = code;

        this.qty = qty;
        this.price = price;
    }

    public String getId() {
        return oid;
    }

    public void setId(String id) {
        this.oid = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return "OrderDetailDto{" +
                "id='" + oid + '\'' +
                ", code='" + code + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
