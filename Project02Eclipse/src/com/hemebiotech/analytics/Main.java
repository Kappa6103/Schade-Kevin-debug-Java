package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("results.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        //using the .GetSymptoms() methode of the readSymptomDataFromFile object to load in a string the content read from the file
        List<String> listOfSymptoms = analyticsCounter.reader.GetSymptoms();

        //create the hashmap in which the diseases + num of occurrence will be written
        Map<String, Integer> symptomsHashMap = analyticsCounter.countSymptoms(listOfSymptoms);

		//creating a TreeMap to sort the hashMap containing the key/value name/occurrence in alphabetical order
        TreeMap<String, Integer> sortedHashMap = analyticsCounter.sortSymptoms(symptomsHashMap);

        //using the .writeSymptoms method of the writeSymptomDataToFile object to print formatted string of the curated hasMap onto a file
        analyticsCounter.writer.writeSymptoms(sortedHashMap);

    }

}
