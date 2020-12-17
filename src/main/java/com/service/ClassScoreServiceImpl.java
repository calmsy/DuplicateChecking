package com.service;

import com.beans.Classes;
import com.beans.ClassScore;
import com.dao.IClassScoreDao;

import java.util.List;

public class ClassScoreServiceImpl implements IClassScoreService {
    private IClassScoreDao classScoreDao;

    public void setClassScoreDao(IClassScoreDao classScoreDao) {
        this.classScoreDao = classScoreDao;
    }

    /*
    * 输入class_id查询该班级总成绩及个人总成绩的平均值
    * 查询结果包含班级名class_name
    * */
    @Override
    public ClassScore findClassScore(String class_id) {
        ClassScore classScore;
        classScore = classScoreDao.selectData(class_id);
        classScore.setClass_id(class_id);
        int number = classScore.getNumber();
        classScore.setAvg_usual_score(classScore.getUsual_score()/number);
        classScore.setAvg_final_score(classScore.getFinal_score()/number);
        classScore.setAvg_total_score(classScore.getTotal_score()/number);
        return classScore;
    }

    @Override
    public List<Classes> findAllClass() {
        List<Classes> classes;
        classes = classScoreDao.selectAllClass();
        return classes;
    }
}
