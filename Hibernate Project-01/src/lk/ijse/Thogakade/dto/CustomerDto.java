package lk.ijse.Thogakade.dto;

public class CustomerDto {
    private String id;
    private String name;
    private String address;

    public CustomerDto(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public CustomerDto(String id) {
        this.id = id;
    }

    public CustomerDto() {
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

    public String toString() {
        return "CustomerDto{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", address='" + this.address + '\'' + '}';
    }
}
