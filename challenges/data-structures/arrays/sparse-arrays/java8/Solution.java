import java.io.*;
import java.util.*;

/**
* @author Allen Jiang
* Solution class for HackerRank
*/

public class Solution {

	/*
	Problem:
	You are given a number N, followed by N strings on separate lines. hint: use in.nextLine()
	Then a number Q, followed by Q queries on separate lines.
	For each query, find the number of occurrences in the strings.
	Only exact, full matches need be counted.
	*/

	// Read input scanner from system.in
	private static Scanner in = new Scanner(System.in);
	// Storage for the list of strings.
	private static HashMap<String, Integer> data;

	public static void main(String[] args) {
		// Read the Strings
        int stringCount = in.nextInt();
        in.nextLine(); // chuck 1 line buffer
        data = new HashMap<String, Integer>();
        for (int i = 0; i < stringCount; i++) {
        	// Read the next piece of data
        	String datum = in.nextLine();
        	// If the String is not yet stored
        	if (data.get(datum) == null) {
        		// Store it as a new key with the entry 0 instances (It will be 1 in next step)
        		data.put(datum, 0);
        	}
        	// Whether first time or not, increase the entry by 1
        	data.put(datum, data.get(datum) + 1);
        }
        // Read and search queries
        int queryCount = in.nextInt();
        in.nextLine(); // chuck 1 line buffer
        for (int i = 0; i < queryCount; i++) {
        	String query = in.nextLine();
        	System.out.println(instanceCount(query));
        }
    }

    /** Searches for a particular query in the String data.
    * @param query The query string to search for
    * @return Integer count of the number of times the given query appears.
    */
    private static int instanceCount(String query) {
    	Integer count = data.get(query);
    	if (count == null) { // if this doesn't exist in the dataset,
    		return 0;
    	}
    	return count;
    }
}
