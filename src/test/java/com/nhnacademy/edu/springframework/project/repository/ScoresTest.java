package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoresTest {

    @Test
    void load() {
        Scores scores = new CsvScores();
        scores.load();
        assertEquals(1,scores.findAll().get(0).getStudentSeq());
        assertEquals(30,scores.findAll().get(0).getScore());
    }


    @Test
    void findAll() {
        Scores scores = new CsvScores();
        scores.load();
        assertEquals("Score{studentSeq=1, score=30}",scores.findAll().get(0).toString());
    }
}