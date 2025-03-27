package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write the output of the program to a file
 */

public interface ISymptomWriter {
    /**
     * Takes a Map of String/Integer and write them to a file
     *
     * @param writeToFile the map to be written on file
     */
    void writeSymptoms (Map<String, Integer> writeToFile);
}