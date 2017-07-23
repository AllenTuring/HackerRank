import java.io.*;
import java.util.*;

/**
* @author Allen Jiang
* Solution class for HackerRank
*/

public class Solution {

	/*
	Problem:
	You get two integers, N and M. Make a list of zeroes of size N.
	There are M commands that follow, of the format:
	a b k
	Meaning, add the number k to all integers at indices in the range a-b inclusive.
	Once you're done, spit out the biggest integer in the N-size list.
	*/

	// Read input scanner from system.in
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
        // Initialize the list
        int size = in.nextInt();
        initList(size);

        // Read commands
        int commandCount = in.nextInt();
        for (int i = 0; i < commandCount; i++) {
        	add(in.nextInt(), in.nextInt(), in.nextInt());
        }

        System.out.println(getMax());
    }

    /** Initializes a list of length size
    * @param size The size of the list to initialize
    */
    private static void initList(int size) {
    	// TODO stub
    }

    /** Adds a value onto a specified range of the list
    * @param val The value to be added
    * @param a The first index to be processed
    * @param b The last index to be processed
    */
    private static void add(int a, int b, int val) {
    	// TODO stub
    }

    /** Finds the maximum value in the list
    * @returns The maximum value in the ranged list
    */
    private static int getMax() {
    	// TODO stub
    	return 0;
    }
}
