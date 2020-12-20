package com.service;

import com.beans.Course;
import com.beans.Score;
import com.beans.Student;

import java.util.List;
import java.util.Map;

public interface IScoreService {
    int addScore(Score score);

    int removeScore(Map map);

    int modifyScore(Score score);

    List<Score> findScore(String student_id);

    List<Student> findStudentByClassName(String s);

    List<Course> findAllCourse();

    Student findStudentById(String id);

    Score findScoreBySandC(String student_id, String course_id);

    Course findAllCourseById(String course_id);

}
