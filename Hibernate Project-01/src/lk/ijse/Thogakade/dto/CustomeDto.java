package lk.ijse.Thogakade.dto;

public class CustomeDto {
    private String code;
    private int qty;
    private double totPrice;

    public CustomeDto() {
    }

    public CustomeDto(String code, int qty, double totPrice) {
        this.code = code;
        this.qty = qty;
        this.totPrice = totPrice;
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

    public double getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(double totPrice) {
        this.totPrice = totPrice;
    }

    @Override
    public String toString() {
        return "CustomeDto{" +
                "code='" + code + '\'' +
                ", qty=" + qty +
                ", totPrice=" + totPrice +
                '}';
    }
}
