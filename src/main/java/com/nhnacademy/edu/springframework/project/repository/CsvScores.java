package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvScores implements Scores {
    private List<Score> score = new ArrayList<>();
    private List<Integer> seq = new ArrayList<>();
    private static CsvScores csvScores = null;
    public CsvScores(){}

    public List<Score> getScore() {
        return score;
    }

    /** TODO 2 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Scores getInstance() {
        if(csvScores == null){
            csvScores = new CsvScores();
        }
        return csvScores;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        File csv = new File("C:\\Users\\dorin\\OneDrive\\바탕 화면\\springframework-project1\\src\\main\\resources\\data\\score.csv");
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(",");
                Score scores = new Score(Integer.valueOf(lineArr[0]),Integer.valueOf(lineArr[1]));
                score.add(scores);
                seq.add(Integer.valueOf(lineArr[0]));
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
    public List<Score> findAll() {

        return score;
    }
}
