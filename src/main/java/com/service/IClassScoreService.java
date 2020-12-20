package com.service;

import com.beans.ClassScore;
import com.beans.Classes;

import java.util.List;

public interface IClassScoreService {
    ClassScore findClassScore(String class_id);

    List<Classes> findAllClass();
}