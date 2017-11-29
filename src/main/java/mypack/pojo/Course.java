package mypack.pojo;

import java.io.Serializable;

public class Course implements Serializable {
    private long id;
    private String name;
    private String type;
    private String classroom;
    private int depID;
    private int timeSlotID;
    private int proID;
    private int admID;

    public Course() {
    }

    public Course(long id, String name, String type, String classroom, int depID, int timeSlotID, int proID, int admID) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.classroom = classroom;
        this.depID = depID;
        this.timeSlotID = timeSlotID;
        this.proID = proID;
        this.admID = admID;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public int getTimeSlotID() {
        return timeSlotID;
    }

    public void setTimeSlotID(int timeSlotID) {
        this.timeSlotID = timeSlotID;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public int getAdmID() {
        return admID;
    }

    public void setAdmID(int admID) {
        this.admID = admID;
    }
}