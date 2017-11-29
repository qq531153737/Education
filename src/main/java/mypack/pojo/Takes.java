package mypack.pojo;

import java.io.Serializable;

public class Takes implements Serializable {
    private long stuId;
    private long couId;
    private Integer grade;

    public Takes() {
    }

    public Takes(long stuId, long couId, Integer grade) {

        this.stuId = stuId;
        this.couId = couId;
        this.grade = grade;
    }

    public long getStuId() {

        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public long getCouId() {
        return couId;
    }

    public void setCouId(long couId) {
        this.couId = couId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
