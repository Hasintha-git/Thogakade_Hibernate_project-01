package lk.ijse.Thogakade.dto;

public class OrderDto {
    private String oid;
    private double pay;
    private double tot;

    public OrderDto() {
    }

    public OrderDto(String id, double pay, double tot) {
        this.oid = id;

        this.pay = pay;
        this.tot = tot;
    }

    public String getId() {
        return oid;
    }

    public void setId(String id) {
        this.oid = id;
    }



    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id='" + oid + '\'' +
                ", pay=" + pay +
                ", tot=" + tot +
                '}';
    }
}
