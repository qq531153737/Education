package mypack.service;

public interface NotificationService {
    String getNotification(Long id, int flag);
    boolean delNotification(long id);
    boolean readedNotification(long id);
    boolean readedNotificationPro(long id);
    boolean noticeStudent(int admID, long stuID, String noticeContent);
    boolean noticeProfessor(int admID, long proID, String noticeContent);
    boolean noticeClazz(int admID, long claID, String noticeContent);
}
