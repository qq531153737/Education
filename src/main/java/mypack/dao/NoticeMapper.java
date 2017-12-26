package mypack.dao;

import mypack.Response.NoticeInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.util.ArrayList;

public interface NoticeMapper {

    @Select("select notice.*,administor.name as author,noticepro.readed as readed\n" +
            "from noticepro,notice,administor\n" +
            "where noticepro.notID=notice.id and notice.admID=administor.id and noticepro.proID=#{id}")
    ArrayList<NoticeInfo> getProNotificationList(@Param("id")Long id);

    @Select("select notice.*,administor.name as author,noticestu.readed as readed\n"+
            "from noticestu,notice,administor\n"+
            "where noticestu.notID=notice.id and notice.admID=administor.id and noticestu.stuID=#{id}")
    ArrayList<NoticeInfo> getStuNotificationList(@Param("id")Long id);

    @Select("update noticestu set readed=1 where notID=#{id} and stuID=#{myId}")
    void readNotification(@Param("id")long id,@Param("myId")long myId);

    @Select("update noticepro set readed=1 where notID=#{id} and proID=#{myId}")
    void readNotificationPro(@Param("id")long id,@Param("myId")long myId);


    @Select("delete from noticestu where notID=#{id} and stuID=#{myId}")
    void deleNotification(@Param("id")long id,@Param("myId")long myId);

    @Select("delete from noticepro where notID=#{id} and proID=#{myId}")
    void deleNotificationPro(@Param("id")long id,@Param("myId")long myId);

    @Insert("insert into notice(id, time, noticeContent, admID) values(#{id},#{time},#{noticeContent},#{admID})")
    boolean publicNotice(@Param("id") long id, @Param("noticeContent") String noticeContent, @Param("admID") int admID, @Param("time") Date time);

    @Insert("insert into noticestu(notID, stuID, readed) values(#{notID},#{stuID},0)")
    boolean noticeStudent(@Param("notID")long notID, @Param("stuID")long stuID);

    @Insert("insert into noticepro(notID, proID, readed) values(#{notID},#{proID},0)")
    boolean noticeProfessor(@Param("notID")long notID, @Param("proID")long proID);

    @Select("select admID from notice where (select(id div 10000)) = #{date}")
    ArrayList<Integer> getAmountOfNotice(@Param("date")long date);
}
