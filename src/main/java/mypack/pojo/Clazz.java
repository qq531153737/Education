package mypack.pojo;

import java.io.Serializable;

public class Clazz implements Serializable {
    private long id;
    private String name;
    private int quantity;
    private int majID;

    public Clazz() {
    }

    public Clazz(long id, String name, int quantity, int majID) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.majID = majID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMajID() {
        return majID;
    }

    public void setMajID(int majID) {
        this.majID = majID;
    }
}
