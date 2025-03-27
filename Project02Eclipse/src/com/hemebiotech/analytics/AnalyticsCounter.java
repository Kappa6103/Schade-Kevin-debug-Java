package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *Implements the tooling used in the Main method.
 *like the <b>counting</b> of the symptoms and the <b>sorting</b> of lists
 */

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
	final int ADD_ONE = 1;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public ISymptomReader getReader() {
		return reader;
	}

	public ISymptomWriter getWriter() {
		return writer;
	}


	/**
	 *Count the number of symptoms in the list
	 *
	 * @param listOfSymptoms is a List of Strings that we want to count
	 * @return the method returns a hashmap with Key/Value String/Integer of the symptoms and their counts
	 */
	public Map<String, Integer> countSymptoms(List<String> listOfSymptoms) {

		Map<String, Integer> symptomsHashMap = new HashMap<>();

		for(String item : listOfSymptoms) {
			if (symptomsHashMap.containsKey(item)) {
				symptomsHashMap.put(item, symptomsHashMap.get(item) + ADD_ONE);
			} else {
				symptomsHashMap.put(item, ADD_ONE);
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