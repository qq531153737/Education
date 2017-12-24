package mypack.pojo;

import java.io.Serializable;

public class NoticePro implements Serializable {
    private long notID;
    private long proID;
    private int readed;

    public NoticePro() {
    }

    public NoticePro(long notID, long proID, int readed) {
        this.notID = notID;
        this.proID = proID;
        this.readed = readed;
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    public long getNotID() {
        return notID;
    }

    public void setNotID(long notID) {
        this.notID = notID;
    }

    public long getProID() {
        return proID;
    }

    public void setProID(long proID) {
        this.proID = proID;
    }
}
