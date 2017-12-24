package mypack.pojo;

import java.io.Serializable;

public class NoticeStu implements Serializable {
    private long notID;
    private long stuID;
    private int readed;
    public NoticeStu() {
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    public NoticeStu(long notID, long stuID, int readed) {
        this.notID = notID;
        this.stuID = stuID;
        this.readed = readed;
    }

    public long getNotID() {

        return notID;
    }

    public void setNotID(long notID) {
        this.notID = notID;
    }

    public long getStuID() {
        return stuID;
    }

    public void setStuID(long stuID) {
        this.stuID = stuID;
    }
}
