package com.service;

import com.beans.Course;
import com.beans.Score;
import com.beans.Student;
import com.dao.IScoreDao;

import java.util.List;
import java.util.Map;

public class ScoreServiceImpl implements IScoreService {
    private IScoreDao scoreDao;
    public void setScoreDao(IScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

    /*
    * 添加个人成绩
    * 需写入score所有属性
    * */
    @Override
    public int addScore(Score score) {
        return scoreDao.insertScore(score);
    }

    /*
    * 删除个人成绩
    * 在map中保存student_id和course_id
    * */
    @Override
    public int removeScore(Map map) {
        return scoreDao.deleteScore(map);
    }

    /*
    * 修改个人成绩
    * 需写入score所有属性
    * */
    @Override
    public int modifyScore(Score score) {
        return scoreDao.updateScore(score);
    }

    /*
    * 按student_id查询该学生所有成绩
    * 查询结果包含student_name,course_name
    * */
    @Override
    public List<Score> findScore(String student_id) {
        return scoreDao.selectScore(student_id);
    }

    @Override
    public List<Student> findStudentByClassName(String s) {

        List<Student> students = scoreDao.selectStudentByClassName(s);

        return students;
    }

    @Override
    public List<Course> findAllCourse() {

        List<Course> courses = scoreDao.selectAllCourse();
        return courses;
    }

    @Override
    public Student findStudentById(String id) {
        Student student = scoreDao.selectStudentById(id);
        return student;
    }

    @Override
    public Score findScoreBySandC(String student_id, String course_id) {
        Score score = scoreDao.selectScoreBySandC(student_id,course_id);
        return score;
    }

    @Override
    public Course findAllCourseById(String course_id) {
        Course course = scoreDao.selectCourseById(course_id);
        return course;
    }

}
