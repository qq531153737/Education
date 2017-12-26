package mypack.service;

public interface NotificationService {
    String getNotification(Long id, int flag);
    boolean delNotification(long id,long myId);
    boolean delNotificationPro(long id,long myId);
    boolean readedNotification(long id,long myId);
    boolean readedNotificationPro(long id,long myId);
    boolean noticeStudent(int admID, long stuID, String noticeContent);
    boolean noticeProfessor(int admID, long proID, String noticeContent);
    boolean noticeClazz(int admID, long claID, String noticeContent);
}
