package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;
import java.util.List;

public class Student {
    private final int seq;
    private final String name;
    private int score;

    public Student(int seq, String name) {
        this.seq = seq;
        this.name = name;
    }

    public void setScore(Score score) {
        this.score = score.getScore();
    }

    public int getScore() {
        return score;
    }

    public boolean isFail(){
        if(this.score >60){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return "Student{" +
                "seq=" + seq +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}'+ '\n';
    }
}
