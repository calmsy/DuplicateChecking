package com.service;

import com.beans.Score;
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
}
