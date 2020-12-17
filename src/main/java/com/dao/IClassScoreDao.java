package com.dao;

import com.beans.ClassScore;
import com.beans.Classes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IClassScoreDao {
    @Select("select (select count(*) from student where class_id=#{class_id}) number,(select class_name from classes where class_id=#{class_id}) class_name,sum(usual_score) usual_score,sum(final_score) final_score,sum(total_score) total_score from score where student_id in (select student_id from student where class_id=#{class_id})")
    ClassScore selectData(String class_id);

    @Select("select * from classes")
    List<Classes> selectAllClass();
}