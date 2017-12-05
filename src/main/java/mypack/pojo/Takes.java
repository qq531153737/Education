package mypack.pojo;

import java.io.Serializable;

public class Takes implements Serializable {
    private long stuId;
    private long couId;
    private double grade;
    private int ranking;
    private int PerformancePoint;

    public Takes() {
    }

    public Takes(long stuId, long couId, double grade, int ranking, int performancePoint) {
        this.stuId = stuId;
        this.couId = couId;
        this.grade = grade;
        this.ranking = ranking;
        PerformancePoint = performancePoint;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getPerformancePoint() {
        return PerformancePoint;
    }

    public void setPerformancePoint(int performancePoint) {
        PerformancePoint = performancePoint;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
