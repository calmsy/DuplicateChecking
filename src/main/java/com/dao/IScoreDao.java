package com.dao;

import com.beans.Score;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IScoreDao {
    @Insert("insert into score values(#{student_id},#{course_id},#{usual_score},#{final_score},#{total_score})")
    int insertScore(Score score);

    @Delete("delete from score where student_id=#{student_id} and course_id=#{course_id}")
    int deleteScore(Map map);

    @Update("update score set usual_score=#{usual_score},final_score=#{final_score},total_score=#{total_score} where student_id=#{student_id} and course_id=#{course_id}")
    int updateScore(Score score);

    @Select("select student_id,course_id,usual_score,final_score,total_score,course_name,student_name from score join student using(student_id) join course using(course_id) where student_id=#{id}")
    List<Score> selectScore(String student_id);
}
