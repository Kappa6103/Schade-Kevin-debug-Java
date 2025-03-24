/**
 *Implements the tooling used in the Main fonction
 *like the counting of the symptoms and the sorting of lists
 */

package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	ISymptomReader reader;
	ISymptomWriter writer;
	final int ADD_ONE = 1;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 *Count the number of symptons in the list
	 *
	 * @param listOfSymptoms is a List of Strings that we want to count
	 * @return the method returns a hashmap with Key/Value String/Integer of the symptoms and their counts
	 */
	public Map<String, Integer> countSymptoms(List<String> listOfSymptoms) {
		//create the hashmap in which the diseases + num of occurrence will be written
		Map<String, Integer> symptomsHashMap = new HashMap<>();
		//iterating through the Strings present in listOfSymptoms and building the unsorted hashMap of names of symptoms and the number of their occurrences.
		for(String item : listOfSymptoms) {
			if (symptomsHashMap.containsKey(item)) { //if the name of a symptom is already present
				symptomsHashMap.put(item, symptomsHashMap.get(item) + ADD_ONE); //increase its count to n + 1
			} else {
				symptomsHashMap.put(item, ADD_ONE); //if name of a symptom is not present, adding it + 1
			}
		}
		return symptomsHashMap;
	}

	/**
	 * Sort the hashMap in alphabetical order
	 *
	 *
	 * @param inputHasMap, names of symptoms and their occurrence.
	 * @return a TreeMap, used for the sorting process
	 */
	public TreeMap<String, Integer> sortSymptoms(Map<String, Integer> inputHasMap) {
        return new TreeMap<>(inputHasMap);
	}

}