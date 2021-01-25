package lk.ijse.Thogakade.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ForiengKey implements Serializable {
    private String oid;
    private String code;

    public ForiengKey() {
    }

    public ForiengKey(String orId, String code) {
        this.oid = orId;
        this.code = code;
    }

    public String getOrId() {
        return oid;
    }

    public void setOrId(String orId) {
        this.oid = orId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForiengKey that = (ForiengKey) o;
        return Objects.equals(oid, that.oid) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, code);
    }
}
