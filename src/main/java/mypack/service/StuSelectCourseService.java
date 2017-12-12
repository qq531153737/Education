package mypack.service;

import mypack.Response.StudentDepartResponse;

public interface StuSelectCourseService {
    StudentDepartResponse getStudentDepart(long id);
}
