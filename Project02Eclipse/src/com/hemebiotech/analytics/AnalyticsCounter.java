package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	ISymptomReader reader;
	ISymptomWriter writer;


	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}


	public static void main(String[] args) {

		AnalyticsCounter objetAnalytic = new AnalyticsCounter(new ReadSymptomDataFromFile("symptoms.txt"),new WriteSymptomDataToFile("result.out"));

		//using the .GetSymptoms() methode of the readSymptomDataFromFile object to load in a string the content read from the file
		//List<String> listOfSymptoms = readSymptomDataFromFile.GetSymptoms();
		List<String> listOfSymptoms = objetAnalytic.reader.GetSymptoms();

		//create the hashmap in which the diseases + num of occurrence will be written
		//Map<String, Integer> symptomsHashMap = new HashMap<String, Integer>();
		Map<String, Integer> symptomsHashMap = countSymptoms(listOfSymptoms);

//		//creating a TreeMap to sort the hashMap containing the key/value name/occurrence in alphabetical order
//		TreeMap<String, Integer> sortedHashMap = new TreeMap<String, Integer>(symptomsHashMap);
		TreeMap<String, Integer> sortedHashMap = sortSymptoms(symptomsHashMap);

		//using the .writeSymptoms method of the writeSymptomDataToFile object to print formatted string of the curated hasMap onto a file
		//writeSymptomDataToFile.writeSymptoms(sortedHashMap);
		objetAnalytic.writer.writeSymptoms(sortedHashMap);



	}
	public static TreeMap<String, Integer> sortSymptoms(Map<String, Integer> inputHasMap) {
        return new TreeMap<>(inputHasMap);

	}


	public static Map<String, Integer> countSymptoms(List<String> listOfSymptoms) {
		//create the hashmap in which the diseases + num of occurrence will be written
		Map<String, Integer> symptomsHashMap = new HashMap<>();
		//iterating through the Strings present in listOfSymptoms and building the unsorted hashMap of names of symptoms and the number of their occurrences.
		for(String item : listOfSymptoms) {
			if (symptomsHashMap.containsKey(item)) { //if the name of a symptom is already present
				symptomsHashMap.put(item, symptomsHashMap.get(item) + 1); //increase its count to n + 1
			} else {
				symptomsHashMap.put(item, 1); //if name of a symptom is not present, adding it + 1
			}
		}
		return symptomsHashMap;
	}


}
