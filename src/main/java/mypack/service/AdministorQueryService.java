package mypack.service;

import mypack.pojo.Clazz;
import mypack.pojo.Professor;
import mypack.pojo.Student;

import java.util.ArrayList;

public interface AdministorQueryService {
    String queryStudent(long claID);
    String queryProfessor(String depName);
    String queryClazz(int year, String depName);
}
