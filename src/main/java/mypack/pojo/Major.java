package mypack.pojo;

import java.io.Serializable;

public class Major implements Serializable {
    private int id;
    private String name;
    private int depID;
    private int newStudent;
    private int newClazz;

    public Major() {
    }

    public Major(int id, String name, int depID, int newStudent, int newClazz) {
        this.id = id;
        this.name = name;
        this.depID = depID;
        this.newStudent = newStudent;
        this.newClazz = newClazz;
    }

    public int getNewClazz() {
        return newClazz;
    }

    public void setNewClazz(int newClazz) {
        this.newClazz = newClazz;
    }

    public int getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(int newStudent) {
        this.newStudent = newStudent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }
}
