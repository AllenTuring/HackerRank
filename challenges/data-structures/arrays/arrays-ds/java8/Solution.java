import java.io.*;
import java.util.*;

/**
* @author Allen Jiang
* Solution class for HackerRank
*/

public class Solution {

	/*
	Problem TLDR:
	You get a number n, and then a list of integers of size n.
	Print the list in reverse.
	*/

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        // Read the array size, then create an output array of that size.
        int size = in.nextInt();
        int[] output = new int[size];
        // Write the array backwards to get the correct output.
        for (int i = output.length - 1; i >= 0; i--) {
            output[i] = in.nextInt();
        }
        // Although we could have built the string directly, we "should" use arrays here. Spirit of the problem.
        System.out.println(intArrayToString(output));
    }

    /** Converts an int array into a space-separated string.
    * @param input An array of integers
    * @returns A String containing the ints in input, separated by spaces.
    */
    private static String intArrayToString(int[] input) {
    	String output = "";
        for (int i = 0; i < input.length; i++) {
            // Add space before all but the first one
            if (i > 0) {
                output += " ";
            }
            // Add the next integer
            output += input[i];
        }
        return output;
    }
}
