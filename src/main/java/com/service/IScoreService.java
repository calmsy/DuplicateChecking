package com.service;

import com.beans.Score;

import java.util.List;
import java.util.Map;

public interface IScoreService {
    int addScore(Score score);

    int removeScore(Map map);

    int modifyScore(Score score);

    List<Score> findScore(String student_id);
}
