package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CsvStudents implements Students {
    private List<Student> students = new ArrayList<>();
    private static CsvStudents csvStudents = null;

    public CsvStudents(){}

    public List<Student> getStudents() {
        return students;
    }

    /** TODO 3 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Students getInstance() {
        if(csvStudents == null){
            csvStudents = new CsvStudents();
        }
        return csvStudents;
    }

    // TODO 7 : student.csv 파일에서 데이터를 읽어 클래스 멤버 변수에 추가하는 로직을 구현하세요.
    // 데이터를 적재하고 읽기 위해서, 적절한 자료구조를 사용하세요.
    @Override
    public void load() {
        File csv = new File("C:\\Users\\dorin\\OneDrive\\바탕 화면\\springframework-project1\\src\\main\\resources\\data\\student.csv");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(",");
                Student student = new Student(Integer.valueOf(lineArr[0]),lineArr[1]);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Collection<Student> findAll() {
        return students;
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
        int number = 0;
        for(Score sc : scores){
            students.get(number).setScore(sc);
            number++;
        }
    }
}
