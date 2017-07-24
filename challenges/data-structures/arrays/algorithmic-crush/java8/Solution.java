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
	Meaning, add the number k to all integers at indices in the range a-b inclusive. (1-indexed!)
	Once you're done, spit out the biggest integer in the N-size list.
	*/

	// Read input scanner from system.in
	private static Scanner in = new Scanner(System.in);
	private static PartitionedSumList list;

	public static void main(String[] args) {
        // Initialize the list
        int size = in.nextInt();
        initList(size);

        // Read commands
        int commandCount = in.nextInt();
        for (int i = 0; i < commandCount; i++) {
        	// Read in the command, swapping to zero indexed, inclusive-exclusive.
        	add(in.nextInt() - 1, in.nextInt(), in.nextInt());
        }

        System.out.println(getMax());
    }

    /** Initializes a list of length size
    * @param size The size of the list to initialize
    */
    private static void initList(int size) {
    	list = new PartitionedSumList(size);
    }

    /** Adds a value onto a specified range of the list
    * @param val The value to be added
    * @param a The first index to be processed
    * @param b The last index to be processed
    */
    private static void add(int a, int b, int val) {
    	list.add(a, b, val);
    }

    /** Finds the maximum value in the list
    * @returns The maximum value in the ranged list
    */
    private static int getMax() {
    	// TODO stub
    	return list.getMax();
    }

    /** Class to govern the list tracking, reduce redundancy */
    private static class PartitionedSumList {
    	// A list of values in sequential read order
    	private List<PartitionedSum> data;

    	/** Constructor to make a new PartitionedSumList.
    	* @param size The size of the imaginary list
    	*/
    	public PartitionedSumList(int size) {
    		this.data = new ArrayList<PartitionedSum>();
    		this.data.add(new PartitionedSum(0, size, 0));
    	}

    	/** Adds a value onto a specified range of the list
	    * @param val The value to be added
	    * @param a The first index to be processed
	    * @param b The last index to be processed
	    */
	    private void add(int a, int b, int val) {
    		int dataSize = data.size();
    		PartitionedSum datum;
    		// Loop through the data points backwards for inflation
	    	for (int i = dataSize - 1; i >= 0; i--) {
	    		datum = data.get(i); 
	    		// Ask each data node how the range [a, b) affects it
	    		if (datum.intersects(a, b)) {
	    			// If so we need to take action
	    			// Buffer off the first half if necessary
	    			if (datum.a < a) {
	    				// split into two along a
	    				PartitionedSum headSplit = new PartitionedSum(datum.a, a, datum.value);
	    				datum.a = a;
	    				// insert the new half in the data registry
	    				data.add(headSplit);
	    			}
	    			// Then the second half
	    			if (b < datum.b) {
	    				// split into two along b
	    				PartitionedSum tailSplit = new PartitionedSum(b, datum.b, datum.value);
	    				datum.b = b;
	    				// insert the new half in the data registry
	    				data.add(tailSplit);
	    			}
	    			// Finally add val to what's left in the middle.
		    		datum.value += val;
	    		}
	    		// If it doesn't apply, just skip (no code necessary)
	    	}
	    }

		/** Finds the maximum value of all partitioned sums
	    * @returns The largest partitioned sum
	    */
    	public int getMax() {
    		int max = data.get(0).value;
    		int dataSize = data.size();
    		// Loop through the data
    		for (int i = 0; i < dataSize; i++) {
    			// Get values, if they are bigger than max then set max to that
    			int val = data.get(i).value;
    			if (val > max) {
    				max = val;
    			}
    		}
    		return max;
    	}

    	private static class PartitionedSum {
    		// The value within this partition segment
    		public int value;
    		// The starting index of this segment (inclusive)
    		public int a;
    		// The ending index of this segment (inclusive)
    		public int b;

    		/** Constructor to make a new PartitionedSum
	    	* @param size The value inside this segment
	    	* @param a The starting index of this segment (inclusive)
	    	* @param b The ending index of this segment (exclusive)
	    	*/
	    	public PartitionedSum(int a, int b, int val) {
	    		this.value = val;
	    		this.a = a;
	    		this.b = b;
	    	}

	    	/** Returns whether or not the range [a, b) add operation applies to this partition's range
	    	* @return True if and only if the current node has interval overlap
	    	*/
	    	public boolean intersects(int a, int b) {
	    		return this.a < b && a < this.b;
	    	}
    	}
    }
}
