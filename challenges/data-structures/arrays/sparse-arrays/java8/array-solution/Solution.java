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
	private static String[] data;

	public static void main(String[] args) {
		// Read the Strings
        int stringCount = in.nextInt();
        in.nextLine(); // chuck 1 line buffer
        data = new String[stringCount];
        for (int i = 0; i < stringCount; i++) {
        	data[i] = in.nextLine();
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
    	int count = 0;
    	for (int i = 0; i < data.length; i++) {
    		if (data[i].equals(query)) {
    			count++;
    		}
    	}
    	return count;
    }
}