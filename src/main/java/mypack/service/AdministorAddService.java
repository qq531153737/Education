package mypack.service;

import java.sql.Date;

public interface AdministorAddService {
    boolean addStudent(String name, int majID, long claID, int year);
    boolean addProfessor(String name, int depID, int year);
    boolean addClazz(String name, int majID, int year, long proID);
    boolean addCourse(String name, int type, int credict, int totalTime, int learnTerm, String learnYear, String classroom, int depID, int timeSlotID, long proID, int admID, int quantity);
    boolean addStudentOfCourse(long stuID, long couID);
    boolean addClazzOfCourse(long claID, long couID);
}