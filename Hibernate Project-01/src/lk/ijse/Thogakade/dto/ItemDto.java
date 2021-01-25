package lk.ijse.Thogakade.dto;

public class ItemDto {
    String code;
    String description;
    double unitPrice;
    int qty;

    public ItemDto() {
    }

    public ItemDto(String Id, String description, double unitPrice, int qty) {
        this.code = Id;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public ItemDto(String code, int newQty) {
        this.code=code;
        this.qty=newQty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String Id) {
        this.code = Id;
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

    @Override
    public String toString() {
        return "ItemDto{" +
                "Id='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }
}
