package mypack.Response;

import mypack.pojo.Notice;

import java.sql.Array;
import java.sql.Date;

public class NoticeInfo extends Notice{
    private String author;
    private int readed;
    public NoticeInfo(String author) {
        this.author = author;
    }

    public NoticeInfo(long id, String noticeContent, Date time, int admId, String author,int readed) {
        super(id, noticeContent, time, admId);
        this.author = author;
        this.readed=readed;
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        String result="id:"+getId()+",noticeContent:"+getNoticeContent()+",time:"+getTime()+",readed:"+
                getReaded()+",author:"+getAuthor();
        return result;
    }
}
