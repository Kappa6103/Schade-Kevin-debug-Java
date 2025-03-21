package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private final String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> writeToFile) {

        try {
            FileWriter writer = new FileWriter(filePath);
            for (Map.Entry<String, Integer> entry : writeToFile.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("error on printing results to file");
        }
    }
}