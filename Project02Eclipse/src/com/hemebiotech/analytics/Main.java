package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Main method.
 * This is where the program starts its execution.
 */
public class Main {

    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

        ISymptomWriter writer = new WriteSymptomDataToFile("results.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> listOfSymptoms = analyticsCounter.getReader().GetSymptoms();

        Map<String, Integer> symptomsHashMap = analyticsCounter.countSymptoms(listOfSymptoms);

        TreeMap<String, Integer> sortedHashMap = analyticsCounter.sortSymptoms(symptomsHashMap);

        analyticsCounter.getWriter().writeSymptoms(sortedHashMap);

    }

}
