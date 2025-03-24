package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	private static int diseaseNotAccountedFor = 0; //it's to know if we have read all diseases from the file

	public static void main(String[] args) throws Exception { //error in the main declaration syntax

		//reading the text file
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();


		while (line != null) {
			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			} else {
				diseaseNotAccountedFor++;
			}
			line = reader.readLine();
		}
		//closing file's reading method
		reader.close();
		System.out.println("Headache: " + headacheCount);
		System.out.println("Rash: " + rashCount);
		System.out.println("Pupils: " + pupilCount);
		System.out.println("Not accounted for: " + diseaseNotAccountedFor);
		
		// next generate output
		FileWriter writer = new FileWriter ("resultOut.txt");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
