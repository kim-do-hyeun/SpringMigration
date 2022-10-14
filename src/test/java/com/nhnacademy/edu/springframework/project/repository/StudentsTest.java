package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import com.nhnacademy.edu.springframework.project.service.Student;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {
    Students csvStudent = new CsvStudents();

    @Test
    void load() {
        csvStudent.load();
        Student st = csvStudent.findAll().iterator().next();
        assertEquals(1,st.getSeq());
        assertEquals("A",st.getName());

    }

    @Test
    void findAll() {
        csvStudent.load();
        Student st = csvStudent.findAll().iterator().next();
        assertEquals("Student{seq=1, name='A', score=0}\n",st.toString());
    }

    @Test
    void merge() {
        Scores scores = CsvScores.getInstance();
        scores.load();

        csvStudent.load();
        csvStudent.merge(scores.findAll());

        Student st = csvStudent.findAll().iterator().next();
        assertEquals(30,st.getScore());




    }
}