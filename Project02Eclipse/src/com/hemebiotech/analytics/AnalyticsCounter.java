package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args) { //error in the main declaration syntax

		//create the hashmap in which the diseases + num of occurrence will be written
		Map<String, Integer> symptomsHashMap = new HashMap<String, Integer>();

		//instantiating ReadSymptomDataFromFile, this load an object with the file path to be read.
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");

		//using the .GetSymptoms() methode of the readSymptomDataFromFile object to load in a string the content read from the file
		List<String> listOfSymptoms = readSymptomDataFromFile.GetSymptoms();

		//iterating through the Strings present in listOfSymptoms and building the unsorted hashMap of names of symptoms and the number of their occurrences.
		for(String item : listOfSymptoms) {
			if (symptomsHashMap.containsKey(item)) { //if the name of a symptom is already present
				symptomsHashMap.put(item, symptomsHashMap.get(item) + 1); //increase its count to n + 1
			} else {
				symptomsHashMap.put(item, 1); //if name of a symptom is not present, adding it + 1
			}
		}

		//creating a TreeMap to sort the hashMap containing the key/value name/occurrence in alphabetical order
		TreeMap<String, Integer> sortedHashMap = new TreeMap<String, Integer>(symptomsHashMap);



//		for (Map.Entry<String, Integer> entry : symptomsHashMap.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}

		//

		//instantiating WriteSymptomDateToFile, this load an object with the file path to be written
		WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile("result.out");

		//using the .writeSymptoms method of the writeSymptomDataToFile object to print formatted string of the curated hasMap onto a file
		writeSymptomDataToFile.writeSymptoms(sortedHashMap);



	}
}
