package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * creates an object to write a Map<String, Integer> to a text file.
 * try / catch block implemented to handle IO error
 */

public class WriteSymptomDataToFile implements ISymptomWriter{

    private final String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * write the given Map Symptoms/occurrence to a file
     * @param writeToFile is the path of the file to write to or to create
     */
    @Override
    public void writeSymptoms(Map<String, Integer> writeToFile) {

        try {
            FileWriter writer = new FileWriter(filePath);

            for (Map.Entry<String, Integer> entry : writeToFile.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("error on printing results to file");
        }
    }
}