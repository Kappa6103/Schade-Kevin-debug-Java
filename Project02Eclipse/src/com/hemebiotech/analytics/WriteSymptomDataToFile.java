package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> writeToFile) {
        if (writeToFile != null) {
            try {
                FileWriter writer = new FileWriter("resultOut.txt");
                writeToFile.forEach((item, quantity) -> writer.write(item + ": " + quantity);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
