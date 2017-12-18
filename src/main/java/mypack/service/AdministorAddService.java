package mypack.service;

import java.sql.Date;

public interface AdministorAddService {
    boolean addStudent(String name, int majID, long claID, int year);
    boolean addProfessor(String name, int depID, int year);
    boolean addClazz(String name, int majID, int year, long proID);
}