package mypack.service;

public interface AdministorDeleteService {
    boolean deleteStudent(long id);
    boolean deleteProfessor(long id);
    boolean deleteClazz(long id);
    boolean deleteCourse(long id);
    boolean deleteStudentOfCourse(long stuID, long couID);
    boolean deleteStudentOfCourse2(long stuID, long couID);
    boolean deleteClazzOfCourse(String claName, long couID);
}
