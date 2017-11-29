package mypack.pojo;

import java.io.Serializable;
import java.sql.Time;

public class TimeSlot implements Serializable {
    private int id;
    private Time startTime;
    private Time endTime;
    private String times;

    public TimeSlot() {
    }

    public TimeSlot(int id, Time startTime, Time endTime, String times) {

        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.times = times;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
