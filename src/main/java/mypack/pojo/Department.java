package mypack.pojo;

import java.io.Serializable;

public class Department implements Serializable {
    private int id;
    private int newProfessor;
    private int newCourse;
    private String name;
    private String building;
    private String contactInformation;

    public Department() {

    }

    public Department(int id, int newProfessor, int newCourse, String name, String building, String contactInformation) {
        this.id = id;
        this.newProfessor = newProfessor;
        this.newCourse = newCourse;
        this.name = name;
        this.building = building;
        this.contactInformation = contactInformation;
    }

    public int getNewCourse() {
        return newCourse;
    }

    public void setNewCourse(int newCourse) {
        this.newCourse = newCourse;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewProfessor() {
        return newProfessor;
    }

    public void setNewProfessor(int newProfessor) {
        this.newProfessor = newProfessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
