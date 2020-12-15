package com;

import com.beans.ClassScore;
import com.beans.Score;
import com.service.ClassScoreServiceImpl;
import com.service.ScoreServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    private ScoreServiceImpl scoreService;
    private ClassScoreServiceImpl classScoreService;
    @Before
    public void before(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        scoreService = (ScoreServiceImpl) ac.getBean("scoreService");
        classScoreService = (ClassScoreServiceImpl) ac.getBean("classScoreService");
    }

    @Test
    public void test1(){
        Score score = new Score("184804028","2",80,90,87);
        System.out.println(scoreService.addScore(score));
    }
    @Test
    public void test2(){
        Map map = new HashMap<>();
        map.put("student_id","184804028");
        map.put("course_id","1");
        System.out.println(scoreService.removeScore(map));
    }
    @Test
    public void test3(){
        Score score = new Score("184804028","1",100,100,100);
        System.out.println(scoreService.modifyScore(score));
    }
    @Test
    public void test4(){
        List<Score> scores = scoreService.findScore("184804028");
        for(Score score:scores){
            System.out.println(score);
        }
    }
    @Test
    public void test5(){
        ClassScore classScore = classScoreService.findClassScore("3");
        System.out.println(classScore);
    }
}
