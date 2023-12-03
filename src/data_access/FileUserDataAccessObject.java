package data_access;

import use_case.search.calc_score.CalcScoreDataAccessInterface;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUserDataAccessObject implements CalcScoreDataAccessInterface {

    private final String filePath = "src/esg_scores.csv";
    private final Map<String, Float> productScores = new HashMap<>();

    public FileUserDataAccessObject() {}

    @Override
    public float get_score_from_file(String company, String brand) {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String entityName = columns[0].replaceAll("\"", ""); // Remove quotes if present

                if (entityName.toLowerCase().contains(company.toLowerCase())) {
                    if (columns.length > 6) {
                        columns[0] += columns[1];
                        for (int i = 1; i < 6; i++) {
                            columns[i] = columns[i+1];
                        }
                    }
                    float esg_score = Float.parseFloat(columns[5].trim());
                    br.close();
                    add_to_productScores(brand, esg_score);
                    return (esg_score);
                }
            }
            br.close();
            add_to_productScores(company, -1);
            return -1;
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file: " + e.getMessage());
        }
        return -1;
    }
    @Override
    public void add_to_productScores (String company, float score) {
        productScores.put(company, score);
    }
}

